import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(i, ran.nextInt(99));
        }
        //System.out.println(numbers.size());

        System.out.println("ArrayList : " + numbers);



    }
}
