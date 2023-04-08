package com.vastag.hexagonal.application.ports.out;

import com.vastag.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodePort {
    Address findBy(String zipcode);
}
