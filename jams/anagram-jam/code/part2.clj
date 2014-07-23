;; part 2

;; ## Part 2 - Matching Multiple Words
;; Given the same file of known words, develop a program that takes a phrase
;;   (words separated with spaces) and finds a set of anagrams in the word list.
;;
;; For example: given the word "functional", you might find anagrams like:
;;
;; ```
;; final count
;; fun lion cat
;; no final cut
;; ```
;;
;; You might find that your results are not always as interesting as you'd like.
;; What kinds of sorting and de-duplication can you apply to give you better,
;; more interesting results?

(def part1-deps
  "/Users/adam/src/conferences/lambda-jam-2014/jams/anagram-jam/code/part1.clj")

(load-file part1-deps)

(defn condense-phrases [car & more]
  (clojure.string/join (concat car (clojure.string/join more))))

(defn find-anagrams-from-phrase [first & more]
  (find-anagrams (condense-phrases first more)))

(defn main []
  (find-anagrams-from-phrase '("no" "final" "cut"))
  (find-anagrams-from-phrase '("pla" "net"))
  (find-anagrams-from-phrase '("planet")))

(main)
