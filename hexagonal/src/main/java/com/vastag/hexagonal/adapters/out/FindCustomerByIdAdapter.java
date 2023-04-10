package com.vastag.hexagonal.adapters.out;

import com.vastag.hexagonal.adapters.out.repository.CustomerRepository;
import com.vastag.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public Optional<Customer> find(String id) {
    var customerEntity = customerRepository.findById(id);
    return customerEntity.map(e -> customerEntityMapper.toCustomer(e));
  }
}
