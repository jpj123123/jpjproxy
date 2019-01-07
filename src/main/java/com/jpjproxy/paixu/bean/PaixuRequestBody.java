package com.jpjproxy.paixu.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import util.HttpClient4Utils;

import java.util.ArrayList;
import java.util.List;

public class PaixuRequestBody {


    /**
     * model_name : zhaofan_v1
     * apply_time : 2018-06-10 14:00:00
     * mobile : 13531241342
     * name : 李宁
     * idcard : 310103198511154364
     * phone_os : ios
     * device_id : 9C287922-EE26-4501-94B5-DDE6F83E1475
     * gps_coordinate : BD09
     * gps_lat : 30.5
     * gps_lon : 134.5
     * user_address : 广西壮族自治区-玉林市-北流市-甘新路文德花园13栋2单元601
     * company_name : 广西天奥物业服务有限责任公司
     * company_phone : 07753294448
     * company_address : 广西壮族自治区-玉林市-北流市-二环北路幸福里小区1栋101
     * e_contacts : [{"contact_name":"郑瑞清","contact_phone":"15277750248"},{"contact_name":"匡丽","contact_phone":"18276511809"}]
     * carrier_data : {"jxl_raw":"...","jxl_report":"...","mx_raw":"...","mx_report":"...","dhb_raw":"...","dhb_report":"...","rong360_raw":"...","rong360_report":"...","tongdun_raw":"...","tongdun_report":"...","bqs_raw":"...","bqs_report":"..."}
     * contact : [{"contact_name":"大黄","contact_phone":"18514030324","update_time":"2018-06-10 09:00:00"},{"contact_name":"大哥","contact_phone":"13520166165","update_time":"2018-06-10 09:00:00"}]
     * app : [{"app_name":"搜狗输入法","app_packagename":"com.sohu.inputmethod.sogou","update_time":"2018-06-10 09:00:00"},{"app_name":"财神爷金服","app_packagename":"com.csyjf.app","update_time":"2018-06-10 09:00:00"}]
     * sms : [{"user_mobile":"13543946554","peer_number":"106908407250316","content":"【拍拍贷】早春特权大放送，3步完成申请，5分钟快速到账，现金额度随借随提！十年老平台保障您的信息安全，戳→http://t.cn/RJoVQzL 退订回N","sms_time":"2018-03-29 11:38:05","sms_type":1,"update_time":"2018-06-10 09:00:00"},{"user_mobile":"13543946554","peer_number":"106900195885","content":"【国美金融】您有5万元额度待领取，点击http://t.cn/RQ6JiYO 即可快速提现！现在注册并领取额度，有机会赢取0息特权！回TD退","sms_time":"2018-03-29 11:21:14","sms_type":1,"update_time":"2018-06-10 09:00:00"}]
     * call_record : [{"user_mobile":"13543946554","peer_number":"15039056615","call_type":2,"duration_time":13,"call_time":"2018-03-29 11:21:14","update_time":"2018-06-10 09:00:00"},{"user_mobile":"13543946554","peer_number":"15509681279","call_type":1,"duration_time":71,"call_time":"2018-03-29 11:21:14","update_time":"2018-06-10 09:00:00"}]
     */

    private String model_name;
    private String apply_time;
    private String mobile;
    private String name;
    private String idcard;
    private String phone_os;
    private String device_id;
    private String gps_coordinate;
    private double gps_lat;
    private double gps_lon;
    private String user_address;
    private String company_name;
    private String company_phone;
    private String company_address;
    private CarrierDataBean carrier_data;
    private List<EContactsBean> e_contacts;
    private List<ContactBean> contact;
    private List<AppBean> app;
    private List<SmsBean> sms;
    private List<CallRecordBean> call_record;

