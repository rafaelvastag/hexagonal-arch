package com.vastag.hexagonal.adapters.out;

import com.vastag.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.vastag.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.vastag.hexagonal.application.core.domain.Address;
import com.vastag.hexagonal.application.ports.out.FindAddressByZipCodePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodePort {

  @Autowired
  private FindAddressByZipCodeClient findAddressByZipCodeClient;

  @Autowired
  private AddressResponseMapper addressResponseMapper;

  @Override
  public Address findBy(String zipcode) {
    var addressResponse  = findAddressByZipCodeClient.find(zipcode);
    return addressResponseMapper.toAddress(addressResponse);
  }
}
