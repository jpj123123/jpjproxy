package com.jpjproxy.paixu.service;

import com.jpjproxy.entity.Customer;
import com.jpjproxy.paixu.bean.PaixuRequestBody;

import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
public interface CustomerSmsService {
    List<PaixuRequestBody.SmsBean> getSmsBeanListByCustomer(Customer customer);
}
