package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.dao.CustomerSmsMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerSms;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.service.CustomerSmsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class CustomerSmsServiceImpl implements CustomerSmsService {
    @Resource
    private CustomerSmsMapper customerSmsMapper;
    @Override
    public List<PaixuRequestBody.SmsBean> getSmsBeanListByCustomer(Customer customer) {
        List<CustomerSms> customerSmsList = getListByCustomer(customer);
        if (CollectionUtils.isNotEmpty(customerSmsList)){
            int size = customerSmsList.size();
            List<PaixuRequestBody.SmsBean> smsBeanList = new ArrayList<>();
            for (int i= 0 ;i<size;i++){
                PaixuRequestBody.SmsBean smsBean = new PaixuRequestBody.SmsBean();
                CustomerSms customerSms = customerSmsList.get(i);
                //短信内容
                smsBean.setContent(customerSms.getSmsContent());
                //1：接收 2：发送 3：草稿
                smsBean.setSms_type(customerSms.getSmsType());
                //短信发送时间
                if(customerSms.getSmsTime()!=null) {
                    smsBean.setSms_time(DateFormatUtils.format(customerSms.getSmsTime(), "yyyy-MM-dd HH:mm:ss"));
                }
                //对方手机号码
                smsBean.setPeer_number(customerSms.getLinkmanPhone());
                //抓取时间
                if (customerSms.getCreateTime()!=null) {
                    smsBean.setUpdate_time(DateFormatUtils.format(customerSms.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                }
                //接收方手机号码
                smsBean.setUser_mobile(customer.getPhoneNo());
                smsBeanList.add(smsBean);
            }
            return  smsBeanList;
        }
        return null;
    }

    private List<CustomerSms> getListByCustomer(Customer customer) {
        Assert.notNull(customer);
        if (StringUtils.isNotBlank(customer.getPhoneNo())){
            String tableIndex = customer.getPhoneNo().substring(9);
            String tableName = "t_customer_sms_"+ tableIndex;
            return customerSmsMapper.listByCustomerId(tableName,customer.getId());
        }else {
            return null;
        }
    }
}
