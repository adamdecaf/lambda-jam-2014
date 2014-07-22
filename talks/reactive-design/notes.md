# Reactive Design: A Critique of Current Techniques

## Aspects / Traits

* Reactivate Manifesto
  * responsive
  * scalable
  * resilient
  * event driven

## Paradigm Comparison

* OO
  * Almost requires mixing behaviour with domain
  * Usually has "uncontrolled" state mutation
* DDD (Data Driven Design)
  * claims that behaviour should be separate from data
  * typically doesn't force us to think globally about failure
* FP
  * given referential transparency, just compose behaviour on incoming data
  * big data streams force us to "think functionally" -- just about transforms
  * easier access to pass along failure as a first class citizen
    * disjunctions, Maybe

## What's our end goal?

* We're just building data processing systems.
  * Need an MVP for doing so

## Existing Tools

* Future
  * Write code that looks sync, but is really sync under the hood.
    * Easy to write a poor man's map reduce
  * Easy to just throw on separate threads
  * Not great overall for error handling
  * Not great for horz scaling
* Streams
  * Process data as we can read/gather it
  * Unending producer of data <----- OOM!!!!!
  * Instead, introduce backpressure
    * akka-http introduces this
    * recent reactive manifesto updates are trying to standardize
  * still no first class failure handling
  * What do we do when we've got too much pressure in our pipes?
    * drop incoming data?
* Rx
  * Some extra boilerpate to register callbacks and observables
  * Still not great at first-class failure handling
* Actors
  * autonomous agents encapsulating state
  * actors can be selective about how they mutate underlying state
  * local thread safety
  * local supervisor handle failure that's bubbled up

## What's missing?

* Generic enough libraries?
* Why u no use Rx? (and your languages' lib)
