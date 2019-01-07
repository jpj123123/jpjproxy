package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.dao.CustomerCertifyMapper;
import com.jpjproxy.entity.CustomerCertify;
import com.jpjproxy.paixu.service.CustomerCertifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class CustomerCertifyServiceImpl implements CustomerCertifyService {
    @Resource
    private CustomerCertifyMapper customerCertifyMapper;
    @Override
    public CustomerCertify selectByCusId(Long customerId) {
        return customerCertifyMapper.selectByCusId(customerId);
    }
}
