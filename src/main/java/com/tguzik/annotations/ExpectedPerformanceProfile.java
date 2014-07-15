package com.tguzik.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Communicates the expected performance characteristic to the programmer using
 * the class.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention( RetentionPolicy.CLASS )
@Target( {ElementType.TYPE, ElementType.METHOD} )
public @interface ExpectedPerformanceProfile {
    Path[] path() default Path.UNKNOWN;

    Kind[] value() default Kind.UNKNOWN;

    String[] comment() default "";

    enum Path {
        /**
         * Annotated class or method resides on hot path: it is executed very
         * often
         */
        HOT,

        /**
         * Annotated class or method resides on warm path: it is sometimes
         * executed in hot path and sometimes in cold path
         */
        WARM,

        /**
         * Annotated class or method resides on cold path: it is executed
         * infrequently.
         */
        COLD,

        /** Default value. Path not known */
        UNKNOWN;
    }

    enum Kind {
        /** Uses significant amount of CPU */
        CPU_HEAVY,

        /** Uses significant amount of IO */
        IO_HEAVY,

        /** Produces significant amount of garbage on heap */
        GC_HEAVY,

        /** Uses significant amount of memory */
        MEMORY_HEAVY,

        /** Relies heavily on caching */
        CACHE_BOUND,

        /** Relies heavily on reflection mechanisms */
        REFLECTION_HEAVY,

        /** Returns very quickly and does not block */
        LOW_LATENCY,

        /** Default value. Profile not known - see comment */
        UNKNOWN;
    }
}
