# One Strange Type

## Goals

* Leverage types to design strict representations.
* Cog lets us use inductive types as definitions
  * In a quasi natural language

## Natural numbers

* Just represent them as Peano numbers?
  * Not well defined on `/` or `-` relations over the set

## CoolNumber

* `n` is a CoolNumber iff:
  * 0
  * 2 * CoolNumber
  * 1 + (2 * CoolNumber)

### Binary deconstruction

* Binary representations allow a fairly easy reverse analog to composition.
  * Of successor and identity elements
  * Composition directly implies provability

## Induction

* Cog let's us prove propositions (ergo functions) on more than just a type level.
* Via induction, we can prove properties about closed mathematical relations over a set.
  * Aka, create our own groups!

## It's all about the representation.

* Paper vs code
  * Which is easier? Which is "better"?
* Interactivity
* Debugging
* Algebraic datatypes
  * Drives us easily into inductive types
