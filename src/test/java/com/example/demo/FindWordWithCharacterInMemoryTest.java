package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FindWordWithCharacterInMemoryTest {

    @Test
    public void testFindWordWithMostChar_Case1() {
        String statement = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        char inputChar = 'z';
        String expected = "crazy";
        String actual = FindWordWithCharacterInMemory.findWordWithMostChar(statement, inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_Case2() {
        String statement = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        char inputChar = 'I';
        String expected = "I";
        String actual = FindWordWithCharacterInMemory.findWordWithMostChar(statement, inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_Case3() {
        String statement = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        char inputChar = 'e';
        String expected = "sentence";
        String actual = FindWordWithCharacterInMemory.findWordWithMostChar(statement, inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_NoOccurrences() {
        String statement = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        char inputChar = 'x';
        String expected = "";
        String actual = FindWordWithCharacterInMemory.findWordWithMostChar(statement, inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_MultipleWordsSameCountAndLength() {
        String statement = "This test case checks multiple words with same number of given character and same length tied together";
        char inputChar = 't';
        String expected = "test";
        String actual = FindWordWithCharacterInMemory.findWordWithMostChar(statement, inputChar);
        assertEquals(expected, actual);
    }
}
