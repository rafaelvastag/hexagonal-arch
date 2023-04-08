package com.vastag.hexagonal.application.ports.out;

import com.vastag.hexagonal.application.core.domain.Customer;

public interface InsertCustomerPort {
    void insert(Customer customer);
}
