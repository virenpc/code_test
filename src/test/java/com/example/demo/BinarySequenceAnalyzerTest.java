package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySequenceAnalyzerTest {

    @Test
    public void testFindLongestOneSequence_Case1() {
        assertEquals(4, BinarySequenceAnalyzer.findLongestOneSequence(156));
    }

    @Test
    public void testFindLongestOneSequence_Case2() {
        assertEquals(3, BinarySequenceAnalyzer.findLongestOneSequence(88));
    }

    @Test
    public void testFindLongestOneSequence_EdgeCase_Zero() {
        assertEquals(0, BinarySequenceAnalyzer.findLongestOneSequence(0));
    }

    @Test
    public void testFindLongestOneSequence_EdgeCase_One() {
        assertEquals(1, BinarySequenceAnalyzer.findLongestOneSequence(1));
    }

    @Test
    public void testFindLongestOneSequence_Case3() {
        assertEquals(1, BinarySequenceAnalyzer.findLongestOneSequence(255));
    }

    @Test
    public void testFindLongestOneSequence_Case4() {
        assertEquals(1, BinarySequenceAnalyzer.findLongestOneSequence(2730));
    }
}
