# Erik Meijer

## Reactive Streams

* What does 'non-blocking back pressure' really mean?
  * Seems to be something new, perhaps only by typesafe?
* They seem to create objects that request things.
  * As per EWD, they can't do that!!

## Maths

* Why don't we define laws over any new interface that we use?
* Setup the duals between typeclasses in our code.
  * Allows for then easy composition later on

## Refactors

* Use maths to refactor our interfaces and typeclasses
* Don't forget to make things easy to understand.

## Words

* Interactive
  * Program requests only at the pace that it can move at
* Reactive
  * Program operates at the _speed of the environment_
* These terms have been defined for a long time before now.
  * Why don't we use them?

## History?

* Currying and UnCurrying
* Guy Steel -- "Continuation Passing Style" (1975)

```scala
def f(a: A): B = { ...; b }
def fAsync(a: A, cont: B => Unit): Unit = { ...; cont(b) }
h(f(a)) = fAsync(a, h)
```

## More Refactoring

```scala
// Remember
trait Iterable[T] {
  def iterator(): Iterator[T]
}

trait Iterator[T] {
  def moveNext(): T + Throwable + Unit
}

// Into
trait Iterator[T] {
  def moveNext(next: T + Throwable + Unit => Unit): Unit
}

// Then
trait Iterator[T] {
  def moveNext(next: T + Throwable + Unit => Unit)(n: Long): Unit
}

// Then
trait Iterator[T] {
  def request: (T + Throwable + Unit => Unit) => (Long => Unit)
}

// Then
trait Iterable[T] {
  def iterator(): (T + Throwable + Unit => Unit) => (Long => Unit)
}

// Then
trait Iterable[T] {
  def moveNext(next: T + Throwable + Unit => Unit)(n: Long): Unit
}

// Then
trait Iterable[T] {
  def iterator(
    nextMove: T + Then + Unit => Unit,
    onSubscribe: Long => Unit
  ): Unit
}

// Finally
trait Subscriber[T] {
  def onNext(value: T): Unit
  def onError(e: Throwable): Unit
  def onComplete(): Unit
  def onSubscribe(s: Subscription): Unit
}
```

## What this all means

* "Reactive Streams" == Async Iterables
* "Non-blocking backpressure" == "consumer pulls", producer delivers at request rate

## Is this usable?

* Is asking for `n` really backpressure?
  * `0`? `1`? Infinity?
* Assumes a closed world.
  * Assumes the producer can satisfy the pull model.
* Where are the laws?
* What happens with infinite streams?
  * Does it try and just concat?
  * Does it dovetail / merge each data obj as it's available


### Do special codes make sense?

* When asking for k what do?
  * 0: Pause ?
  * 1: Iterate ?
  * infinity: Stream? Push to consumer?

## Semantics

* GroupBy?
  * What if one producer is slow? Ticks less often?
* Slow source?
  * If a producer only generates stuff every 5 minutes, and we check every second?

## Rx

* Still a push based model (version 0.20)
* Fitted to these new interfaces.

## One last trick.

* The future is a Promise?

```scala
f(a: A): B
f(a: A, cb: B => Unit): Unit
f(a)(cb: B => Unit): Unit
f(a: A): (B => Unit) => Unit
f(a: A): Future[B]
```

* So we could even do something like this:

```scala
trait AsyncIterator[T] {
  def request(n: Long): Future[Seq[T]]
}
```

## What to pick?

* Iterable
* AsyncIterable
* Dart Streams
* Observable
* "Reactive" Streams

### Notes

* Each design pattern has tradeoffs
* Need to pick what's best for the specific solution
* It's not just the types, also pay attention to the laws from category theory
