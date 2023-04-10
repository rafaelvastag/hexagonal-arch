package com.vastag.hexagonal.adapters.out.repository.mapper;

import com.vastag.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.vastag.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
  CustomerEntity toCustomerEntity(Customer c);
  Customer toCustomer(CustomerEntity c);
}
