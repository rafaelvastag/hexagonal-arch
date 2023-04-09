package com.vastag.hexagonal.application.ports.in;

import com.vastag.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

  void insert(Customer customer, String zipCode);
}
