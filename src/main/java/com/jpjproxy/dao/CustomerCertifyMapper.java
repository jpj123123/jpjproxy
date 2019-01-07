package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerCertify;

public interface CustomerCertifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerCertify record);

    int insertSelective(CustomerCertify record);

    CustomerCertify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerCertify record);

    int updateByPrimaryKey(CustomerCertify record);

    CustomerCertify selectByCusId(Long customerId);
}