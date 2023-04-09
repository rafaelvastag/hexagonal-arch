package com.vastag.hexagonal.adapters.in.controller.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequest {

  @NotBlank
  private String name;
  @NotBlank
  @CPF
  private String cpf;
  @NotBlank
  private String zipCode;
}
