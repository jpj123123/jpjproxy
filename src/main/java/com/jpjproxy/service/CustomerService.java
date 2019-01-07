package com.jpjproxy.service;

import com.jpjproxy.entity.Customer;

import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
public interface CustomerService {
    Customer selectByPrimaryKey(Long id);

    List<Long> listCustomerId();
}
