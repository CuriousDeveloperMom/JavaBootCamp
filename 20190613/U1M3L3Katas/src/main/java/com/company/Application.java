package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        int petIndex = Pets.choosePet();

        try {
            String chosenPet = Pets.retrievePet(petIndex);
            Pets.readPetsFromFile();
            Pets.writePetToFile(chosenPet);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please Choose a pet available");
        } catch(NumberFormatException a){
            System.out.println("Please enter a valid number : " + a.getMessage());
        }catch (FileNotFoundException f){
            System.out.println("File Not Found");
        }catch (IOException e){
            System.out.println("IO exception");
        }


    }

}
