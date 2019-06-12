package com.company.MapFun;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFun {
    public static void main(String[] args) {

        // Declare and initialize a Map

        Map<String, Integer> cars = new HashMap<String, Integer>();

        // Creating Map entries

        cars.put("Toyota Camry", 2012);
        cars.put("Chevy Camaro", 1969);
        cars.put("Hyundai Genesis", 2015);
        cars.put("Jeep Wrangler", 2003);
        cars.put("Honda Civic", 2018);
        cars.put("Toyota Supra", 1995);
        cars.put("Pontiac GTO", 1964);

        Set<String> keys = cars.keySet();

        System.out.println("***********************************************************");
        System.out.println("All Key/Values Pair in the Map : ");
        System.out.println("***********************************************************");
        for (String key : keys) {
            System.out.println(key + "       " + cars.get(key));
        }

        //Adding two new Entries to Map
        cars.put("Ford Explorer", 2012);
        cars.put("Smart Fortwo", 2013);
        System.out.println("***********************************************************");
        System.out.println("All Key/Values Pair in the Map after adding two new Entries");
        System.out.println("***********************************************************");
        for (String key : keys) {
            System.out.println(key + "       " + cars.get(key));
        }

        // Now remove "Jeep Wrangler" entry
        cars.remove("Jeep Wrangler");
        System.out.println("***********************************************************");
        System.out.println("All Key/Values Pair in the Map after removing Jeep Wrangler");
        System.out.println("***********************************************************");
        for (String key : keys) {
            System.out.println(key + "       " + cars.get(key));
        }

    }
}