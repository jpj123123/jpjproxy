package com.jpjproxy.dao;

import com.jpjproxy.entity.RiskResult;

public interface RiskResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RiskResult record);

    int insertSelective(RiskResult record);

    RiskResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RiskResult record);

    int updateByPrimaryKey(RiskResult record);
}