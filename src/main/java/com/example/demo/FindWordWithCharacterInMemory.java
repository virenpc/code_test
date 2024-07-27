package com.example.demo;
import java.util.regex.*;
import java.util.stream.Stream;

public class FindWordWithCharacterInMemory {

    // Function to find the word with the most occurrences of the given character
    public static String findWordWithMostChar(String statement, char inputChar) {
        // Split the statement into words using regex to handle punctuation
        String[] words = statement.split("[\\s.,!]+");

        return Stream.of(words)
                .map(word -> new WordInfo(word, countOccurrences(word, inputChar)))
                .filter(wordInfo -> wordInfo.count() > 0)  // Ensure we only consider words with the character
                .max((w1, w2) -> {
                    if (w1.count() == w2.count()) {
                        return Integer.compare(w2.word().length(), w1.word().length());
                    }
                    return Integer.compare(w1.count(), w2.count());
                })
                .map(WordInfo::word)
                .orElse("");
    }

    private static int countOccurrences(String word, char inputChar) {
        return (int) word.chars().filter(c -> c == inputChar).count();
    }
}

record WordInfo(String word, int count) {}
