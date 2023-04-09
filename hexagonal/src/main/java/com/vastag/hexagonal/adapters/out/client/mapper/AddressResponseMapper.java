package com.vastag.hexagonal.adapters.out.client.mapper;

import com.vastag.hexagonal.adapters.out.client.response.AddressResponse;
import com.vastag.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
  Address toAddress(AddressResponse r);
}
