package com.tguzik.annotations;

import javax.annotation.meta.When;
import java.lang.annotation.*;

/**
 * Indicates that the method/type/field has some side effects. Optional value
 * can be used as a comment to describe said effects.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.CLASS)
public @interface HasSideEffects {
    /** Comment describing side effects */
    String[] value();

    When when() default When.UNKNOWN;
}
