package com.vastag.hexagonal.adapters.in.controller;

import com.vastag.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.vastag.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.vastag.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.vastag.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.vastag.hexagonal.application.ports.in.UpdateCustomerInputPort;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  @Autowired
  private InsertCustomerInputPort insertCustomerInputPort;

  @Autowired
  private FindCustomerByIdAdapter findCustomerByIdAdapter;

  private UpdateCustomerInputPort updateCustomerInputPort;

  @Autowired
  private CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
    insertCustomerInputPort.insert(customerMapper.toCustomer(request), request.getZipCode());
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
    var customer = findCustomerByIdAdapter.find(id);
    var customerResponse = customerMapper.toCustomerResponse(customer.get());
    return ResponseEntity.ok(customerResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable final String id,
      @Valid @RequestBody CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customerRequest.getZipCode());
    return ResponseEntity.noContent().build();
  }
}
