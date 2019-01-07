package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.dao.RiskResultCheckMapper;
import com.jpjproxy.entity.RiskResult;
import com.jpjproxy.paixu.service.RiskResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class RiskResultServiceImpl implements RiskResultService {
    @Resource
    private RiskResultCheckMapper riskResultCheckMapper;
    @Override
    public void executeUpdate(Long customerId) {
        riskResultCheckMapper.deleteByCustomerId(customerId);
    }

    @Override
    public void save(RiskResult tRiskResult) {
        riskResultCheckMapper.insertRiskResult(tRiskResult);
    }
}
