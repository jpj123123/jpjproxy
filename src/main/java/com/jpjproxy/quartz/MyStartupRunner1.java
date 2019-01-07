package com.jpjproxy.quartz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.SlRisk;
import com.jpjproxy.risk.shuli.ShuLiRiskApi;
import com.jpjproxy.service.CustomerService;
import com.jpjproxy.service.LoanService;
import com.jpjproxy.service.SlRiskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import util.DateUtils;
import util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
//@Component
public class MyStartupRunner1 implements CommandLineRunner {
    @Resource
    private LoanService loanService;
    @Resource
    private CustomerService customerService;
    @Resource
    private SlRiskService slRiskService;
    @Override
    public void run(String... args) throws Exception {
//        List<Long> customerIds = loanService.listCustomerIdByLoan();
//        log.info("获取用户数据：{}条", customerIds.size());
//        for (Long customerId : customerIds){
//            if(customerId == null){
//                continue;
//            }
//            Customer customer = customerService.selectByPrimaryKey(customerId);
//            if(customer == null){
//                continue;
//            }
//            try {
//                String orgBizNo = DateUtils.format(DateUtils.getCurrent(), DateUtils.FORMAT_INT_MINITE) + customer.getPhoneNo() + new Random().nextInt(100);
//                SlRisk slRisk = new SlRisk();
//                slRisk.setOrgBizNo(orgBizNo);
//                slRisk.setSceneId("BIZ_TYPE");
//                slRisk.setReqDate(DateUtils.getCurrent());
//                Map<String, Object> map = new HashMap<>();
//                Map<String, String> params = new HashMap<>();
//                map.put("orgBizNo", orgBizNo);
//                map.put("sceneId", "BIZ_TYPE");
//                params.put("phoneNo", customer.getPhoneNo());
//                params.put("name", customer.getName());
//                params.put("idCard", customer.getCardNumber());
//                params.put("backDate", DateUtils.format(customer.getAuthedDate()));
//                map.put("params", params);
//                log.info(JSON.toJSONString(map));
//                String rs = ShuLiRiskApi.getRisk(JSON.toJSONString(map));
//                log.info("返回数据：{}",rs );
//                if (StringUtils.isBlank(rs)) {
//                    continue;
//                }
//                JSONObject object = JSON.parseObject(rs);
//                String score = object.getJSONObject("result").getJSONObject("sl_score").getString("label");
//                int scint = 0;
//                if (!StringUtils.equalsIgnoreCase("NAN", score)) {
//                    scint = NumberUtils.toInt(score, 0);
//                }
//                slRisk.setCustomerId(customerId);
//                slRisk.setResData(rs);
//                slRisk.setScore(scint);
//                slRisk.setResDate(DateUtils.getCurrent());
//                slRiskService.insertSelective(slRisk);
//            }catch (Exception e){
//                log.info("失败了有错误产生：{}",e);
//                Thread.sleep(1000L);
//                continue;
//            }
//            //break;
//        }
    }

}