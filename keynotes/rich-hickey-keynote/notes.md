# Rich Hickey Keynote

## Communication

* Cross language communication
* Just values, not identities or closures
  * Only strings, numbers, maps/dictionary, array/vector
  * Composition
* No _required_ schemas
  * there can't be a single best schema
* Self describing communication
  * data types at the bottom
  * have open set of schema/rules/validations for diff contexts at top
  * support generic intermediaries: editors, transformers, indexes, queries, merging

## Transit

* rich core type set
  * tagged extensions
* lang specific, plugabble, mappings, to/from runtime representations
* target / co-op existing high perf parsers
  * encode to json/MessagePack

### Types

* Scalars
  * nil/null, strings, booleans
  * ints, floats
* Composites
  * heterogeneous arrays, maps w/scalar keys
* map to underlying format (where supported)

__Types__

* scalar (stringable)
  * singel-char tag
  * representation as string (not for aggregates)
* composite
  * longer tag + representation value
* core scalar types:
  * timestamps,
  * arb-precision ints / decimals
  * uuid / uri
  * keywords, symbols
  * binary
* core composite tagged types:
  * heterogeneous sets / lists
  * self-describing links
  * maps with composite keys
* user definable extension types:
  * string tag + representation value
  * scalars use single-char uppercase tag
    * must supply string representation
    * may supply non-string as well
  * composites use multi-char tag, namespaced
    * any representation value

__Program Representations__

* Read and Write handlers
  * bijection over a map (type/class <-> tag [+ rep(x)])

__Tagged Values__

* tag + representation value
* can be sent back and the sender gets back exactly what they sent

## Compression

* Readers _always_ cache stringable keys and scalars.
* Writers can optionally cache to their readers.
* Let's us maintain and parse smaller overall representations

## Links

* https://github.com/cognitect
* https://github.com/cognitect/transit-format
