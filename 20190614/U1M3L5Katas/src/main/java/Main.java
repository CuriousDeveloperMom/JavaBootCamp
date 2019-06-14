import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Television> tvs = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            // Get all TVs with a screen size greater than 60
            System.out.println("All TVs with Screen Size greater than 60");
            tvs
                    .stream()
                        .filter(t -> t.getScreenSize() > 60)
                    .forEach(t -> {
                        System.out.println("Brand: " + t.getBrand());
                        System.out.println("Model: " + t.getModel());
                        System.out.println("Price: " + t.getPrice());
                        System.out.println("Screen Size: " + t.getScreenSize());
                        System.out.println("===============");
                    });
            // Group all televisions into Map by brand

            Map<String, List<Television>> groupedTVs =
                    tvs
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));
            System.out.println("Manufacutres");
            Set<String> keys = groupedTVs.keySet();
            for(String key : keys) {
                System.out.println(key);
            }
            System.out.println("###########################################");

            // Find and display average screenSize
            double avgScreenSize =
                    tvs
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average screenSize is: " + avgScreenSize);
            System.out.println("###########################################");

            int maxScreen =
                    tvs
                            .stream()
                            .mapToInt(bike -> bike.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Largest Screen : " + maxScreen);









        } catch (Exception e) {
        System.out.println("Could not find CSV file: " + e.getMessage());
    }
    }
}
