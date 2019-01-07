package com.jpjproxy.paixu.service;

import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerMobileInfo;
import com.jpjproxy.paixu.bean.PaixuRequestBody;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
public interface CustomerMobileInfoService {
    //from TCustomerMobileInfo where customerId=? order by id desc limit 0, 1
    CustomerMobileInfo selectByCustomerId(Long customerId);

    PaixuRequestBody.CarrierDataBean getCarrierDataBean(Customer customer);
}
