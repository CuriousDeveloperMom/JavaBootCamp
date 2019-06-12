package com.company;

import java.util.*;

public class CarLists {

    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");

        //Creating a List
        ArrayList<String> toyotaList = new ArrayList<String>();
        toyotaList.add("Camry");
        toyotaList.add("Corolla");
        toyotaList.add("Highlander");

        //Creating a List
        ArrayList<String> fordList = new ArrayList<String>();
        fordList.add("Mustang");
        fordList.add("Fusion");
        fordList.add("Taurus");

        //Creating a List
        ArrayList<String> hondaList = new ArrayList<String>();
        hondaList.add("Accord");
        hondaList.add("Civic");
        hondaList.add("Fit");

        //Store all 3 Lists in Map
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        map.put("Toyota", toyotaList);
        map.put("Ford", fordList);
        map.put("Honda", hondaList);

        Set<Map.Entry<String, ArrayList<String>>> myEntries = map.entrySet();
        System.out.println("Make                Model");
        System.out.println("***************************************");
        for (Map.Entry<String, ArrayList<String>> entry : myEntries){
            System.out.println(entry.getKey() + "           " + entry.getValue());
        }
    }
}
