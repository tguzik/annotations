# annotations [![Build Status](https://travis-ci.org/tguzik/annotations.png?branch=master)](https://travis-ci.org/tguzik/annotations)

Collection of annotations and interfaces that attempt to make Java code more readable. Items in this package
attempt to enable developers to write cleaner code that is easier to read and use, letting them do the real
work, instead of wondering "what does it do under the hood?".

### Annotations? What's wrong with TODO, FIXME and Javadoc?

Absolutely nothing. If that's enough for you, then go ahead and keep using them. The problem begins when you only have
binary distribution of a library and you have to guess some of its properties due to lacking documentation. These
properties include like failure modes (Does it fail fast?), mutability (Can I safely give it to another thread? Would
that method modify my argument?) or whether the function can return `null` value.

### @Too @Many @Annotations @Make @Jack @A @Dull @Boy

It's not a secret that too many annotations or too long comments can be distracting and can obscure the important
details. This library heavily depends on the user to exercise best judgement when using it is necessary to use any of
the packaged annotations.  

### Disclaimer

Using this library won't magically fix your project, but can at least make it more maintainable. Some annotations
are inspired by in-house binary-only magic `.jar`'s that nobody-knows-who-maintains and lack even most basic
documentation.


## How do I get it?

The library is available in Maven Central repository. You can use it in your projects via this dependency:

    <dependency>
        <groupId>com.tguzik</groupId>
        <artifactId>annotations</artifactId>
        <version>0.4</version>
    </dependency>


## So what's inside?

All annotations from `com.google.code.findbugs:jsr305` are provided through transitive dependency. These include
`@Nonnull`, `@Nullable`, `@ThreadSafe`, `@Immutable`, `@CheckReturnValue`, `@Nonnegative` and more.

This library on the other hand contains following annotations:

* `@DiscardObjectAfterInvocation` - indicates that the object is no longer (re-)usable after calling annotated method
* `@ExpectedFailureProfile(FailureMode value, Transactional transactional, int retries)` - indicates whether method
  fails quickly, carries on or ignores failures.
* `@ExpectedPerformanceProfile(PerformanceCharacteristic value, String comment)`- indicates whether class/method
  is CPU/IO/MEMORY/Reflection heavy, whether it relies on cache or returns quickly in all cases. Optional
  comment can provide some context.
* `@HasSideEffects(String[] value, When when)`
* `@MayModify(String comment)` - indicates that the function argument may be mutated in some way. Optional comment
  provides a way to preserve a note without relying on Javadoc.
* `@ReadOnly` indicates that the returned value (or value passed as argument) should be treated as read only and should
  not be modified.
* `@RefactorThis(String[] value)` - indicates that the current implementation should be reworked. Optional comment
  provides a way to note what is wrong with current implementation.


Details are in [generated Javadoc](http://tguzik.github.io/annotations/).

Please note that the annotations in this library are meant to supplement what is provided by Apache
Commons Lang, Google Guava and JSR305 libraries without duplicating functionality.


## Examples
Consider these examples of how this library along with `jsr305` can be used:

```java
public abstract class BaseObject
{
    // [...]

    @Nonnull
    @Override
    @ExpectedPerformanceProfile( path = Path.COLD, value = Kind.REFLECTION_HEAVY )
    public String toString( ) {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.SHORT_PREFIX_STYLE );
    }

    // [...]
}
```

```java
public class MyCustomDAO
{
    @HasSideEffects( value = "Clears contents of internal cache", when = When.ALWAYS )
    @ExpectedFailureProfile( value = Kind.FAIL_FAST, transactional = Transactional.YES )
    public void updateHalfOfTheDatabase( ) {
        // [...]
    }
}
```

```java
@ThreadSafe
public class CustomTcpIpConnector
{
    @Nullable
    @ReadOnly
    @ExpectedFailureProfile( value = Kind.CARRY_ON, retries = 3 )
    public byte[] sendAndRecieve( @Nonnull @ReadOnly byte[] payload ) throws ConnectException {
        // [...]
    }
}
```

## Dependencies

- JDK 1.5+
- `com.google.code.findbugs:jsr305` - additional annotations like `@Nonnull` or `@Nullable`

Both `org.apache.commons:commons-lang3` and `com.google.guava:guava` are recommended, but are too heavy to be a
dependency to this library.


## License

Library both in source or binary forms is available under [MIT License](LICENSE).
