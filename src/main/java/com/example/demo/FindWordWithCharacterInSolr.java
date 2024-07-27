package com.example.demo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;

import java.util.ArrayList;
import java.util.List;

public class FindWordWithCharacterInSolr {
    private static final String SOLR_URL = "http://localhost:8983/solr/your_core";
    private static SolrClient solrClient = new HttpSolrClient.Builder(SOLR_URL).build();

    public static void indexData(String statement) throws Exception {
        String[] words = statement.split("[\\s.,!]+");

        for (String word : words) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", word.hashCode());
            document.addField("word", word);
            solrClient.add(document);
        }
        solrClient.commit();
    }

    public static String findWordWithMostChar(char inputChar) throws Exception {
        SolrQuery query = new SolrQuery();
        query.setQuery("word:*" + inputChar + "*");
        query.setRows(Integer.MAX_VALUE); // Fetch all matching results

        QueryResponse response = solrClient.query(query);
        List<String> results = new ArrayList<>();

        response.getResults().forEach(doc -> {
            Object fieldValue = doc.getFieldValue("word");
            if (fieldValue instanceof String) {
                results.add((String) fieldValue);
            } else if (fieldValue instanceof List) {
                results.addAll((List<String>) fieldValue);
            }
        });
        String bestWord = "";
        long maxCount = -1;
        int bestWordLength = -1;

        for (String word : results) {
            long count = word.chars().filter(c -> c == inputChar).count();
            if (count > maxCount || (count == maxCount && word.length() > bestWordLength)) {
                bestWord = word;
                maxCount = count;
                bestWordLength = word.length();
            }
        }

        return bestWord;
    }
}

