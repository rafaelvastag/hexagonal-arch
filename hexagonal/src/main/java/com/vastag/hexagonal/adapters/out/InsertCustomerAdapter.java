package com.vastag.hexagonal.adapters.out;

import com.vastag.hexagonal.adapters.out.repository.CustomerRepository;
import com.vastag.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.out.InsertCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public void insert(Customer customer) {
    customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
  }
}
