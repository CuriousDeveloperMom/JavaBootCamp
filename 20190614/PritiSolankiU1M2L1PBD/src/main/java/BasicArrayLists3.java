import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        Random ran = new Random();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i, ran.nextInt(89)+10);
        }
        System.out.println("ArrayList : " + numbers);
    }
}