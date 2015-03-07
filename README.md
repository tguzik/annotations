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
        <version>1.0.1</version>
    </dependency>


## So what's inside?

You can see the listing in the [generated Javadoc](http://tguzik.github.io/annotations/).

In addition to that, all annotations from `com.google.code.findbugs:jsr305` are provided through transitive dependency.
These include `@Nonnull`, `@Nullable`, `@ThreadSafe`, `@Immutable`, `@CheckReturnValue`, `@Nonnegative` and more.


## Dependencies

- JDK 1.5+
- `com.google.code.findbugs:jsr305` - additional annotations like `@Nonnull` or `@Nullable`


## License

Library both in source or binary forms is available under [MIT License](LICENSE).
