package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {

    Scanner myScanner = new Scanner(System.in);

    public int readInt(String prompt){

        int num = 0;
        try {
            System.out.println(prompt);
            num = Integer.parseInt(myScanner.nextLine());
        }
        catch (Exception e)
        {
            readInt(prompt);
        }
        return num;
    }


    public long readLong(String prompt){
        long num = 0;
        try {
            System.out.println(prompt);
            num = Long.parseLong(myScanner.nextLine());
        }
        catch (Exception e)
        {
            readLong(prompt);
        }
        return num;
    }

    public double readDouble(String prompt){

        double num = 0;
        try {
            System.out.println(prompt);
            num = Double.parseDouble(myScanner.nextLine());
        }
        catch (Exception e)
        {
            readDouble(prompt);
        }
        return num;
    }

    public float readFloat(String prompt){

        float num = 0;
        try {
            System.out.println(prompt);
            num = Float.parseFloat(myScanner.nextLine());
        }
        catch (Exception e)
        {
            readFloat(prompt);
        }
        return num;
    }
    public String readString(String prompt){

        String str = "";
        try {
            System.out.println(prompt);
            str = myScanner.nextLine();
        }
        catch (Exception e)
        {
            readString(prompt);
        }
        return str;
    }




}
