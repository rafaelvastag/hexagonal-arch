package com.vastag.hexagonal.adapters.out;

import com.vastag.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.vastag.hexagonal.adapters.out.repository.CustomerRepository;
import com.vastag.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public void update(Customer c) {
    var customerEntity = customerEntityMapper.toCustomerEntity(c);
    customerRepository.save(customerEntity);
  }
}
