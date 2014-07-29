package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * This annotation attempts to communicate to other API users that the value
 * produced by the method or passed as a parameter should be only read from.
 * Attempting to mutate the object is unspecified behavior, may throw exceptions
 * or may damage the internal state of the software.
 * <p />
 * Use with mutable classes and interfaces suggesting mutability. If possible
 * use types/values enforcing immutability.
 * <p />
 * Please note that the <tt>final</tt> keyword only guarantees that the
 * reference will not be changed, but cannot guarantee that the object itself is
 * not changed (mutated).
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
public @interface ReadOnly {

}
