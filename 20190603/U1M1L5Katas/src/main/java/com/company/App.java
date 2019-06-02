package com.company;

public class App {

    static int subtract(int a, int b){
        return a-b;
    }

    static int subtractOrZero(int a, int b){
        int diff = a - b;
        if (diff > 0)
            return diff;
        else
            return 0;
    }

    static int max(int a, int b, int c){
        if ((a>b) && (a>c))
            return a;
        else if ((b>a) && (b>c))
            return b;
        else
            return c;
    }

   static int min(int a, int b, int c){
        if ((a<b) && (a<c))
            return a;
        else if ((b<a) && (b<c))
            return b;
        else
            return c;
    }
    static  boolean isLarger(int first, int second){
       // boolean flag;
        if (first > second)
          //  flag = true;
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        System.out.println(subtract(5,3));
        System.out.println( subtractOrZero(3, 8));
        System.out.println(isLarger(12,19));
        System.out.println((max(81,59,79)));
        System.out.println((min(99,69,89)));
    }



}