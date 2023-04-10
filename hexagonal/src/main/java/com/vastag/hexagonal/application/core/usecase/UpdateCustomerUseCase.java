package com.vastag.hexagonal.application.core.usecase;

import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.vastag.hexagonal.application.ports.out.FindAddressByZipCodePort;
import com.vastag.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import com.vastag.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

  private final FindCustomerByIdOutputPort findCustomerByIdAdapter;
  private final FindAddressByZipCodePort findAddressByZipCodePort;
  private final UpdateCustomerOutputPort updateCustomerOutputPort;

  public UpdateCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdAdapter,
      FindAddressByZipCodePort findAddressByZipCodePort, UpdateCustomerOutputPort updateCustomerOutputPort) {
    this.findCustomerByIdAdapter = findCustomerByIdAdapter;
    this.findAddressByZipCodePort = findAddressByZipCodePort;
    this.updateCustomerOutputPort = updateCustomerOutputPort;
  }

  public void update(Customer customer, String zipCode) {
    findCustomerByIdAdapter.find(customer.getId());
    var address = findAddressByZipCodePort.findBy(zipCode);
    customer.setAddress(address);
    updateCustomerOutputPort.update(customer);
  }
}
