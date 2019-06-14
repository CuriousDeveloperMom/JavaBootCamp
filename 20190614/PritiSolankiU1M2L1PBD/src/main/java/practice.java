import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>(Arrays.asList("a","bb","ccc"));

        System.out.println(addStar(list));

    }
    public static List<String> addStar(List<String> strings) {

        List<String> list = new ArrayList<String>();

        for (int i=0; i<(strings.size()-1); i++){
            list.set(i, strings.get(i)+"*");
        }
        return list;
    }
}
