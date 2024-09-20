package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinValidator implements ConstraintValidator<ValidMin, Part> {


    @Override
    public void initialize(ValidMin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = part.getInv() >= part.getMin();
        if(!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory can not be less than minimum.")
                    .addPropertyNode("min").addConstraintViolation();
        }
        return isValid;
    }
  }