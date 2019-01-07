package com.jpjproxy.paixu.event;

import org.springframework.context.ApplicationEvent;


/**
 * 申请贷款触发该事件
 */
public class LoanEvent extends ApplicationEvent {
    private Long customerId;

    private Long loanId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LoanEvent(Object source, Long customerId, Long loanId) {
        super(source);
        this.customerId = customerId;
        this.loanId = loanId;
    }
}
