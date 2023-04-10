package com.vastag.hexagonal.application.ports.out;

import com.vastag.hexagonal.application.core.domain.Customer;
import java.util.Optional;

public interface FindCustomerByIdOutputPort {
  Optional<Customer> find(String id);

}
