package com.jpjproxy.paixu.event;

import com.jpjproxy.entity.Customer;
import org.springframework.context.ApplicationEvent;

public class MagicEvent extends ApplicationEvent {

    private Customer customer;

    public MagicEvent(Object source,Customer customer) {
        super(source);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
