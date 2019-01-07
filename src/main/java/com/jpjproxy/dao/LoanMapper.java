package com.jpjproxy.dao;

import com.jpjproxy.entity.Loan;

import java.util.List;

public interface LoanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);

    List<Long> listCustomerIdByLoan();
}