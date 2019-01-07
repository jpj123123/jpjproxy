package com.jpjproxy.entity;

import java.util.Date;

public class Loan {
    private Long id;

    private Long companyId;

    private String orderNo;

    private Long customerId;

    private Integer loanType;

    private Date reqDate;

    private Integer reqMoney;

    private Integer handleFee;

    private Long handleFeePayid;

    private Integer downMoney;

    private Integer loanStatus;

    private Date auditTime;

    private Long auditorId;

    private String auditRemark;

    private Integer downType;

    private Date downTime;

    private Long downerId;

    private String downImg;

    private String downRemark;

    private Date startTime;

    private Date endTime;

    private Date lastOverdueTime;

    private Date nextOverdueTime;

    private Integer lateFee;

    private Integer offLatefee;

    private Long paybackPayid;

    private Date paybackDate;

    private Long agentId;

    private Integer agentMoney;

    private Long subAgentId;

    private Integer subAgentMoney;

    private String clientId;

    private String signImg;

    private Long overduerId;

    private Integer executionstatus;

    private Long badUserid;

    private Date badTime;

    private Long handcloseId;

    private String submittime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Integer getReqMoney() {
        return reqMoney;
    }

    public void setReqMoney(Integer reqMoney) {
        this.reqMoney = reqMoney;
    }

    public Integer getHandleFee() {
        return handleFee;
    }

    public void setHandleFee(Integer handleFee) {
        this.handleFee = handleFee;
    }

    public Long getHandleFeePayid() {
        return handleFeePayid;
    }

    public void setHandleFeePayid(Long handleFeePayid) {
        this.handleFeePayid = handleFeePayid;
    }

    public Integer getDownMoney() {
        return downMoney;
    }

    public void setDownMoney(Integer downMoney) {
        this.downMoney = downMoney;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public Integer getDownType() {
        return downType;
    }

    public void setDownType(Integer downType) {
        this.downType = downType;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Long getDownerId() {
        return downerId;
    }

    public void setDownerId(Long downerId) {
        this.downerId = downerId;
    }

    public String getDownImg() {
        return downImg;
    }

    public void setDownImg(String downImg) {
        this.downImg = downImg == null ? null : downImg.trim();
    }

    public String getDownRemark() {
        return downRemark;
    }

    public void setDownRemark(String downRemark) {
        this.downRemark = downRemark == null ? null : downRemark.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLastOverdueTime() {
        return lastOverdueTime;
    }

    public void setLastOverdueTime(Date lastOverdueTime) {
        this.lastOverdueTime = lastOverdueTime;
    }

    public Date getNextOverdueTime() {
        return nextOverdueTime;
    }

    public void setNextOverdueTime(Date nextOverdueTime) {
        this.nextOverdueTime = nextOverdueTime;
    }

    public Integer getLateFee() {
        return lateFee;
    }

    public void setLateFee(Integer lateFee) {
        this.lateFee = lateFee;
    }

    public Integer getOffLatefee() {
        return offLatefee;
    }

    public void setOffLatefee(Integer offLatefee) {
        this.offLatefee = offLatefee;
    }

    public Long getPaybackPayid() {
        return paybackPayid;
    }

    public void setPaybackPayid(Long paybackPayid) {
        this.paybackPayid = paybackPayid;
    }

    public Date getPaybackDate() {
        return paybackDate;
    }

    public void setPaybackDate(Date paybackDate) {
        this.paybackDate = paybackDate;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentMoney() {
        return agentMoney;
    }

    public void setAgentMoney(Integer agentMoney) {
        this.agentMoney = agentMoney;
    }

    public Long getSubAgentId() {
        return subAgentId;
    }

    public void setSubAgentId(Long subAgentId) {
        this.subAgentId = subAgentId;
    }

    public Integer getSubAgentMoney() {
        return subAgentMoney;
    }

    public void setSubAgentMoney(Integer subAgentMoney) {
        this.subAgentMoney = subAgentMoney;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getSignImg() {
        return signImg;
    }

    public void setSignImg(String signImg) {
        this.signImg = signImg == null ? null : signImg.trim();
    }

    public Long getOverduerId() {
        return overduerId;
    }

    public void setOverduerId(Long overduerId) {
        this.overduerId = overduerId;
    }

    public Integer getExecutionstatus() {
        return executionstatus;
    }

    public void setExecutionstatus(Integer executionstatus) {
        this.executionstatus = executionstatus;
    }

    public Long getBadUserid() {
        return badUserid;
    }

    public void setBadUserid(Long badUserid) {
        this.badUserid = badUserid;
    }

    public Date getBadTime() {
        return badTime;
    }

    public void setBadTime(Date badTime) {
        this.badTime = badTime;
    }

    public Long getHandcloseId() {
        return handcloseId;
    }

    public void setHandcloseId(Long handcloseId) {
        this.handcloseId = handcloseId;
    }

    public String getSubmittime() {
        return submittime;
    }

    public void setSubmittime(String submittime) {
        this.submittime = submittime == null ? null : submittime.trim();
    }
}