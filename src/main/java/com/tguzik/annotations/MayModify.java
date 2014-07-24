package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that the parameter will be mutated in some way.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = ElementType.PARAMETER)
public @interface MayModify {
    String comment() default "";
}
