package com.jpjproxy.paixu.service;

import java.util.Map;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */

public interface ReadService {
    Map<String,Object> findOneMapBySql(Object ... value);
}
