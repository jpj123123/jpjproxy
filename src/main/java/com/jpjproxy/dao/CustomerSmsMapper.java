package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerSms;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerSmsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerSms record);

    int insertSelective(CustomerSms record);

    CustomerSms selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerSms record);

    int updateByPrimaryKey(CustomerSms record);

    List<CustomerSms> listByCustomerId(@Param("tableName") String tableName,
                                              @Param("customerId") Long customerId);
}