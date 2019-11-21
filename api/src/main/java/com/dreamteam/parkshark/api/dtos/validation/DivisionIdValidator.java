package com.dreamteam.parkshark.api.dtos.validation;

import com.dreamteam.parkshark.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DivisionIdValidator implements ConstraintValidator<ExistingDivisionId, String> {
   private final DivisionService service;
   @Autowired
   public DivisionIdValidator(DivisionService service) {
      this.service = service;
   }

   public void initialize(ExistingDivisionId constraint) {
   }

   public boolean isValid(String id, ConstraintValidatorContext context) {
      return id == null || (
              id.matches("^\\d+$")
              && service.getById(Long.parseLong(id)).isPresent()
      );
   }
}
