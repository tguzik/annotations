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


## So what's inside?

TBD.


## Dependencies

- JDK 1.7
- `com.google.code.findbugs:jsr305` - additional annotations like `@Nonnull` or `@Nullable`

`com.google.guava:guava` with its annotations is recommended, but is too heavy to be a dependency to this library. 

## License

Source code in this repository is available under [MIT License](LICENSE).
 