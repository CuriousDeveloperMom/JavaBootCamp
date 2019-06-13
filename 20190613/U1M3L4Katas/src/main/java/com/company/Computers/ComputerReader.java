package com.company.Computers;

import com.company.Car;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {

        CSVReader reader = null;
        String[] currentCells = new String[0];
        String[] headings = new String[0];

    try{
        List<Computer> computers =
                new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

        for (Computer computer : computers) {
            System.out.println("=================================");
            System.out.println(computer.getBrand());
            System.out.println(computer.getModel());
            System.out.println(computer.getCpu());
            System.out.println(computer.getRam());
            System.out.println(computer.getStorageSize());
        }
    } catch (
    FileNotFoundException e) {
        System.out.println("Could not find CSV file: " + e.getMessage());
    }catch (IOException e) {
        System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
    }

    }

}
