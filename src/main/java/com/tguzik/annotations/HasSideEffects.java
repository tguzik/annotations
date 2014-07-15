package com.tguzik.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.When;

/**
 * Indicates that the method/type/field has some side effects. Optional value
 * can be used as a comment to describe said effects.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Target( {ElementType.METHOD,
          ElementType.CONSTRUCTOR,
          ElementType.FIELD,
          ElementType.TYPE,
          ElementType.PARAMETER} )
@Retention( RetentionPolicy.CLASS )
public @interface HasSideEffects {
    /** Comment describing side effects */
    String[] value();

    When when() default When.UNKNOWN;
}
