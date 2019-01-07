package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.paixu.service.ReadService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Service
public class ReadServiceImlp implements ReadService {
    @Resource
    SqlSessionFactory sqlSessionFactory;
    @Override
    public Map<String, Object> findOneMapBySql(Object... value) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlSession.selectMap(sql, )
        return null;
    }
}
