package com.jpjproxy.paixu.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class PaixuResponseBody {

    /**
     * returnCode : 0
     * returnInfo : success
     * score : 477.57214644912864
     * decision : REJECT
     * requestId : 20181122181437-6a63494e-ee3f-11e8-b67c-00163e08585a
     */

    //0为正确结果，-1为异常
    @JSONField(name = "return_code")
    private Integer returnCode;
    //返回的错误信息
    @JSONField(name = "return_info")
    private String returnInfo;
    private Double score;
    private String decision;
    @JSONField(name = "request_id")
    private String requestId;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