    public PaixuRequestBody(){

    }
    //测试使用
    public PaixuRequestBody(String name){
        this.name = name;
        this.mobile= "15824275713";
        this.idcard="429001198802191670";
        this.phone_os="android";
        this.gps_lat=21.32111;
        this.gps_lon= 128.33222;
        this.model_name="zhaofan_v1";
        List<EContactsBean> eContactsBeanList = new ArrayList<>();
        EContactsBean eContactsBean = new EContactsBean();
        eContactsBean.setContact_name("习近平");
        eContactsBean.setContact_phone("13588888888");
        eContactsBeanList.add(eContactsBean);
        EContactsBean eContactsBean1 = new EContactsBean();
        eContactsBean1.setContact_name("李克强");
        eContactsBean1.setContact_phone("15888888888");
        eContactsBeanList.add(eContactsBean1);
        this.e_contacts = eContactsBeanList;
        CarrierDataBean carrierDataBean = new CarrierDataBean();
        String mxRaw = HttpClient4Utils.httpGet("https://zhaofan.b0.upaiyun.com/server/other/20181120/138e66ebd3358e828e8533fb4a480959.json");
//        carrierDataBean.setMx_raw("https://zhaofan.b0.upaiyun.com/server/other/20181120/138e66ebd3358e828e8533fb4a480959.json");
        carrierDataBean.setMx_raw(JSONObject.parseObject(mxRaw));
        String mxReport = HttpClient4Utils.httpGet("https://zhaofan.b0.upaiyun.com/server/other/20181120/968e09016e16dc9c086d9c0ce2cc237a.json");
        carrierDataBean.setMx_report(JSONObject.parseObject(mxReport));
        this.carrier_data = carrierDataBean;
        List<ContactBean> contactBeanList = new ArrayList<>();
        ContactBean contactBean = new ContactBean();
        contactBean.setContact_name("汪洋");
        contactBean.setContact_phone("15988888888");
        contactBean.setUpdate_time("2018-11-10 09:00:00");
        contactBeanList.add(contactBean);
        this.contact = contactBeanList;
        this.setUser_address("广西壮族自治区-玉林市-北流市-甘新路文德花园13栋2单元601");
        this.setApply_time("2018-11-12 12:00:00");

    }

