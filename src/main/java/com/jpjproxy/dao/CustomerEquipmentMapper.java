package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerEquipment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustomerEquipmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerEquipment record);

    int insertSelective(CustomerEquipment record);

    CustomerEquipment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerEquipment record);

    int updateByPrimaryKey(CustomerEquipment record);

    CustomerEquipment selectByCustomerId(@Param("customerId") Long customerId);
}