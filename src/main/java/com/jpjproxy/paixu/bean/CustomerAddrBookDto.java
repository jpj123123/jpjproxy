package com.jpjproxy.paixu.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerAddrBookDto implements Serializable {

    private String phoneName;

    private String phoneNo;

    private int callsNumber;

    private int isRealtive;

    private String relation;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public void setCallsNumber(int callsNumber) {
        this.callsNumber = callsNumber;
    }

    public int getIsRealtive() {
        return isRealtive;
    }

    public void setIsRealtive(int isRealtive) {
        this.isRealtive = isRealtive;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
