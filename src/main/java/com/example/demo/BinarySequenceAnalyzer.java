package com.example.demo;
public class BinarySequenceAnalyzer {

    public static int findLongestOneSequence(int inputNumber) {
        if (inputNumber == 0) {
            return 0;
        }

        String binaryRep = Integer.toBinaryString(inputNumber);
        int maxSeqLength = 0;
        int currentSeqLength = 0;
        int longestSeqStartPos = -1;
        int tempSeqStartPos = -1;

        for (int i = 0; i < binaryRep.length(); i++) {
            if (binaryRep.charAt(i) == '1') {
                if (currentSeqLength == 0) {
                    tempSeqStartPos = i + 1; // positions are 1-indexed
                }
                currentSeqLength++;
                if (currentSeqLength > maxSeqLength) {
                    maxSeqLength = currentSeqLength;
                    longestSeqStartPos = tempSeqStartPos;
                }
            } else {
                currentSeqLength = 0;
            }
        }

        return longestSeqStartPos;
    }
}
