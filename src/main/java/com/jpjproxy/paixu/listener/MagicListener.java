package com.jpjproxy.paixu.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerCertify;
import com.jpjproxy.entity.CustomerEquipment;
import com.jpjproxy.entity.RiskResult;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.bean.PaixuResponseBody;
import com.jpjproxy.paixu.constants.MobileInfoConstants;
import com.jpjproxy.paixu.event.MagicEvent;
import com.jpjproxy.paixu.service.*;
import com.jpjproxy.paixu.util.PaiXuFengUtil;
import com.jpjproxy.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import util.DateUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Component
public class MagicListener implements ApplicationListener<MagicEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RiskResultService riskResultService;

    @Autowired
    private ReadService readService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAddrbookService customerAddrbookService;

    @Autowired
    private CustomerCertifyService customerCertifyService;

    @Autowired
    private CustomerMobileVoiceService customerMobileVoiceService;

    @Autowired
    private CustomerSmsService customerSmsService;

    @Autowired
    private CustomerEquipmentService customerEquipmentService;

    @Resource
    private CustomerAppInstallService customerAppInstallService;

    @Resource
    private CustomerMobileInfoService customerMobileInfoService;


    @Override
    public void onApplicationEvent(MagicEvent magicEvent) {

        //排序风项未配置或者配置为0不开启

        logger.info("开始调用排序风");
        Customer customer = magicEvent.getCustomer();
        if (customer!=null&&customer.getId()!=null){
            try {
                        logger.info("开始调用排序风"+customer.getPhoneNo());
                        //PXF_NEW 0 老排序分 1 新排序分
                       if( "1".equals("1")){
                           logger.info("------新-----");
                           invokeNewPaiXuFen(customer.getId());
                       }else{
                           logger.info("------旧-----");
                           invokePaiXuFeng(customer.getId());
                       }

                } catch (Exception e) {
                e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }

    }

    private void invokePaiXuFeng(Long customerId) throws Exception {

//        //调用排序分接口
//        PaiXuFengUtil paiXuFengUtil = new PaiXuFengUtil();
//        String responseStr = paiXuFengUtil.httpPost(customerId);
//        JSONObject jsonObject = JSONObject.parseObject(responseStr);
//        PaiXuFengResult paiXuFengResult = JSONObject.parseObject(responseStr,PaiXuFengResult.class);
//        TRiskResult tRiskResult = new TRiskResult();
//        tRiskResult.setCreateTime(new Date());
//        tRiskResult.setCustomerId(customerId);
//        if (paiXuFengResult!=null && ("000000".equals(paiXuFengResult.getResCode())&&"APPROVE".equals(paiXuFengResult.getResult()))){
//            tRiskResult.setResult(1);
//        }else {
//            tRiskResult.setResult(2);
//        }
//        //根据模板生成响应的文件
//        if(paiXuFengResult!=null && ("000000".equals(paiXuFengResult.getResCode()))){
//            String url = FreeMarkerUtil.getPxfH5URL(jsonObject, DateUtil.getCurrDate("yyyyMMddHHmmss") + String.format("%09d", customerId));
//            tRiskResult.setResultUrl(url);
//        }
//        if (paiXuFengResult!=null && paiXuFengResult.getRiskScore()!=null) {
//            tRiskResult.setRiskScore(new BigDecimal(paiXuFengResult.getRiskScore()));
//        }
//        String phoneNo = String.valueOf(customerId);
//        //先删除排序分数据,再插入排序分
//        String delSql = "delete from t_risk_result where customer_id = ? ";
//        //加锁处理
//        synchronized (phoneNo) {
//            riskResultService.executeUpdate(delSql, customerId);
//            riskResultService.save(tRiskResult);
//        }
//        //自动审核
//        mobileStatusCheck(tRiskResult,customerId);
    }

    private void invokeNewPaiXuFen(Long customerId) throws Exception {
        //获取客户信息
        Customer customer = customerService.selectByPrimaryKey(customerId);
        Assert.notNull(customer);
        PaixuRequestBody paixuRequestBody = new PaixuRequestBody();

        paixuRequestBody.setName(customer.getName());
        //手机号
        paixuRequestBody.setMobile(customer.getPhoneNo());
        //身份证号
        paixuRequestBody.setIdcard(customer.getCardNumber());
        //手机系统
        paixuRequestBody.setPhone_os(customer.getPhoneModel());
        paixuRequestBody.setApply_time(DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        CustomerCertify tCustomerCertify = customerCertifyService.selectByCusId(customerId);
        //注册地信息,注册地信息从实名认证中获取
        if (tCustomerCertify!=null) {
            paixuRequestBody.setUser_address(StringUtils.isNotBlank(tCustomerCertify.getRegAddress())?tCustomerCertify.getRegAddress():tCustomerCertify.getRegCity());
        }
        //gps位置等信息
        CustomerEquipment customerEquipment = customerEquipmentService.selectByCustomerId(customerId);
       if (customerEquipment!=null) {
           paixuRequestBody.setGps_coordinate(customerEquipment.getGpsCoordinate());
           paixuRequestBody.setGps_lat(NumberUtils.toDouble(customerEquipment.getGpsLatitude(), 0.0));
           paixuRequestBody.setGps_lon(NumberUtils.toDouble(customerEquipment.getGpsLongitude(), 0.0));
       }
        //安装app的信息
        paixuRequestBody.setApp(customerAppInstallService.getAppBeanListByCustomer(customer));
        //通话记录的获取
        paixuRequestBody.setCall_record(customerMobileVoiceService.getCallBeanListByCustomer(customer));
        //短信的配置
        paixuRequestBody.setSms(customerSmsService.getSmsBeanListByCustomer(customer));
        //通讯录的配置
        paixuRequestBody.setContact(customerAddrbookService.getContactListByCustomer(customer));
        //紧急联系人的获取
        paixuRequestBody.setE_contacts(customerAddrbookService.getEContactsBeanListByCustomer(customer));
        PaixuRequestBody.CarrierDataBean carrierData = customerMobileInfoService.getCarrierDataBean(customer);
        //运营商报文
        paixuRequestBody.setCarrier_data(carrierData);
        if(MobileInfoConstants.AUTH_CHANNEL_MOHE.equals(carrierData.getAuthChannel())){//魔盒数据
            paixuRequestBody.setModel_name("zhaofan_v2_offline");
        } else {//魔蝎数据
            paixuRequestBody.setModel_name("zhaofan_v1_offline");
        }
        //---------以上为请求对象的封装
        //调用排序分接口
        PaiXuFengUtil paiXuFengUtil = new PaiXuFengUtil();
        logger.info("排序分调用第三方接口，customerPhone:{}",paixuRequestBody.getMobile());
        logger.info("请求排序风控数据:  req: {}", JSON.toJSONString(paixuRequestBody));
        return;
//        String responseStr = paiXuFengUtil.gizHttpPost(paixuRequestBody);
//        //对报文的处理。
//        processResponse(responseStr,customer);
    }

    /**
     * 对响应报文进行相关的处理。保存相关信息
     * 两种响应报文
     * {"return_code": 0, "return_info": "success", "score": 479.9088007240559, "decision": "R
     * EJECT", "request_id": "20181127150851-4b7a65d0-f213-11e8-b98a-00163e08cc27"}
     * {"return_code": 0, "return_info": "success", "score": 607.5980833729
     * 498, "decision": "APPROVE", "request_id": "20181127150851-4b49149e-f213-11e8-b72f-00163e08585a"}
     * @param response
     * @param customer
     */
    private void processResponse(String response, Customer customer){
        logger.info("排序分结果解析------------");
        PaixuResponseBody paixuResponseBody = JSONObject.parseObject(response,PaixuResponseBody.class);
        RiskResult tRiskResult = new RiskResult();
        tRiskResult.setCreateTime(new Date());
        tRiskResult.setCustomerId(customer.getId());
        //正常返回
        if (paixuResponseBody!=null&&paixuResponseBody.getReturnCode()!=null&&paixuResponseBody.getReturnCode()==0){
            tRiskResult.setRiskScore(new BigDecimal(paixuResponseBody.getScore()));
            if ("APPROVE".equalsIgnoreCase(paixuResponseBody.getDecision())){
                tRiskResult.setResult(1);
            }else {
                tRiskResult.setResult(2);
            }
        }else{
            tRiskResult.setResult(2);
            tRiskResult.setRiskScore(new BigDecimal(0));
            if(paixuResponseBody!=null&&paixuResponseBody.getReturnCode()!=null&&paixuResponseBody.getReturnCode()==-1) {
                tRiskResult.setRemark(paixuResponseBody.getReturnInfo());
            }else {
                tRiskResult.setRemark(response.length()>100?response.substring(0,100):response);
            }
        }

        try {
            //先删除排序分数据,再保存新的数据
//            String delSql = "delete from t_risk_result where customer_id = ? ";
//            riskResultService.executeUpdate(customer.getId());
            riskResultService.save(tRiskResult);


        } catch (Exception e) {
            logger.error("保存排序分失败：" + e.getMessage());
        }
    }

}
