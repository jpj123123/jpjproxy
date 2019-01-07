package com.jpjproxy.dao;

import com.jpjproxy.entity.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
//    @Select("SELECT customer_id  FROM `t_risk_result` WHERE `risk_score` >=500 AND `customer_id` NOT IN (SELECT `customer_id`  FROM `t_risk_result_check2` )")
//    List<Long> listCustomerId();
    @Select("SELECT id from `t_customer` WHERE `phone_no` IN ('13001558805',\n" +
            "'13144596679',\n" +
            "'13406969858',\n" +
            "'13750295715',\n" +
            "'13763218197',\n" +
            "'13952490220',\n" +
            "'18173257324',\n" +
            "'18270974830',\n" +
            "'18530895911')")
    List<Long> listCustomerId();
}