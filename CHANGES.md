Changelog
=========

Below is the summary of changes in each version of the library. Changes that do
not affect the binary version (documentation) are generally not included here.
Changes that might affect the binary version (changes to sources or pom.xml) are
*always* included here.

Some items are "*Breaking*" backward compatibility: they require client code
change and/or change the expected functionality.

-----

Version `1.0.0`:
* *Breaking*: Renamed `@DiscardObjectAfterInvocation` to `@OnlyOnce`
* *Breaking*: Renamed `@MayModify` to `@Modifies`. The latter has optional
  fields to describe when modification happens.
* *Breaking*: Split `@Reentrancy` into `@Reentrant` and `@NotReentrant`
* Added `FAST` and `SLOW` to enum in `@ExpectedPerformanceProfile`


Version `0.4`:
* *Breaking*: Removed `LOW_LATENCY` and renamed `CACHE_BOUND` to `CACHE_HEAVY`
  in `@ExpectedPerformanceProfile.Kind`
* Added `SYNCHRONOUS`, `ASYNCHRONOUS`, `READ_HEAVY` and `WRITE_HEAVY` to
  `@ExpectedPerformanceProfile.Kind`
* Added `@Reentrancy` annotation
* Documentation updates.
* Next release will jump to version 1.0 and start using semantic versioning.


Version `0.3`:
* Library available on Maven Central