    public static void main(String[] args) {
        String mxRaw = HttpClient4Utils.httpGet("https://zhaofan.b0.upaiyun.com/server/other/20181120/138e66ebd3358e828e8533fb4a480959.json");
        System.out.println(mxRaw);
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getPhone_os() {
        return phone_os;
    }

    public void setPhone_os(String phone_os) {
        this.phone_os = phone_os;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getGps_coordinate() {
        return gps_coordinate;
    }

    public void setGps_coordinate(String gps_coordinate) {
        this.gps_coordinate = gps_coordinate;
    }

    public double getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(double gps_lat) {
        this.gps_lat = gps_lat;
    }

    public double getGps_lon() {
        return gps_lon;
    }

    public void setGps_lon(double gps_lon) {
        this.gps_lon = gps_lon;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public CarrierDataBean getCarrier_data() {
        return carrier_data;
    }

    public void setCarrier_data(CarrierDataBean carrier_data) {
        this.carrier_data = carrier_data;
    }

    public List<EContactsBean> getE_contacts() {
        return e_contacts;
    }

    public void setE_contacts(List<EContactsBean> e_contacts) {
        this.e_contacts = e_contacts;
    }

    public List<ContactBean> getContact() {
        return contact;
    }

    public void setContact(List<ContactBean> contact) {
        this.contact = contact;
    }

    public List<AppBean> getApp() {
        return app;
    }

    public void setApp(List<AppBean> app) {
        this.app = app;
    }

    public List<SmsBean> getSms() {
        return sms;
    }

    public void setSms(List<SmsBean> sms) {
        this.sms = sms;
    }

    public List<CallRecordBean> getCall_record() {
        return call_record;
    }

    public void setCall_record(List<CallRecordBean> call_record) {
        this.call_record = call_record;
    }

    public static class CarrierDataBean {
        /**
         * jxl_raw : ...
         * jxl_report : ...
         * 魔蝎原始数据
         * mx_raw : ...
         * 魔蝎报告
         * mx_report : ...
         * dhb_raw : ...
         * dhb_report : ...
         * rong360_raw : ...
         * rong360_report : ...
         * tongdun_raw : ...
         * tongdun_report : ...
         * bqs_raw : ...
         * bqs_report : ...
         */

        private JSONObject jxl_raw;
        private JSONObject jxl_report;
        private JSONObject mx_raw;
        private JSONObject mx_report;
        private JSONObject dhb_raw;
        private JSONObject dhb_report;
        private JSONObject rong360_raw;
        private JSONObject rong360_report;
        private JSONObject tongdun_raw;
        private JSONObject tongdun_report;
        private JSONObject bqs_raw;
        private JSONObject bqs_report;

        @JSONField(serialize = false)
        private String authChannel;

        public JSONObject getJxl_raw() {
            return jxl_raw;
        }

        public void setJxl_raw(JSONObject jxl_raw) {
            this.jxl_raw = jxl_raw;
        }

        public JSONObject getJxl_report() {
            return jxl_report;
        }

        public void setJxl_report(JSONObject jxl_report) {
            this.jxl_report = jxl_report;
        }

        public void setDhb_raw(JSONObject dhb_raw) {
            this.dhb_raw = dhb_raw;
        }

        public void setDhb_report(JSONObject dhb_report) {
            this.dhb_report = dhb_report;
        }

        public void setRong360_raw(JSONObject rong360_raw) {
            this.rong360_raw = rong360_raw;
        }

        public void setRong360_report(JSONObject rong360_report) {
            this.rong360_report = rong360_report;
        }

        public void setTongdun_raw(JSONObject tongdun_raw) {
            this.tongdun_raw = tongdun_raw;
        }

        public void setTongdun_report(JSONObject tongdun_report) {
            this.tongdun_report = tongdun_report;
        }

        public void setBqs_raw(JSONObject bqs_raw) {
            this.bqs_raw = bqs_raw;
        }

        public void setBqs_report(JSONObject bqs_report) {
            this.bqs_report = bqs_report;
        }

        public JSONObject getMx_raw() {
            return mx_raw;
        }

        public void setMx_raw(JSONObject mx_raw) {
            this.mx_raw = mx_raw;
        }

        public JSONObject getMx_report() {
            return mx_report;
        }

        public void setMx_report(JSONObject mx_report) {
            this.mx_report = mx_report;
        }

        public JSONObject getDhb_raw() {
            return dhb_raw;
        }

        public JSONObject getDhb_report() {
            return dhb_report;
        }

        public JSONObject getRong360_raw() {
            return rong360_raw;
        }

        public JSONObject getRong360_report() {
            return rong360_report;
        }

        public JSONObject getTongdun_raw() {
            return tongdun_raw;
        }

        public JSONObject getTongdun_report() {
            return tongdun_report;
        }

        public JSONObject getBqs_raw() {
            return bqs_raw;
        }

        public JSONObject getBqs_report() {
            return bqs_report;
        }

        public String getAuthChannel() {
            return authChannel;
        }

        public void setAuthChannel(String authChannel) {
            this.authChannel = authChannel;
        }
    }

    public static class EContactsBean {
        /**
         * contact_name : 郑瑞清
         * contact_phone : 15277750248
         */

        private String contact_name;
        private String contact_phone;

        public String getContact_name() {
            return contact_name;
        }

        public void setContact_name(String contact_name) {
            this.contact_name = contact_name;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }
    }

    public static class ContactBean {
        /**
         * contact_name : 大黄
         * contact_phone : 18514030324
         * update_time : 2018-06-10 09:00:00
         */

        private String contact_name;
        private String contact_phone;
        private String update_time;

        public String getContact_name() {
            return contact_name;
        }

        public void setContact_name(String contact_name) {
            this.contact_name = contact_name;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }

    public static class AppBean {
        /**
         * app_name : 搜狗输入法
         * app_packagename : com.sohu.inputmethod.sogou
         * update_time : 2018-06-10 09:00:00
         */

        private String app_name;
        private String app_packagename;
        private String update_time;

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public String getApp_packagename() {
            return app_packagename;
        }

        public void setApp_packagename(String app_packagename) {
            this.app_packagename = app_packagename;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }

    public static class SmsBean {
        /**
         * user_mobile : 13543946554
         * peer_number : 106908407250316
         * content : 【拍拍贷】早春特权大放送，3步完成申请，5分钟快速到账，现金额度随借随提！十年老平台保障您的信息安全，戳→http://t.cn/RJoVQzL 退订回N
         * sms_time : 2018-03-29 11:38:05
         * sms_type : 1
         * update_time : 2018-06-10 09:00:00
         */

        private String user_mobile;
        private String peer_number;
        private String content;
        private String sms_time;
        private int sms_type;
        private String update_time;

        public String getUser_mobile() {
            return user_mobile;
        }

        public void setUser_mobile(String user_mobile) {
            this.user_mobile = user_mobile;
        }

        public String getPeer_number() {
            return peer_number;
        }

        public void setPeer_number(String peer_number) {
            this.peer_number = peer_number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSms_time() {
            return sms_time;
        }

        public void setSms_time(String sms_time) {
            this.sms_time = sms_time;
        }

        public int getSms_type() {
            return sms_type;
        }

        public void setSms_type(int sms_type) {
            this.sms_type = sms_type;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }

    public static class CallRecordBean {
        /**
         * user_mobile : 13543946554
         * peer_number : 15039056615
         * call_type : 2
         * duration_time : 13
         * call_time : 2018-03-29 11:21:14
         * update_time : 2018-06-10 09:00:00
         */

        private String user_mobile;
        private String peer_number;
        private int call_type;
        private int duration_time;
        private String call_time;
        private String update_time;

        public String getUser_mobile() {
            return user_mobile;
        }

        public void setUser_mobile(String user_mobile) {
            this.user_mobile = user_mobile;
        }

        public String getPeer_number() {
            return peer_number;
        }

        public void setPeer_number(String peer_number) {
            this.peer_number = peer_number;
        }

        public int getCall_type() {
            return call_type;
        }

        public void setCall_type(int call_type) {
            this.call_type = call_type;
        }

        public int getDuration_time() {
            return duration_time;
        }

        public void setDuration_time(int duration_time) {
            this.duration_time = duration_time;
        }

        public String getCall_time() {
            return call_time;
        }

        public void setCall_time(String call_time) {
            this.call_time = call_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
