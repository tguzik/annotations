package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that the target object should not be modified under any circumstance. Attempting to mutate the object is
 * unspecified behavior, may throw exceptions, may damage the internal state of the software or may result in thread 
 * visibility issues.
 * <p />
 * Use with mutable classes and interfaces suggesting mutability. If possible use types/values enforcing immutability
 * instead.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
public @interface ReadOnly {

}
