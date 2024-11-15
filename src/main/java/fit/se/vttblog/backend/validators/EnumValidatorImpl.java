package fit.se.vttblog.backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

   List<String> valueList = null;

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return valueList.contains(value.toUpperCase());
   }

   @Override
   public void initialize(EnumValidator constraintAnnotation) {
      valueList = new ArrayList<>();
      Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();

      @SuppressWarnings("rawtypes")
      Enum[] enumValArr = enumClass.getEnumConstants();

      for (@SuppressWarnings("rawtypes") Enum enumVal : enumValArr) {
         valueList.add(enumVal.toString().toUpperCase());
      }
   }

}