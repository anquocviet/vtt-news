package fit.se.vttblog.backend.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validating that a field's value is one of the values in a specified Enum.
 *
 * @description This annotation ensures that the annotated field is not null and its value is one of the values in the specified Enum.
 * @author vie
 * @date 31/10/24
 */
@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface EnumValidator {

   /**
    * Specifies the Enum class that contains the valid values for the annotated field.
    *
    * @return the Enum class
    */
   Class<? extends Enum<?>> enumClazz();

   /**
    * Specifies the error message if the field's value is not valid.
    *
    * @return the error message
    */
   String message() default "Value is not valid";

   /**
    * Specifies the groups the constraint belongs to.
    *
    * @return the groups
    */
   Class<?>[] groups() default {};

   /**
    * Specifies the payload for clients to specify additional information about the validation error.
    *
    * @return the payload
    */
   Class<? extends Payload>[] payload() default {};

}