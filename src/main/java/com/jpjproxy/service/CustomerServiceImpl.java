package com.jpjproxy.service;

import com.jpjproxy.dao.CustomerMapper;
import com.jpjproxy.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public Customer selectByPrimaryKey(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Long> listCustomerId() {
        return customerMapper.listCustomerId();
    }
}
