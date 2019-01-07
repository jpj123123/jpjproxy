package com.jpjproxy.paixu.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/8/20
 */
@Data
public class MobileInfoDTO {
    private String phoneNo;
    private String name;
    private String idcard;
    private String carrier;
    private String province;
    private String city;
    private Date openTime;
    private String level;
    private String packageName;
    private String state;
    private String availableBalance;
    private List<MobileBillDTO> bill;
    private Date mobileAuditTime;


    //原始路径
    private String filePath;
    //报告路径
    private String reportFile;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public List<MobileBillDTO> getBill() {
        return bill;
    }

    public void setBill(List<MobileBillDTO> bill) {
        this.bill = bill;
    }

    public Date getMobileAuditTime() {
        return mobileAuditTime;
    }

    public void setMobileAuditTime(Date mobileAuditTime) {
        this.mobileAuditTime = mobileAuditTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }
}
