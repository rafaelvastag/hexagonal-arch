package com.vastag.hexagonal.application.ports.in;

import com.vastag.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
 void update(Customer c, String zipCode);
}
