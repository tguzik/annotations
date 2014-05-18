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
    PerformanceCharacteristic[] value() default PerformanceCharacteristic.UNKNOWN;

    String[] comment() default "";

    enum PerformanceCharacteristic {
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
