package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerMobileVoice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerMobileVoiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerMobileVoice record);

    int insertSelective(CustomerMobileVoice record);

    CustomerMobileVoice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerMobileVoice record);

    int updateByPrimaryKey(CustomerMobileVoice record);
    @Select("select *  from ${tableName} where customer_id = #{customerId} ")
    List<CustomerMobileVoice> listByCustomerId(@Param("tableName") String tableName,
                                               @Param("customerId") Long customerId);
}