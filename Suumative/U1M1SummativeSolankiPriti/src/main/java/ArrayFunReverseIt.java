public class ArrayFunReverseIt {

    public static void main(String[] args) {
        int  numbers[] = {1, 2, 3, 4, 5};
        int j = numbers.length;
        int reverse[] = new int[j];

        for (int i=0; i<numbers.length; i++){
            reverse[i] = numbers[j-1];
            j--;
        }
        System.out.println("The Original Array : ");
        for (int i=0; i<numbers.length; i++) {

            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nThe Reversed Array : ");
        for (int i=0; i<reverse.length; i++) {

            System.out.print(reverse[i] + " ");
        }
    }
}


