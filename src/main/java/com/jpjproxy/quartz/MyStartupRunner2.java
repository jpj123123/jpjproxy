package com.jpjproxy.quartz;

import com.jpjproxy.entity.Customer;
import com.jpjproxy.paixu.event.MagicEvent;
import com.jpjproxy.paixu.handler.SpringContextHolder;
import com.jpjproxy.service.CustomerService;
import com.jpjproxy.service.LoanService;
import com.jpjproxy.service.SlRiskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
//@Component
public class MyStartupRunner2 implements CommandLineRunner {
    @Resource
    private CustomerService customerService;
    @Override
    public void run(String... args) throws Exception {
        List<Long> customerIds = customerService.listCustomerId();
        log.info("查询出用户Id：{}", customerIds);
        for(Long customerId : customerIds) {
            Customer customer = customerService.selectByPrimaryKey(customerId);
            SpringContextHolder.getApplicationContext().publishEvent(new MagicEvent(this, customer));
        }
    }

}