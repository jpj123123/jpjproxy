package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerAddrbook;
import com.jpjproxy.paixu.bean.CustomerAddrBookDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerAddrbookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerAddrbook record);

    int insertSelective(CustomerAddrbook record);

    CustomerAddrbook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerAddrbook record);

    int updateByPrimaryKey(CustomerAddrbook record);

    @Select("SELECT phone_no AS phoneNo, phone_name AS phoneName , calls_number AS callsNumber , is_realtive AS isRealtive , relation FROM ${tableName} WHERE customer_id =#{customerId} and addr_type <>3  ")
    List<CustomerAddrBookDto> listDTOByCustoemrId(@Param("tableName") String tableName,
                                                  @Param("customerId") Long customerId);
}