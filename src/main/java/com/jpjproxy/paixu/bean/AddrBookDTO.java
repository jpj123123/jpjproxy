package com.jpjproxy.paixu.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Author: jingpj
 * @Date：creste in 2018/8/20
 */
@Data
public class AddrBookDTO {
    @JSONField(name="contact_name")
    private String name;
    @JSONField(name="contact_phone")
    private String phone;
    @JSONField(name="update_time",format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
