package com.example.school.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Pattern.List({
	 @Pattern(regexp="^.*\\d+.*$",message="Must contain at least one digit!"),
     @Pattern(regexp="^.*[-_]+.*$",message="Must contain at least one character from the set -,_,$,.!")
})
@Size(min=8)
@Constraint(validatedBy = {})
public @interface StrongPassword {

	 String message() default "This is not a valid e-mail!";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
		

}
