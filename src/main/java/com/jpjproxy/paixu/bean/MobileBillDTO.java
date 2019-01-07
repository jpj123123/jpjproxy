package com.jpjproxy.paixu.bean;

import lombok.Data;

/**
 * 运营商账单信息
 * @Author: jingpj
 * @Date：creste in 2018/8/20
 */
@Data
public class MobileBillDTO {
    private String billMonth;
    private Double billAmount;

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }
}
