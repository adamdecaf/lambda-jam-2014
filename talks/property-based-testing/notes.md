# Property-Based Testing for Better Code

## General

* Value based testing sucks
  * User specified values to make tests "perfect"
* Property based testing
  * Throw a bunch of stuff at our methods, see if it sticks
    * More work to write, lots of failures
    * Can cause false-positives

## Non-Predictable systems

* Really hard to just brute force test distributed systems
* Async things will alter other things, perhaps only after your capturing is done
* specific examples are good, don't stop using them
  * great for verifying bugs are fixed.

## Scalacheck

* Break apart some things we know are true with our systems.
* Writing property testing over those can, over time, help us feel confident about our code
  * Can specify reduced test cases
    * still not totally comprehensive tests
* Shrink
  * let's us reduce our models (sometimes)
  * really break down the rough edges

## Real World

* Our property tests should throw exceptions, they should fail
  * They should timeout, they should spam us with too much
* Ask the hard questions
  * Without actually testing for the real world what are we testing?
  * Do we just leave the scary stuff undefined?
* Typically, the end result of the function will be simple
  * However, we need to be sure that result is actually correct
  * Did every resource get used properly?
  * Did we capture each producer we started?
* Create the visibility you need
* Write our tests with the business logic in mind
  * Maintains context
  * Compare results from the function against other results.
    * relative results can also give us value.
  * tells us the reason _why_ the answer is correct
* Cyclic test results
  * really good for serialize/deserialize tests
* Backwards tests
  * Given an output, check that given input(s) gives us that output.

## Test Failures

* Thinking about "fixing broken" property tests as:
  * Stupid extra work -- causes us to ignore the point of property testing
  * refining our mental and actual model -- causes us to be more confident in our code
    * ^^ what actually matters
      * The point of property testing

## Refactoring

* Using generators, not specific examples, let's us simplify the process of "fixing tests" after
  * Just change the generator
* We often have tests that are too dependent on the exact details
  * Just need to define _the bare min_ for success for each test
* Deductive logic doesn't scale
  * trial and error scales
  * property based tests use trial and error
