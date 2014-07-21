package com.tguzik.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Indicates whether this method can be invoked again before other invocations
 * are complete OR whether this method can be executed only once in object's
 * lifetime.
 * </p>
 * <p>
 * This definition of reentrancy differs from that of thread-safety in
 * multi-threaded environments. A reentrant subroutine can achieve
 * thread-safety, but being reentrant alone might not be sufficient to be
 * thread-safe in all situations. Conversely, thread-safe code does not
 * necessarily have to be reentrant.
 * </p>
 * <p>
 * The rules for reentrancy are:
 * <ol>
 * <li>Reentrant code may not hold any static (or global) non-constant data</li>
 * <li>Reentrant code may not modify its own code.</li>
 * <li>Reentrant code may not call non-reentrant computer programs or routines.</li>
 * </p>
 * <p>
 * This annotation is best used on methods that cannot be removed/refactored out
 * of the object or have some kind of race condition that cannot be easily
 * removed.
 * </p>
 * <p>
 * An examples of reentrant methods are interrupt handlers, "pure" functions
 * (shareable functions). Examples of non-reentrant functions are the
 * initialization code for most services (thread pools, database connections
 * etc.), cache cleanup methods or any functions that rely on
 * locks/mutexes/synchorization.
 * </p>
 *
 * @author Tomasz Guzik <tomek@tguzik.com>; parts of the documentation by
 *         Wikipedia authors and editors
 * @since 0.4
 */
@Documented
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.CLASS )
public @interface Reentrancy {
    /**
     * Indicates whether target method can be invoked multiple times in defined
     * scope
     */
    Kind reentrant();

    /** Defines the scope of re-entrancy */
    Scope scope();

    /** Optional comment from the programmer */
    String comment() default "";

    enum Kind {
        YES,
        NO,
        UNKNOWN;
    }

    enum Scope {
        /**
         * Target method can be invoked only once per lifetime of the object. If
         * invoked twice, it may throw an appropriate exception.
         */
        LIFETIME,

        /**
         * Target method may be executed only when other invocations have
         * completed. This usually points to underlying race condition that
         * cannot be (easily?) solved. An external lock or other synchronization
         * mechanism is recommended.
         */
        INVOCATION,

        /** No information about the scope */
        UNKNOWN
    }
}
