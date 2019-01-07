package com.jpjproxy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RiskResultCheck {
    private Long id;

    private Long customerId;

    private String authCompany;

    private BigDecimal riskScore;

    private String resultUrl;

    private String resultPdfUrl;

    private Integer result;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAuthCompany() {
        return authCompany;
    }

    public void setAuthCompany(String authCompany) {
        this.authCompany = authCompany == null ? null : authCompany.trim();
    }

    public BigDecimal getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(BigDecimal riskScore) {
        this.riskScore = riskScore;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl == null ? null : resultUrl.trim();
    }

    public String getResultPdfUrl() {
        return resultPdfUrl;
    }

    public void setResultPdfUrl(String resultPdfUrl) {
        this.resultPdfUrl = resultPdfUrl == null ? null : resultPdfUrl.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}