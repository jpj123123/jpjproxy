package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.dao.CustomerEquipmentMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerEquipment;
import com.jpjproxy.paixu.service.CustomerEquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class CustomerEquipmentServiceImpl implements CustomerEquipmentService {
    @Resource
    private CustomerEquipmentMapper customerEquipmentMapper;
    @Override
    public CustomerEquipment selectByCustomerId(Long customerId) {
        return customerEquipmentMapper.selectByCustomerId(customerId);
    }
}
