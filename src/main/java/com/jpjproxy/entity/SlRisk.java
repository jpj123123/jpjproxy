package com.jpjproxy.entity;

import java.util.Date;

public class SlRisk {
    private Long id;

    private String orgBizNo;

    private String sceneId;

    private Long customerId;

    private Integer score;

    private Date reqDate;

    private Date resDate;

    private String resData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgBizNo() {
        return orgBizNo;
    }

    public void setOrgBizNo(String orgBizNo) {
        this.orgBizNo = orgBizNo == null ? null : orgBizNo.trim();
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId == null ? null : sceneId.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public String getResData() {
        return resData;
    }

    public void setResData(String resData) {
        this.resData = resData == null ? null : resData.trim();
    }
}