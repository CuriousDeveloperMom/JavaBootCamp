package com.company;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int[] arr = getArrayInput();


        System.out.println("The sum of all values in the array is : " + total(arr));
        System.out.println("The sum of values of odd indexes of array is : " + totalOdd(arr));
        System.out.println("The sum of values of even indexes of array is : " + totalEven(arr));
        System.out.println("The 2nd Largest number of array is : " + secondLargestNumber(arr));
        System.out.print("\nEnter Number of Inputs (for swap first and last) : ");
        String [] str = getStringInput();
        swapFirstAndLast(str);
        reverse(arr);
        System.out.println("\nEnter Number of inputs (you want to concatenate : ");
        String [] strconcat = getStringInput();
        System.out.println("Result of concatenation : " + concatenateString(strconcat));
        everyThird(arr);
        //lessThanFive(arr);

    }

    public static int[] getArrayInput() {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Number of Inputs : ");
        int arraySize = Integer.parseInt(myScanner.nextLine());
        int[] arrayInput = new int[arraySize];

        for (int i = 0; i < arrayInput.length; i++) {
            System.out.print("Enter your number (" + (i + 1) + ") : ");
            arrayInput[i] = Integer.parseInt(myScanner.nextLine());
        }
        return arrayInput;
    }

    public static int total (int [] array){
        int sum = 0;
        for (int element : array){
            sum = sum + element;
        }
        return sum;
    }

    public static int totalOdd (int [] array){
        int sum = 0;

        for (int i=1; i < array.length; i=i+2){

            sum = sum + array[i];
        }
        return sum;
    }

    public static int totalEven (int [] array){
        int sum = 0;

        for (int i=0; i < array.length; i=i+2){

            sum = sum + array[i];
        }
        return sum;
    }

    public static int secondLargestNumber(int[] array) {
        int max2 = 0;
        int tempVar = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[i] > array[j])
                {
                    tempVar = array[i];
                    array[i] = array[j];
                    array[j] = tempVar;
                }
            }
        }
        max2 = array[array.length-2];
        return max2;
    }


    public static String[] getStringInput() {

        Scanner myScanner = new Scanner(System.in);

        int arraySize = Integer.parseInt(myScanner.nextLine());
        String[] arrayInput = new String[arraySize];

        for (int i = 0; i < arrayInput.length; i++) {
            System.out.print("Enter your text (" + (i + 1) + ") : ");
            arrayInput[i] = myScanner.nextLine();
        }
        return arrayInput;
    }

    public static void swapFirstAndLast(String[] str1){

        String temp;
        System.out.println("String in original order : ");
        for (int i = 0; i < str1.length; i++) {
            System.out.print(str1[i] + "  ");
        }
        temp = str1[0];
        str1[0] = str1[str1.length-1];
        str1[str1.length-1] = temp;
        System.out.println("");
        System.out.println("String after swapping first and last element : ");
        for (int i = 0; i < str1.length; i++) {
            System.out.print(str1[i] + "  ");
        }

    }

    public static void reverse(int [] array) {
        System.out.println("\nThe Original array : ");
        for (int i=0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        int [] revarr = new int [array.length];
        for (int i = (array.length -1); i >= 0; i--) {
            revarr[i] = array[array.length-(i+1)];
        }
        System.out.println("\n The Reversed Array : ");
        for (int i = 0; i < revarr.length; i++) {
            System.out.print(revarr[i] + "  ");
        }
    }

    public static String concatenateString(String [] constr){
        String resultConcat = "";
            for (int i = 0; i < constr.length; i++){
                resultConcat = resultConcat + constr[i];
            }
        return resultConcat;
    }

    public static int[] everyThird(int [] numbers){
        int [] array3rdelement = new int[numbers.length];
        System.out.println("\nOriginal values of array : ");
        for (int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nEvery 3rd values of array : ");
            for (int i = 2; i < numbers.length; i=i+3){
                    array3rdelement[i] = numbers[i];
                    System.out.print(array3rdelement[i] + " ");
            }
     return array3rdelement;
    }

/*    public static int[] lessThanFive(int[] numbers){
        int [] temp = new int[numbers.length];
        int countTotalLessThan5 = 0;
        int j=0;

        for (int i=0; i < numbers.length; i++){
            if (numbers[i] < 5){
                j++;
                temp[j] = numbers[i];
                countTotalLessThan5++;
            }
        }
        System.out.print("\nOriginal values of array : ");
        for (int i=0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nTotal values less then 5 : " + countTotalLessThan5);
        int [] arrayLessThan5 = new int[countTotalLessThan5];
        int x = 0;
        for (int y=0; y < numbers.length; y++){
            if (numbers[y] < 5){
                arrayLessThan5[x] = numbers[y];
                x++;
            }
        }
        System.out.print("\nArray of less then 5 values : ");
        for (int i=0; i < arrayLessThan5.length; i++){
            System.out.print(arrayLessThan5[i] + " ");
        }
        if(countTotalLessThan5 > 0)
            return arrayLessThan5;
        else
            return null;
    } */

}


