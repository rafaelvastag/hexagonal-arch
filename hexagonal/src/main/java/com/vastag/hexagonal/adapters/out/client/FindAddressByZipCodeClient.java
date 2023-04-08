package com.vastag.hexagonal.adapters.out.client;

import com.vastag.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "${vastag.client.address.url}"
)
public interface FindAddressByZipCodeClient {

  AddressResponse find(@PathVariable("zipcode") String zipcode);
}
