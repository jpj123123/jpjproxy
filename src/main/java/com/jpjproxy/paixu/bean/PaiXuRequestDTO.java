package com.jpjproxy.paixu.bean;

import lombok.Data;

/**
 * @Author: jingpj
 * @Date：creste in 2018/8/20
 */
@Data
public class PaiXuRequestDTO {
    private String merchantId;
    private String productId;
    private String userName;
    private String orderId;
    private String cardNum;
    private String mobile;
    private RiskDataDTO riskData;
    private Long timeStamp;
    private String sign;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public RiskDataDTO getRiskData() {
        return riskData;
    }

    public void setRiskData(RiskDataDTO riskData) {
        this.riskData = riskData;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
