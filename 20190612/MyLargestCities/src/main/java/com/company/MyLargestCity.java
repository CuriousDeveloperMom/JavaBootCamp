package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyLargestCity {
    public static void main(String[] args) {
        City city1 = new City("New York", 8654321);
        City city2 = new City("Los Angeles", 4563218);
        City city3 = new City("Chicago", 2716520);
        City city4 = new City("Denver", 704621);
        City city5 = new City("Des Moines", 217521);
        City city6 = new City("Atlanta", 486213);

        System.out.println("CITY " + city1.getPopulation());
        Map<String, City> cities = new HashMap<>();
        cities.put("New York", city1);
        cities.put("Los Angeles", city2);
        cities.put("Chicago", city3);
        cities.put("Denver", city4);
        cities.put("Des Moines", city5);
        cities.put("Atlanta", city6);

        Set<Map.Entry<String, City>> myEntries = cities.entrySet();
        System.out.println("Name of City     Population");
        for (Map.Entry<String, City> entry : myEntries) {
            System.out.println(entry.getKey() + "      " + entry.getValue().getPopulation());
        }

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter any Number (Population) : ");
        int popNum = Integer.parseInt(scan.nextLine());

        System.out.println("Cities with a population more than " + popNum);

        Set<String> keys = cities.keySet();

        for (String element : keys) {
            if (cities.get(element).getPopulation() > popNum) {
                System.out.println(cities.get(element).getName());
            }
        }
    }
}