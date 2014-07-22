# Learn Dependently-Typed Programming with Idris

## What we know

* Curry-Howard
  * -> types are propositions
    * so let's make them interesting
* Given provable methods, let's make provable code

## What we want

* Make types _depend_ on programs
  * Health form example, can only fill in later parts given your type from before
* Code that benefits from provability
  * Cypto
  * Scientific
  * Payment processing

## Real World Programming

* iridium (tiling window manager)
  * represents windows (and the current focus) via a zipper

## Polymorphism

* Free functions and type constructors that are really dependent on the incoming types
* Let's us write more concise code blocks.

## Overall

* Evaluation is _really_ normalisation!
* Can always defer results
* Watch out for totality checker

## Notes / Links

* iQuery
* idris2048
* idris-crypto
