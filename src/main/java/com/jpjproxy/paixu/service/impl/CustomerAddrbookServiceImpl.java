package com.jpjproxy.paixu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jpjproxy.dao.CustomerAddrbookMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.paixu.bean.AddrBookDTO;
import com.jpjproxy.paixu.bean.CustomerAddrBookDto;
import com.jpjproxy.paixu.bean.EmergContact;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.service.CustomerAddrbookService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class CustomerAddrbookServiceImpl implements CustomerAddrbookService {
    @Resource
    private CustomerAddrbookMapper customerAddrbookMapper;
    @Override
    public List<PaixuRequestBody.ContactBean> getContactListByCustomer(Customer customer) {
        List<AddrBookDTO> list = listAddrBookByCustomerId(customer.getId(),customer.getPhoneNo());
        if (CollectionUtils.isNotEmpty(list)){
            List<PaixuRequestBody.ContactBean> contactBeanList = new ArrayList<>();
            int size = list.size();
            for (int i = 0 ;i<size;i++){
                PaixuRequestBody.ContactBean contactBean = new PaixuRequestBody.ContactBean();
                AddrBookDTO addrBookDTO = list.get(i);
                if (addrBookDTO.getUpdateTime()!=null) {
                    contactBean.setUpdate_time(DateFormatUtils.format(addrBookDTO.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
                }
                contactBean.setContact_phone(addrBookDTO.getPhone());
                contactBean.setContact_name(addrBookDTO.getName());
                contactBeanList.add(contactBean);
            }
            return contactBeanList;
        }
        return null;
    }

    private List<AddrBookDTO> listAddrBookByCustomerId(Long customerId, String phoneNo) {
        String index = phoneNo.substring(phoneNo.length() - 2, phoneNo.length());
        //String sql = "SELECT phone_no AS phoneNo, phone_name AS phoneName , calls_number AS callsNumber , is_realtive AS isRealtive , relation FROM t_customer_addrbook_" + index + " WHERE customer_id =? and addr_type <>3  ";
        List<CustomerAddrBookDto> list = customerAddrbookMapper.listDTOByCustoemrId("t_customer_addrbook_"+ index,customerId);
        List<AddrBookDTO> result = new ArrayList<>();
        for (CustomerAddrBookDto customerAddrBookDto : list){
            AddrBookDTO addrBookDTO = new AddrBookDTO();
            addrBookDTO.setName(customerAddrBookDto.getPhoneName());
            addrBookDTO.setPhone(customerAddrBookDto.getPhoneNo());
//            addrBookDTO.setUpdateTime(new Date());
            result.add(addrBookDTO);
        }
        return result;
    }

    @Override
    public List<PaixuRequestBody.EContactsBean> getEContactsBeanListByCustomer(Customer customer) {
        List<EmergContact> emergContactList = listEmergContactByCustomerId(customer.getId(),customer.getPhoneNo());
        if (CollectionUtils.isNotEmpty(emergContactList)){
            int size = emergContactList.size();
            List<PaixuRequestBody.EContactsBean> eContactsBeanList = new ArrayList<>();
            for (int i=0;i<size;i++){
                PaixuRequestBody.EContactsBean eContactsBean = new PaixuRequestBody.EContactsBean();
                EmergContact emergContact = emergContactList.get(0);
                eContactsBean.setContact_phone(emergContact.getPhone());
                eContactsBean.setContact_name(emergContact.getName());
                eContactsBeanList.add(eContactsBean);
            }
            return eContactsBeanList;
        }
        return null;
    }
    public List<EmergContact> listEmergContactByCustomerId(Long customerId, String phone){
        String index = phone.substring(phone.length() - 2, phone.length());
        String sql = "SELECT phone_no AS phoneNo, phone_name AS phoneName , calls_number AS callsNumber , is_realtive AS isRealtive , relation FROM t_customer_addrbook_" + index + " WHERE customer_id =? and  length(phone_no)=11 and phone_name is not null and addr_type != 3  ORDER BY calls_number desc ";
        List<CustomerAddrBookDto> list = customerAddrbookMapper.listDTOByCustoemrId("t_customer_addrbook_"+ index,customerId);
        List<EmergContact> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)){
            int listSize = list.size();
            if (listSize>=2){
                //第二个联系次数大于0的
                if (list.get(1).getCallsNumber()>0) {
                    for (int i = 0 ;i<=1 ;i++) {
                        EmergContact emergContact = new EmergContact();
                        emergContact.setName(list.get(i).getPhoneName());
                        emergContact.setRelation(list.get(i).getRelation());
                        emergContact.setPhone(list.get(i).getPhoneNo());
                        result.add(emergContact);
                    }
                }else {
                    for (int i = 0 ;i<listSize ;i++) {
                        if (list.get(i).getIsRealtive()==1){
                            EmergContact emergContact = new EmergContact();
                            emergContact.setRelation(list.get(i).getRelation());
                            emergContact.setName(list.get(i).getPhoneName());
                            emergContact.setPhone(list.get(i).getPhoneNo());
                            result.add(emergContact);
                        }
                        if (result.size()>=2){
                            break;
                        }
                    }
                }
            }else {
                EmergContact emergContact = new EmergContact();
                emergContact.setRelation(list.get(0).getPhoneName());
                emergContact.setPhone(list.get(0).getPhoneNo());
                emergContact.setName(list.get(0).getPhoneName());
                result.add(emergContact);
            }
        }else {
            return  null;
        }
        return result;
    }
}
