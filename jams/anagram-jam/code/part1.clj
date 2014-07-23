;; part 1

;; ## Part 1 - Matching Single Words
;; Given a file of known words, develop a program that takes a word and finds a set of
;; anagrams in the word list. Test with command line, or just in a repl/shell.
;; For example: given the word "taco", you should find the anagram "coat".
;; You may find that pre-processing the word list (either in memory or on disk) will help.

(def known-words
  "/Users/adam/src/conferences/lambda-jam-2014/jams/anagram-jam/code/anagram-jam/4000words.txt")

(use 'clojure.java.io)
(defn read-and-process-file [f]
  (with-open [reader (reader known-words)]
    (doseq [line (line-seq reader)]
      (when (not (= line nil))
        (f line)))))

(defn sort-word [word]
  (sort word))

(defn compare-words [w1 w2]
  (and
   (= (sort-word w1) (sort-word w2))
   (= (count w1) (count w2))))

(defn print-when-anagrams [incoming dict-word]
  (when (compare-words incoming dict-word)
    (println dict-word)))

(defn find-anagrams [incoming]
  (println (str "finding anagrams for " incoming))
  (read-and-process-file (fn [dict] (print-when-anagrams incoming dict))))

;; (defn main []
;;   (find-anagrams "taco")
;;   (find-anagrams "meat"))

;; (main)
