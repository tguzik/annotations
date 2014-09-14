package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that target method cannot be invoked again before other invocations are complete. Target method may use
 * synchronization that can easily starve other threads or may modify the state of the object.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @see com.tguzik.annotations.Reentrant
 * @since 1.0.0
 */
@Documented
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.CLASS )
public @interface NotReentrant {
}
