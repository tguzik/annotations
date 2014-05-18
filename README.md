# annotations [![Build Status](https://travis-ci.org/tguzik/annotations.png?branch=master)](https://travis-ci.org/tguzik/annotations)

Collection of annotations and interfaces that attempt to make Java code more readable. Items in this package 
attempt to enable developers to write cleaner code that is easier to read and use, letting them do the real 
work, instead of wondering "what happens if I give this function that?".

## Annotations? What's wrong with TODO, FIXME and Javadoc?

Absolutely nothing. If that's enough for you, then go ahead and use them. The problem begins when you only have binary 
distribution of a library and you have to guess some of its properties, like failure mode (Does it fail fast?), 
mutability (Can I safely give it to another thread? Would that method modify my argument?) or whether the function 
can return `null` value.


## How do I get it?

At this moment the library is available only through sources. Maven artifact is TBD.


## Dependencies

- JDK 1.5+ 
- `com.google.code.findbugs:jsr305` - additional annotations like `@Nonnull` or `@Nullable`

Both `org.apache.commons:commons-lang3` and `com.google.guava:guava` are recommended, but are too heavy to be a 
dependency to this library. 


## So what's inside?

All annotations from `com.google.code.findbugs:jsr305` are provided through transitive dependency. These include
`@Nonnull`, `@Nullable`, `@ThreadSafe`, `@Immutable`, `@CheckReturnValue`, `@Nonnegative` and more.

This library on the other hand contains following annotations:

* `@DiscardObjectAfterInvocation` - indicates that the object is no longer (re-)usable after calling annotated method
* `@ExpectedFailureProfile(FailureMode value, Transactional transactional, int retries)` - indicates whether method fails quickly, 
  carries on or ignores failures.
* `@ExpectedPerformanceProfile(PerformanceCharacteristic value, String comment)`- indicates whether class/method
  is CPU/IO/MEMORY/Reflection heavy, whether it relies on cache or returns quickly in all cases. Optional 
  comment can provide some context.
* `@MayModify(String comment)` - indicates that the function argument may be mutated in some way. Optional comment 
  provides a way to preserve a note without relying on Javadoc.
* `@ReadOnly` indicates that the returned value should be treated as read only and not be modified.
* `@RefactorThis(String[] value)` - indicates that the current implementation should be reworked. Optional comment
  provides a way to note what is wrong with current implementation.


Details are in [generated Javadoc]().

  
Provided interfaces:

* `BiFunction<F1, F2, T>` that contains method `T apply( F1 first, F2 second )`

Please note that the annotations and interfaces in this library are meant to supplement what is provided by Apache 
Commons Lang and Google Guava libraries without duplicating functionality.


## Examples


## License

Source code in this repository is available under [MIT License](LICENSE).
