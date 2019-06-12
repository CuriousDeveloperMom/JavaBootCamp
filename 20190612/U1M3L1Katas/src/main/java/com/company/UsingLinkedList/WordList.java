package com.company.UsingLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordList {
    public static void main(String[] args) {

        // List<String> wordList = new ArrayList<String>();
        List<String> wordList = new LinkedList<>(Arrays.asList("byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"));
        System.out.println("WordList Using LinkedList : ");
        for (String element : wordList) {
            System.out.println(element);
        }
    }
}
