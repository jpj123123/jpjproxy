package com.jpjproxy.paixu.service.impl;

import com.alibaba.fastjson.JSON;
import com.jpjproxy.dao.CustomerAppInstallMapper;
import com.jpjproxy.entity.Customer;
import com.jpjproxy.entity.CustomerAppInstall;
import com.jpjproxy.paixu.bean.PaixuRequestBody;
import com.jpjproxy.paixu.service.CustomerAppInstallService;
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
@Service
@Slf4j
public class CustomerAppInstallServiceImpl implements CustomerAppInstallService {
    @Resource
    private CustomerAppInstallMapper mapper;
    @Override
    public List<PaixuRequestBody.AppBean> getAppBeanListByCustomer(Customer customer) {
        List<CustomerAppInstall> appInstallList = getListByCustomer(customer);
        log.info("app安装记录数据：{}", JSON.toJSONString(appInstallList));
        if (CollectionUtils.isNotEmpty(appInstallList)) {
            int size = appInstallList.size();
            List<PaixuRequestBody.AppBean> appBeanList = new ArrayList<>();
            for (int i=0 ;i <size;i++) {
                PaixuRequestBody.AppBean appBean = new PaixuRequestBody.AppBean();
                CustomerAppInstall customerAppInstall = appInstallList.get(i);
                appBean.setApp_name(customerAppInstall.getAppName());
                appBean.setApp_packagename(customerAppInstall.getPackageName());
                appBean.setUpdate_time(DateFormatUtils.format(customerAppInstall.getInstallTime(),"yyyy-MM-dd HH:mm:ss"));
                appBeanList.add(appBean);
            }
            return appBeanList;
        }
        return null;
    }

    private List<CustomerAppInstall> getListByCustomer(Customer customer) {
        Assert.notNull(customer);
        if (StringUtils.isNotBlank(customer.getPhoneNo())){
            String tableIndex = customer.getPhoneNo().substring(9);
            String tableName = "t_customer_app_install_"+ tableIndex;
            return mapper.listBycustomerId(tableName,customer.getId());
        }else {
            return null;
        }
    }
}
