;; tests

;; try out some cases!
;; planet (6 letters, 3 anagrams)
;; senator (7 letters, 20 anagrams)
;; hello world (10 letters, 5 anagrams)
;; clint eastwood (13 letters, 1156 anagrams)
;; anagram jammer (13 letters, 1 anagram)
;; back to the future (15 letters, 316 anagrams)

(def part-k-deps
  "/Users/adam/src/conferences/lambda-jam-2014/jams/anagram-jam/code/part3.clj")

(find-anagrams "planet")
(find-anagrams "senator")

(find-anagrams-from-phrase "hello" "world")
(find-anagrams-from-phrase "hello world")

(find-anagrams-from-phrase "clint" "eastwood")
(find-anagrams-from-phrase "clint eastwood")

(find-anagrams-from-phrase "anagram" "jammer")
(find-anagrams-from-phrase "anagram jammer")

(find-anagrams-from-phrase "back to the future")
(find-anagrams-from-phrase "back" "to" "the" "future")
