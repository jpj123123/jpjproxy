package com.jpjproxy.dao;

import com.jpjproxy.entity.CustomerAppInstall;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerAppInstallMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerAppInstall record);

    int insertSelective(CustomerAppInstall record);

    CustomerAppInstall selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerAppInstall record);

    int updateByPrimaryKey(CustomerAppInstall record);
    //@Select("select * from  ${tableName}  where customer_id = #{customerId}")
    List<CustomerAppInstall> listBycustomerId(@Param("tableName") String tableName,
                                              @Param("customerId") Long customerId);
}