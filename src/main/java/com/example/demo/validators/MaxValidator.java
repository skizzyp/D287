package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxValidator implements ConstraintValidator<ValidMax, Part> {

    @Override
    public void initialize(ValidMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = part.getInv() <= part.getMax();
        if(!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory can not be more than maximum.")
                    .addPropertyNode("max").addConstraintViolation();
        }
        return isValid;
    }
}
