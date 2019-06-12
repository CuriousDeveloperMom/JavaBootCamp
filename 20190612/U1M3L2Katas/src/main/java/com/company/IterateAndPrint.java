package com.company;

import java.util.*;

public class IterateAndPrint {

    public static void main(String[] args) {

        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");

        System.out.println("****************************************************************");
        System.out.println("All Keys in Map : ");
        System.out.println("****************************************************************");
        //Printing All Keys in the Map
        Set<String> keys = baseballTeam.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("****************************************************************");
        System.out.println("All Values in Map : ");
        System.out.println("****************************************************************");
        //Printing All Values in the Map
        Collection<String> values = baseballTeam.values();
        for (String value : values) {
            System.out.println(value);
        }

        //Printing Both Keys and Values in the Map
        System.out.println("****************************************************************");
        System.out.println("All Keys and Values in the Map :");
        System.out.println("****************************************************************");


       // Set<String> keys = baseballTeam.keySet();
       // Map<String, Integer> baseballTeam = new HashMap<String, Integer>();
       Set<Map.Entry<String, String>> myEntries = baseballTeam.entrySet();

        for (Map.Entry<String, String> entry : myEntries){
            System.out.println(entry.getKey() + "           " + entry.getValue());
        }

    }
}