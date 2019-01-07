package com.jpjproxy.paixu.service;

import com.jpjproxy.entity.RiskResult; /**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
public interface RiskResultService {
    void executeUpdate(Long customerId);

    void save(RiskResult tRiskResult);
}
