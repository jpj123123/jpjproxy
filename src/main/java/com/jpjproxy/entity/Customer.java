package com.jpjproxy.entity;

import java.util.Date;

public class Customer {
    private Long id;

    private Long companyId;

    private String phoneNo;

    private String password;

    private String name;

    private String cardNumber;

    private Date birthday;

    private Integer sex;

    private Integer age;

    private String headimgUrl;

    private Integer status;

    private Integer certificationStatus;

    private Integer cardBindStatus;

    private Integer addrbookStatus;

    private Integer mobileStatus;

    private Integer zfbStatus;

    private Integer hasElinkman;

    private Date regDate;

    private Date activeDate;

    private Date authedDate;

    private Date lastLoginTime;

    private String clientId;

    private Integer isBlack;

    private Integer authedCredit;

    private Long agentId;

    private Integer agentMoney;

    private Long subAgentId;

    private Integer subAgentMoney;

    private Date lastLoanDate;

    private String phoneModel;

    private Integer sesameScore;

    private Byte channel;

    private String channelRemark;

    private Date channelTime;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl == null ? null : headimgUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(Integer certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public Integer getCardBindStatus() {
        return cardBindStatus;
    }

    public void setCardBindStatus(Integer cardBindStatus) {
        this.cardBindStatus = cardBindStatus;
    }

    public Integer getAddrbookStatus() {
        return addrbookStatus;
    }

    public void setAddrbookStatus(Integer addrbookStatus) {
        this.addrbookStatus = addrbookStatus;
    }

    public Integer getMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(Integer mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    public Integer getZfbStatus() {
        return zfbStatus;
    }

    public void setZfbStatus(Integer zfbStatus) {
        this.zfbStatus = zfbStatus;
    }

    public Integer getHasElinkman() {
        return hasElinkman;
    }

    public void setHasElinkman(Integer hasElinkman) {
        this.hasElinkman = hasElinkman;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Date getAuthedDate() {
        return authedDate;
    }

    public void setAuthedDate(Date authedDate) {
        this.authedDate = authedDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public Integer getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(Integer isBlack) {
        this.isBlack = isBlack;
    }

    public Integer getAuthedCredit() {
        return authedCredit;
    }

    public void setAuthedCredit(Integer authedCredit) {
        this.authedCredit = authedCredit;
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

    public Date getLastLoanDate() {
        return lastLoanDate;
    }

    public void setLastLoanDate(Date lastLoanDate) {
        this.lastLoanDate = lastLoanDate;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel == null ? null : phoneModel.trim();
    }

    public Integer getSesameScore() {
        return sesameScore;
    }

    public void setSesameScore(Integer sesameScore) {
        this.sesameScore = sesameScore;
    }

    public Byte getChannel() {
        return channel;
    }

    public void setChannel(Byte channel) {
        this.channel = channel;
    }

    public String getChannelRemark() {
        return channelRemark;
    }

    public void setChannelRemark(String channelRemark) {
        this.channelRemark = channelRemark == null ? null : channelRemark.trim();
    }

    public Date getChannelTime() {
        return channelTime;
    }

    public void setChannelTime(Date channelTime) {
        this.channelTime = channelTime;
    }
}