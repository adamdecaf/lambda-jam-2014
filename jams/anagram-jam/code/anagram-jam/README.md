# Anagram Jam

This jam will be out about creating anagrams.

A file of ~4000 common English words is included in this repository. You can find other word lists on the net if you'd prefer to use one that is smaller or larger.  Source: http://www.wordfrequency.info/

## Rules of the Jam

1. This jam can be done in any language. 
1. It's more fun to jam in a group.
1. Jams are an opportunity to try a new language - see if you can find an expert who's willing to sit in your group!

The last 45 minutes of the jam will be reserved for show-and-tell. Post a gist with your code and the hash tag #lambdajam. 

Interesting things to show:

1. What features of your language made this problem easier to solve?
2. What tricks did you learn about the problem itself?
3. What performance improvements did you find?

## Part 1 - Matching Single Words

Given a file of known words, develop a program that takes a word and finds a set of anagrams in the word list. Test with command line, or just in a repl/shell.

For example: given the word "taco", you should find the anagram "coat".

You may find that pre-processing the word list (either in memory or on disk) will help.

## Part 2 - Matching Multiple Words

Given the same file of known words, develop a program that takes a phrase (words separated with spaces) and finds a set of anagrams in the word list. 

For example: given the word "functional", you might find anagrams like:

```
final count
fun lion cat
no final cut
```

You might find that your results are not always as interesting as you'd like. What kinds of sorting and de-duplication can you apply to give you better, more interesting results?

## Part 3 - Making It Fast

Your implementation in Part 2 was probably not as fast as you would like. How can you make it faster? 

Some ideas:

- Pre-processing the word list
- Memoization
- Concurrency 
- Taking advantage of letter frequency

Keep track of your performance metrics as you improve! Here's some phrases to try:

```
planet (6 letters, 3 anagrams)
senator (7 letters, 20 anagrams)
   [ed. my favorite: "rat nose"]
hello world (10 letters, 5 anagrams)
clint eastwood (13 letters, 1156 anagrams) 
   [ed. so many good ones "old west action", "state cool wind", "stance too wild"]
anagram jammer (13 letters, 1 anagram)
back to the future (15 letters, 316 anagrams)
   [ed. "our fat butt cheek"?]
```
