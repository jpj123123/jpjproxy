package com.jpjproxy.entity;

public class CustomerAddrbook {
    private Long id;

    private Long companyId;

    private Long customerId;

    private Integer addrType;

    private String phoneNo;

    private String phoneName;

    private String relation;

    private Integer isRealtive;

    private Integer callsNumber;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getAddrType() {
        return addrType;
    }

    public void setAddrType(Integer addrType) {
        this.addrType = addrType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName == null ? null : phoneName.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public Integer getIsRealtive() {
        return isRealtive;
    }

    public void setIsRealtive(Integer isRealtive) {
        this.isRealtive = isRealtive;
    }

    public Integer getCallsNumber() {
        return callsNumber;
    }

    public void setCallsNumber(Integer callsNumber) {
        this.callsNumber = callsNumber;
    }
}