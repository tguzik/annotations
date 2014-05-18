package com.tguzik.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Attempts to communicate when user would know that failure happened.
 * 
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention( RetentionPolicy.CLASS )
@Target( {ElementType.TYPE, ElementType.METHOD} )
public @interface ExpectedFailureProfile {
    /** How the annotated type/method handles failures? */
    Kind value();

    /**
     * Does the failure corrupt internal state? Can object be reused after
     * failure?
     */
    Transactional transactional() default Transactional.UNKNOWN;

    /** How many times does the type/method retry before giving up? */
    int retries() default 0;

    enum Kind {
        /** Reports failure as soon as it occurs */
        FAIL_FAST,

        /** Reports failure but continues with processing */
        CARRY_ON,

        /** Completely hides failures */
        IGNORE,

        /** Automatically retries when failue occurs */
        RETRY
    }

    enum Transactional {
        YES,
        NO,
        UNKNOWN
    }
}
