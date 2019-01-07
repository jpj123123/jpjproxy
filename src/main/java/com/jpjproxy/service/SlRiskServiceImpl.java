package com.jpjproxy.service;

import com.jpjproxy.dao.SlRiskMapper;
import com.jpjproxy.entity.SlRisk;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
@Service
public class SlRiskServiceImpl implements SlRiskService {
    @Resource
    private SlRiskMapper slRiskMapper;
    @Override
    public int insert(SlRisk record) {
        return slRiskMapper.insert(record);
    }

    @Override
    public int insertSelective(SlRisk record) {
        return slRiskMapper.insertSelective(record);
    }

    @Override
    public SlRisk selectByPrimaryKey(Long id) {
        return slRiskMapper.selectByPrimaryKey(id);
    }
}
