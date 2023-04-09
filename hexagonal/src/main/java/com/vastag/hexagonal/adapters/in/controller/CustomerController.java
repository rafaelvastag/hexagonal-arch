package com.vastag.hexagonal.adapters.in.controller;

import com.vastag.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.vastag.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.vastag.hexagonal.application.ports.in.InsertCustomerInputPort;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  @Autowired
  private InsertCustomerInputPort insertCustomerInputPort;

  @Autowired
  private CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
    insertCustomerInputPort.insert(customerMapper.toCustomer(request), request.getZipCode());
    return ResponseEntity.ok().build();
  }
}
