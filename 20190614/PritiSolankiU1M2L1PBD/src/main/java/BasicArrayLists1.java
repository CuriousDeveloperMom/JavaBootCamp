import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            numbers.add(i, -113);
        }
        //System.out.println(numbers.size());

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("slot " + i + " contain a " + numbers.get(i));
        }

    }
}