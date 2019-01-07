package com.jpjproxy.paixu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerCertify;
import com.jpjproxy.entity.CustomerMobileInfo;
import com.jpjproxy.paixu.bean.*;
import com.jpjproxy.paixu.handler.SpringContextHolder;
import com.jpjproxy.paixu.service.CustomerAddrbookService;
import com.jpjproxy.paixu.service.CustomerCertifyService;
import com.jpjproxy.paixu.service.CustomerMobileBillService;
import com.jpjproxy.paixu.service.CustomerMobileInfoService;
import com.jpjproxy.service.CustomerService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import util.HttpClient4Utils;

import java.io.IOException;
import java.util.*;

/**
 * 排序风Util类
 *
 * @Date: 2018/8/30 14:07
 * @Description:
 */
@Component
public class PaiXuFengUtil {
    private static final Logger log = LoggerFactory.getLogger(PaiXuFengUtil.class);

    private static String PAIXU_MERCHANTID = "510014";
    private static String PAIXU_PRODUCTID = "10072";
//    private static String PAIXU_URL = "http://47.94.221.154:8003/risk/gzip/";
    private static String PAIXU_URL = "http://172.16.101.134/risk/gzip/";
//    private static String PAIXU_URL = "http://risk.rank-tech.com/risk/loanApplyReport/";
//    private static String PAIXU_PUBLICKEY = GlobalConfig.getProperty("paixufeng", "PAIXU_PUBLICKEY");
//    private static String PAIXU_YONGJUN_PUBLICKEY = GlobalConfig.getProperty("paixufeng", "PAIXU_YONGJUN_PUBLICKEY");
//    private static String PAIXU_TEMPNAME = GlobalConfig.getProperty("paixufeng", "PAIXU_TEMPNAME");
//    private static String PAIXU_MODEL_NAME = GlobalConfig.getProperty("paixufeng", "MODEL_NAME");

//    private CustomerService customerService = (CustomerService) SpringContextHolder.getBean("customerService");
//    private CustomerCertifyService customerCertifyService = (CustomerCertifyService) SpringContextHolder.getBean("customerCertifyService");
//    private CustomerMobileInfoService customerMobileInfoService = (CustomerMobileInfoService) SpringContextHolder.getBean("customerMobileInfoService");
//    private CustomerMobileBillService customerMobileBillService = (CustomerMobileBillService) SpringContextHolder.getBean("customerMobileBillService");

//    private CustomerAddrbookService customerAddrbookService = SpringContextHolder.getBean("customerAddrbookService");

    /**
     * 加签
     *
     * @param paiXuRequestDTO
     * @return
     */
    private static String sign(PaiXuRequestDTO paiXuRequestDTO) {
        paiXuRequestDTO.setMerchantId(PAIXU_MERCHANTID);
        paiXuRequestDTO.setProductId(PAIXU_PRODUCTID);
        String sign = SignUtils.getSign(paiXuRequestDTO);
        return sign;
    }

    /**
     * 封装请求数据
     *
     * @param customerId
     * @return
     */
    public String httpPost(Long customerId) {

        PaiXuRequestDTO paiXuRequestDTO = null;
                //getRiskData(customerId);//封装数据

        String sign = sign(paiXuRequestDTO);//签名
        paiXuRequestDTO.setSign(sign);

        String req = JSON.toJSONString(paiXuRequestDTO);
//        log.info("请求排序风控数据: {}, req: {}", PAIXU_URL, req);

        String res = HttpClient4Utils.httpPost(PAIXU_URL, req);
        log.info("返回排序风控数据:res: {}", res);
        return res;
    }

