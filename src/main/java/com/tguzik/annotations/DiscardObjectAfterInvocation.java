package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that the object with this method, or a certain parameter, should be
 * discarded after invoking this method.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD, ElementType.PARAMETER })
public @interface DiscardObjectAfterInvocation {

}
