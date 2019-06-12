package com.company.RefactoredUsingArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        // List<String> wordList = new ArrayList<String>();
        List<String> wordList = new ArrayList<String>(Arrays.asList("byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"));

        for (String element : wordList) {
            System.out.println(element);
        }
    }
}