    /**
     * 封装请求数据
     *
     * @param paixuRequestBody
     * @return
     */
    public String gizHttpPost(PaixuRequestBody paixuRequestBody) {

        String req = JSONObject.toJSONString(paixuRequestBody);
        log.info("请求排序风控数据: URL:{}, req: {}", PAIXU_URL, req);
        String res = null;
        try {
            res = HttpClientUtil.gzipDoPost(PAIXU_URL, req);
        } catch (IOException e) {
            log.error("请求排序分异常信息信息：" + e.getMessage());
            //返回异常信息
            Map<String,String> result = new HashMap<>();
            result.put("errorMsg",e.getMessage());
            return JSONObject.toJSONString(result);
        }
        log.info("返回排序风控数据:res: {}", res);
        return res;
    }
//
//    private PaiXuRequestDTO getRiskData(Long customerId) {
//
//        PaiXuRequestDTO paiXuRequestDTO = new PaiXuRequestDTO();
//        Date date = new Date();
//        paiXuRequestDTO.setTimeStamp(date.getTime());
//        //客户信息
//        Customer customer = customerService.selectByPrimaryKey(customerId);
//        paiXuRequestDTO.setUserName(customer.getName());
//        paiXuRequestDTO.setOrderId(generatorOrderId(customerId));
//        paiXuRequestDTO.setCardNum(customer.getCardNumber());
//        paiXuRequestDTO.setMobile(customer.getPhoneNo());
//
//        RiskDataDTO riskDataDTO = new RiskDataDTO();
//        riskDataDTO.setIdNum(customer.getCardNumber());
//        riskDataDTO.setMobile(customer.getPhoneNo());
//        riskDataDTO.setGender(customer.getSex() == 1 ? "男" : "女");
//        riskDataDTO.setApplyTime(date);
//
//        // 省市信息
//        riskDataDTO.setPresent(getPresent(customerId));
//
//        //运营商信息
//        MobileInfoDTO mobileInfoDTO = getMobileInfo(customer.getId());
//        log.error(JSONObject.toJSONString(mobileInfoDTO));
//        String path = mobileInfoDTO.getFilePath();
//        String reportFile = mobileInfoDTO.getReportFile();
//        //根据路径获取原始信息
//        if (StringUtils.isNotBlank(path)) {//原始数据
//            JSONObject rawInfo = JSON.parseObject(HttpClient4Utils.httpGet(path));
//            riskDataDTO.setRawInfo(rawInfo);
//        }
//        if (StringUtils.isNotBlank(reportFile)) {//报告数据
//            JSONObject rawReport = JSON.parseObject(HttpClient4Utils.httpGet(reportFile));
//            riskDataDTO.setRawReport(rawReport);
//        }
//
//        //联系人信息
//        List<EmergContact> list = customerAddrbookService.listEmergContactByCustomerId(customer.getId(), customer.getPhoneNo());
//        riskDataDTO.setEmergency_contacts(list);
//
////        通讯录
//        List<AddrBookDTO> contacts = customerAddrbookService.listAddrBookByCustomerId(customer.getId(), customer.getPhoneNo());
//        riskDataDTO.setContact((JSONArray) JSON.toJSON(contacts));
//        paiXuRequestDTO.setRiskData(riskDataDTO);
//        return paiXuRequestDTO;
//    }

    /**
     * 省市信息
     *
     * @param customerId
     * @return
     */
//    private Present getPresent(Long customerId) {
//        Present present = new Present();
//        List<CustomerCertify> list = customerCertifyService.findByProperty("customerId", customerId);
//        if (list != null && list.size() > 0) {
//            present.setCity(list.get(0).getRegCity());
//            present.setLiveAddr(list.get(0).getRegAddress());
//        }
//        return present;
//    }

    /**
     * 获取运营商信息
     *
     * @param customerId
     * @return
     */
//    private MobileInfoDTO getMobileInfo(long customerId) {
//        MobileInfoDTO mobileInfoDTO = new MobileInfoDTO();
//        CustomerMobileInfo t = customerMobileInfoService.selectByCustomerId(customerId);
//        try {
//            BeanUtils.copyProperties(t, mobileInfoDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        List<MobileBillDTO> listMobileBillDTO = new ArrayList<MobileBillDTO>();
//        List<CustomerMobileBill> listTCustomerMobileBill = customerMobileBillService("customerId", customerId);
//        for (TCustomerMobileBill tCustomerMobileBill : listTCustomerMobileBill) {
//            MobileBillDTO mobileBillDTO = new MobileBillDTO();
//            mobileBillDTO.setBillAmount(Double.valueOf(tCustomerMobileBill.getBillAmount()));
//            mobileBillDTO.setBillMonth(tCustomerMobileBill.getBillMonth());
//            listMobileBillDTO.add(mobileBillDTO);
//        }
//        mobileInfoDTO.setBill(listMobileBillDTO);
//        return mobileInfoDTO;
//    }


    private static String generatorOrderId(Long customerId) {
        Random rm = new Random();
        return String.format("%08d", customerId) + System.currentTimeMillis() + (rm.nextInt(9000) + 1000);
    }
}
