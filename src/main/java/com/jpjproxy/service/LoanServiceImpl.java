package com.jpjproxy.service;

import com.jpjproxy.dao.LoanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/5
 */
@Service
public class LoanServiceImpl implements LoanService {
    @Resource
    private LoanMapper loanMapper;

    @Override
    public List<Long> listCustomerIdByLoan() {
        return loanMapper.listCustomerIdByLoan();
    }
}
