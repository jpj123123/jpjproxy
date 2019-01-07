package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerMobileInfo;
import org.apache.ibatis.annotations.Select;

public interface CustomerMobileInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerMobileInfo record);

    int insertSelective(CustomerMobileInfo record);

    CustomerMobileInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerMobileInfo record);

    int updateByPrimaryKeyWithBLOBs(CustomerMobileInfo record);

    int updateByPrimaryKey(CustomerMobileInfo record);

    CustomerMobileInfo selectByCustomerId(Long customerId);
}