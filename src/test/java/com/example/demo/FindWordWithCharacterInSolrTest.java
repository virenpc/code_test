package com.example.demo;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindWordWithCharacterInSolrTest {
    private static final String SOLR_URL = "http://localhost:8983/solr/your_core";
    private static HttpSolrClient solrClient;

    @BeforeAll
    public static void setup() throws Exception {
        solrClient = new HttpSolrClient.Builder(SOLR_URL).build();
        String statement = "This is a very long sentence and I want to educate everyone in this whole crazy world…";
        FindWordWithCharacterInSolr.indexData(statement);
    }

    @Test
    public void testFindWordWithMostChar_Case1() throws Exception {
        char inputChar = 'z';
        String expected = "crazy";
        String actual = FindWordWithCharacterInSolr.findWordWithMostChar(inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_Case2() throws Exception {
        char inputChar = 'I';
        String expected = "I";
        String actual = FindWordWithCharacterInSolr.findWordWithMostChar(inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_Case3() throws Exception {
        char inputChar = 'e';
        String expected = "sentence";
        String actual = FindWordWithCharacterInSolr.findWordWithMostChar(inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_NoOccurrences() throws Exception {
        char inputChar = 'x';
        String expected = "";
        String actual = FindWordWithCharacterInSolr.findWordWithMostChar(inputChar);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindWordWithMostChar_MultipleWordsSameCountAndLength() throws Exception {
        String statement = "This test case checks multiple words with same number of given character and same length";
        FindWordWithCharacterInSolr.indexData(statement);

        char inputChar = 't';
        String expected = "test";
        String actual = FindWordWithCharacterInSolr.findWordWithMostChar(inputChar);
        assertEquals(expected, actual);
    }
}
