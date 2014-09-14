package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Communicates the expected performance characteristic to the programmer using
 * the class.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface ExpectedPerformanceProfile {
    /**
     * Hints at the code execution path (hot/warm/cold) the annotated
     * class/method resides.
     */
    Path[] path() default Path.UNKNOWN;

    /**
     * Hints at performance characteristics of the annotated class/method.
     * Multiple values should be ordered from most significant to least
     * significant.
     */
    Kind[] value() default Kind.UNKNOWN;

    /** Optional comment from the programmer. */
    String[] comment() default "";

    enum Path {
        /**
         * Annotated class or method resides on hot path - it is executed very
         * often. Long running and/or blocking operations are discouraged. An
         * example of hot path code would be the inside of an event loop and/or
         * request handler.
         */
        HOT,

        /**
         * Annotated class or method resides on warm path - it may be executed
         * from hot path (but not very often) or might be a part of a batch
         * process where execution time doesn't matter as much. An example of
         * warm path would be cache update process that is kicked off by a
         * timer.
         */
        WARM,

        /**
         * Annotated class or method resides on cold path - it is executed
         * infrequently or the execution time does not matter in the long run.
         * For example, startup code and one-off processes often reside on cold
         * path.
         */
        COLD,

        /** Default value. Path not known. */
        UNKNOWN;
    }

    enum Kind {
        /** Uses significant amount of CPU time */
        CPU_HEAVY,

        /** Uses significant amount of IO */
        IO_HEAVY,

        /** Produces significant amount of garbage on heap */
        GC_HEAVY,

        /** Uses significant amount of memory */
        MEMORY_HEAVY,

        /** Relies heavily on caching or introduces significant cache pollution. */
        CACHE_HEAVY,

        /** Relies heavily on reflection mechanisms */
        REFLECTION_HEAVY,

        /** Blocks until operation is completed */
        SYNCHRONOUS,

        /**
         * Returns before operation is completed. An example would be queuing operation to be executed by
         * another thread.
         */
        ASYNCHRONOUS,

        /**
         * Issues significantly more reads than writes. The meaning behinds `reads` and `writes` should be either
         * obvious or explained by the programmer.
         */
        READ_HEAVY,

        /**
         * Issues significantly more writes than reads. The meaning behinds `reads` and `writes` should be either
         * obvious or explained by the programmer.
         */
        WRITE_HEAVY,

        /**
         * Call to this method is expected to take very little time - target uses sub-<code>O(n)</code> operations,
         * does not pause, does not wait on any other operations and/or does not engage external systems.
         */
        FAST,

        /**
         * Call to this method is expected to take significant amount of time. This might be related to waiting on
         * external system.
         */
        SLOW,

        /** Default value. Profile not known - see comment */
        UNKNOWN;
    }
}
