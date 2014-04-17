package com.tguzik.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the parameter will be mutated in some way.
 * 
 * @author Tomasz Guzik <tomek@tguzik.com>
 */
@Retention( RetentionPolicy.CLASS )
@Target( value = ElementType.PARAMETER )
public @interface MayModify {
    String comment() default "";
}
