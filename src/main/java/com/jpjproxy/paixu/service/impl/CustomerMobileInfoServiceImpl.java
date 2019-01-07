package com.jpjproxy.paixu.service.impl;

import com.alibaba.fastjson.JSON;
import com.jpjproxy.dao.CustomerMobileInfoMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerMobileInfo;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.constants.MobileInfoConstants;
import com.jpjproxy.paixu.service.CustomerMobileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import util.HttpClient4Utils;

import javax.annotation.Resource;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Slf4j
@Service
public class CustomerMobileInfoServiceImpl implements CustomerMobileInfoService {
    @Resource
    private CustomerMobileInfoMapper customerMobileInfoMapper;
    @Override
    public CustomerMobileInfo selectByCustomerId(Long customerId) {
        return customerMobileInfoMapper.selectByCustomerId(customerId);
    }

    @Override
    public PaixuRequestBody.CarrierDataBean getCarrierDataBean(Customer customer) {
//        String hql = "from TCustomerMobileInfo where customerId = ? order by id desc limit 0 ,1";
        CustomerMobileInfo customerMobileInfo = selectByCustomerId(customer.getId());
        if (customerMobileInfo!=null){
            PaixuRequestBody.CarrierDataBean carrierDataBean = new PaixuRequestBody.CarrierDataBean();
            carrierDataBean.setAuthChannel(customerMobileInfo.getAuthChannel());
            if (StringUtils.isNotBlank(customerMobileInfo.getReportFile())){
                String report = HttpClient4Utils.httpGet(customerMobileInfo.getReportFile());
                if(MobileInfoConstants.AUTH_CHANNEL_MOHE.equals(customerMobileInfo.getAuthChannel())){
                    carrierDataBean.setTongdun_report(JSON.parseObject(report));
                }else {
                    carrierDataBean.setMx_report(JSON.parseObject(report));
                }
            }
            if (StringUtils.isNotBlank(customerMobileInfo.getFilePath())){
                String report = HttpClient4Utils.httpGet(customerMobileInfo.getFilePath());
                if(MobileInfoConstants.AUTH_CHANNEL_MOHE.equals(customerMobileInfo.getAuthChannel())){
                    carrierDataBean.setTongdun_raw(JSON.parseObject(report));
                }else {
                    carrierDataBean.setMx_raw(JSON.parseObject(report));
                }
            }
            return carrierDataBean;
        }
        return null;
    }
}
