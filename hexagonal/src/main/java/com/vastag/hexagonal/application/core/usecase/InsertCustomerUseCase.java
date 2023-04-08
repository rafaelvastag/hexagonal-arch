package com.vastag.hexagonal.application.core.usecase;

import com.vastag.hexagonal.application.core.domain.Customer;
import com.vastag.hexagonal.application.ports.out.FindAddressByZipCodePort;
import com.vastag.hexagonal.application.ports.out.InsertCustomerPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsertCustomerUseCase {

    private final FindAddressByZipCodePort findAddressByZipCodePort;
    private final InsertCustomerPort insertCustomerPort;

    public void insert(Customer customer, String zipcode) {
        var address = findAddressByZipCodePort.findBy(zipcode);
        customer.setAddress(address);
        insertCustomerPort.insert(customer);
    }
}
