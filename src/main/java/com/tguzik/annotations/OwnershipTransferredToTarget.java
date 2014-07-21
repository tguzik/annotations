package com.tguzik.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Parameter object annotated by this value will have its lifecycle managed by
 * invoked method. An example of such transfer would be storing an object
 * (parameter) in a cache.
 *
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
@Documented
@Retention( RetentionPolicy.CLASS )
@Target( value = ElementType.PARAMETER )
public @interface OwnershipTransferredToTarget {

}
