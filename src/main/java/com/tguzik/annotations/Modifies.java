package com.tguzik.annotations;

import javax.annotation.meta.When;
import java.lang.annotation.*;


/**
 * Indicates whether whether the target parameter will be modified.
 *
 * @see com.tguzik.annotations.ReadOnly
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value = ElementType.PARAMETER)
public @interface Modifies {
    /** Is target always modified? */
    When value() default When.ALWAYS;

    String comment() default "";
}
