package com.jpjproxy.paixu.service;

import com.jpjproxy.entity.CustomerCertify;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
public interface CustomerCertifyService {
    CustomerCertify selectByCusId(Long customerId);
}
