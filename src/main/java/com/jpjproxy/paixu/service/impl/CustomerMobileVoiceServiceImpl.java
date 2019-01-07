package com.jpjproxy.paixu.service.impl;

import com.jpjproxy.dao.CustomerMobileVoiceMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerMobileInfo;
import com.jpjproxy.entity.CustomerMobileVoice;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.service.CustomerMobileInfoService;
import com.jpjproxy.paixu.service.CustomerMobileVoiceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jingpj
 * @Date：creste in 2018/12/26
 */
@Slf4j
@Service
public class CustomerMobileVoiceServiceImpl implements CustomerMobileVoiceService {
    @Resource
    private CustomerMobileVoiceMapper mobileVoiceMapper;
    @Resource
    private CustomerMobileInfoService customerMobileInfoService;

    @Override
    public List<PaixuRequestBody.CallRecordBean> getCallBeanListByCustomer(Customer customer) {
        //为了不影响后续调用捕捉错误，并打印
        try {
            List<CustomerMobileVoice> mobileVoiceList = getMobileVoiceListByCustomer(customer);
            CustomerMobileInfo customerMobileInfo = customerMobileInfoService.selectByCustomerId(customer.getId());
            if (CollectionUtils.isNotEmpty(mobileVoiceList)) {
                int size = mobileVoiceList.size();
                List<PaixuRequestBody.CallRecordBean> callRecordBeanList = new ArrayList<>();
                //获取抓取时间
                String updataTime = customerMobileInfo != null && customerMobileInfo.getLastModifyTime() != null ? DateFormatUtils.format(customerMobileInfo.getLastModifyTime(), "yyyy-MM-dd HH:mm:dd") : "";
                for (int i = 0; i < size; i++) {
                    CustomerMobileVoice customerMobileVoice = mobileVoiceList.get(i);
                    PaixuRequestBody.CallRecordBean callRecordBean = new PaixuRequestBody.CallRecordBean();

                    if (customerMobileVoice.getVoiceDate()!=null) {
                        callRecordBean.setCall_time(DateFormatUtils.format(customerMobileVoice.getVoiceDate(), "yyyy-MM-dd HH:mm:dd"));
                    }
                    //1：呼入，2：呼出，3：未接通,未接通暂无法判断出
                    callRecordBean.setCall_type("被叫".equals(customerMobileVoice.getVoiceStatus()) ? 1 : 2);
                    callRecordBean.setDuration_time(customerMobileVoice.getVoiceDuration());
                    callRecordBean.setPeer_number(customerMobileVoice.getVoiceNumber());
                    callRecordBean.setUser_mobile(customerMobileVoice.getPhoneNo());
                    callRecordBean.setUpdate_time(updataTime);
                    callRecordBeanList.add(callRecordBean);
                }
                return callRecordBeanList;
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private List<CustomerMobileVoice> getMobileVoiceListByCustomer(Customer customer) {
        Assert.notNull(customer);
        if (StringUtils.isNotBlank(customer.getPhoneNo()) && customer.getPhoneNo().length() == 11) {
            String tableName = "t_customer_mobile_voice_" + customer.getPhoneNo().substring(9);
            return mobileVoiceMapper.listByCustomerId(tableName, customer.getId());
        }
        return null;
    }
}
