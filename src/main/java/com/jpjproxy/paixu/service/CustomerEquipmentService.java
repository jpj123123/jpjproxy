package com.jpjproxy.paixu.service;

import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerEquipment;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
public interface CustomerEquipmentService {
    CustomerEquipment selectByCustomerId(Long customerId);
}
