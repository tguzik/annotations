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
        CPU_HEAVY,
        IO_HEAVY,
        MEMORY_HEAVY,
        CACHE_BOUND,
        REFLECTION_HEAVY,
        LOW_LATENCY,
        UNKNOWN;
    }
}
