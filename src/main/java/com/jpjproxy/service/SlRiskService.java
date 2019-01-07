package com.jpjproxy.service;

import com.jpjproxy.entity.SlRisk;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
public interface SlRiskService {
    int insert(SlRisk record);

    int insertSelective(SlRisk record);

    SlRisk selectByPrimaryKey(Long id);
}
