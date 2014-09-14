package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that the target method should be called only once in object's lifetime. This is best used on methods
 * that cannot be easily refactored. An example of such piece of code would be startup or shutdown methods.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 */
@Documented
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.CLASS )
public @interface OnlyOnce {
}
