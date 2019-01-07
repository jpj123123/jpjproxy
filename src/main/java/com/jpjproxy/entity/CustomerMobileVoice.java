package com.jpjproxy.entity;

import java.util.Date;

public class CustomerMobileVoice {
    private Long id;

    private Long customerId;

    private String phoneNo;

    private Integer isAddress;

    private Integer isEmergent;

    private String voiceNumber;

    private String addressName;

    private String voiceType;

    private Integer voiceDuration;

    private String voicePlace;

    private Date voiceDate;

    private String voiceStatus;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public Integer getIsAddress() {
        return isAddress;
    }

    public void setIsAddress(Integer isAddress) {
        this.isAddress = isAddress;
    }

    public Integer getIsEmergent() {
        return isEmergent;
    }

    public void setIsEmergent(Integer isEmergent) {
        this.isEmergent = isEmergent;
    }

    public String getVoiceNumber() {
        return voiceNumber;
    }

    public void setVoiceNumber(String voiceNumber) {
        this.voiceNumber = voiceNumber == null ? null : voiceNumber.trim();
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(String voiceType) {
        this.voiceType = voiceType == null ? null : voiceType.trim();
    }

    public Integer getVoiceDuration() {
        return voiceDuration;
    }

    public void setVoiceDuration(Integer voiceDuration) {
        this.voiceDuration = voiceDuration;
    }

    public String getVoicePlace() {
        return voicePlace;
    }

    public void setVoicePlace(String voicePlace) {
        this.voicePlace = voicePlace == null ? null : voicePlace.trim();
    }

    public Date getVoiceDate() {
        return voiceDate;
    }

    public void setVoiceDate(Date voiceDate) {
        this.voiceDate = voiceDate;
    }

    public String getVoiceStatus() {
        return voiceStatus;
    }

    public void setVoiceStatus(String voiceStatus) {
        this.voiceStatus = voiceStatus == null ? null : voiceStatus.trim();
    }
}