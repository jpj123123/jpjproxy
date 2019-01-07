package com.jpjproxy.dao;

import com.jpjproxy.entity.SlRisk;

public interface SlRiskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SlRisk record);

    int insertSelective(SlRisk record);

    SlRisk selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SlRisk record);

    int updateByPrimaryKeyWithBLOBs(SlRisk record);

    int updateByPrimaryKey(SlRisk record);
}