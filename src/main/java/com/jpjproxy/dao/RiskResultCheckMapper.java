package com.jpjproxy.dao;

import com.jpjproxy.entity.RiskResult;
import com.jpjproxy.entity.RiskResultCheck;

public interface RiskResultCheckMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RiskResultCheck record);

    int insertSelective(RiskResultCheck record);

    RiskResultCheck selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RiskResultCheck record);

    int updateByPrimaryKey(RiskResultCheck record);

    void insertRiskResult(RiskResult tRiskResult);

    void deleteByCustomerId(Long customerId);
}