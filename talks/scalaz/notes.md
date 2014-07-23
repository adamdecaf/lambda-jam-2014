# Scalaz: the history, the motivation, the battles, the future

## History

* Beam*Factory sucks
* We can only know when code is good by `wc -l` right??
* Why can't we make code easy and flexible

## Goals

```scala
def value[A, B](
  f: List[A => B]
  x: A
): List[B]
```

* Parametricity
  * being general can actually let us become more strict in results
    * However, we still have some questions
      * Do we use every function?

```scala
def value[F[_]: Functor, A, B](
  f: F[A => B],
  x: A
): F[B]
```

* We know exactly what this method does.
  * It applies the methods in f to x and produces a b.
    * That's it, nothing else, nothing fancy.
* No "single source" of function level knowledge

## Equational Reasoning

* Let's us scale our code (yes `wc -l`)
* not having to reason about weird flakey reasoning

```scala
val s = new StringBuilder
val res = s append "bad"
res
res
println(s)

// doesn't equal
val s = new StringBuilder
//val res = s append "bad"
s append "bad"
s append "bad"
println(s)
```

* How can we write code that will be more apparent on failure like this.

## Abstraction

* Monad
  * It's really just point and flatMap
  * Sequence in generic terms: `List[F[A]] -> F[List[A]]`
* Countless others
  * functors, applicatives, monoid, etc...
