package com.tguzik.annotations;

import java.lang.annotation.*;

/**
 * Indicates that target method can be invoked again (for example, from another thread) before other invocations
 * are complete.
 * <p/>
 * Target method will <strong>not</strong>:
 * <ul>
 * <li>Use synchronization that might starve other threads.</li>
 * <li>Change the state in non-transactional and/or non-atomic manner.</li>
 * <li>Act upon any static (or global) non-constant data, especially if it might modify it.</li>
 * <li>Attempt to call non-reentrant methods</li>
 * <li>Attempt to modify its own code</li>
 * </ul>
 *
 * @see com.tguzik.annotations.NotReentrant
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.4
 */
@Documented
@Target( ElementType.METHOD )
@Retention( RetentionPolicy.CLASS )
public @interface Reentrant {
}
