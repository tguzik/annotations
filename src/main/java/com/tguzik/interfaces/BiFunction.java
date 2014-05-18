package com.tguzik.interfaces;

/**
 * Common interface for functions that take two arguments of types <em>F1</em>
 * and <em>F2</em> and transforms them into single value of type <em>T</em>.
 * 
 * @author Tomasz Guzik <tomek@tguzik.com>
 * @since 0.1
 */
public interface BiFunction< F1, F2, T >
{
    T apply( F1 first, F2 second );
}
