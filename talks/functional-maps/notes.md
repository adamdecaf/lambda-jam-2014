# Functional Maps

## Goals

* There's ton's of things in computer science that we don't talk about in FP
* Why is that?
* Can we use some FP things to talk about them?

## Making maps really really fast

```haskell
-- Production:
empty :: Ord k => Map k a
insert :: Ord k => K -> a -> Map k a -> Map k a

-- Consumption
null :: Ord k => Map k a -> Bool
lookup :: Ord k => k -> Map k a -> Maybe a
```

## What can we build that's a map?

* Array of (key,value) w/ sorted keys
  * Binary search it
  * Updates suck
    * Can cause cache misses on large enough arrays

## Static Data Structures

* Given a static data structure, and a way to know how to merge sub sections of it
* We can just setup a sequence of them, each growing porportional to a power of 2 more than the last
* Thus, we'll walk down this sequence for inserts.
  * Worst case is `O(n/B)` for rare inserts that make us rebuild everything.
  * Average would be `O(log(n))/B`
  * `B` is still unknown though.
* Not great overall performance.

## Zeroless Binary

* Digits are 1,2
* Unique representation
* `data N = Zero | One N | Two N`
* Use these numbers to alloc arrays for caching
  * So we're always "just enough" steps ahead in our cache strategy
* Modified system
  * Digits are 1,2,3
  * Unique representation
    * Only leading digit can be 1
  * "Just the right amount of lag"
  * `data N = Zero | One | Two N | Three N`

## What does this give us?

* ~7-10x faster than `Data.Map`
* Easily mmaped'ed from disk for offline storage
* Range queries are a lot faster
* Matches insert performance of a B-Tree without knowing B
* Nothing to tune
* `O(log2(N/B) + a/B)` search structure
  * Use a series of bloom filters to bypass this
    * Not cache obvilious

## Use cases

* Computational geomertry problems
* Generalizable for many other data structures
