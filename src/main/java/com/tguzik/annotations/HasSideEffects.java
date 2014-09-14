package com.tguzik.annotations;

import javax.annotation.meta.When;
import java.lang.annotation.*;

/**
 * Indicates that the method/type/field has some side effects that are not obvious. Optional value can be used as a
 * comment to describe said effects.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Target( { ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE } )
@Retention( RetentionPolicy.CLASS )
public @interface HasSideEffects {
    When value() default When.ALWAYS;

    String[] comment() default "";
}
