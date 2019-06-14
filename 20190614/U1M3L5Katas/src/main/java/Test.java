import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                List<Television> tvs;
                tvs = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
                });
                // Get all TVs with a screen size greater than 60
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
                // Group all televisions into a Map by brand.
                Map<String, List<Television>> tvsByBrand =
                        tvs
                                .stream()
                                .collect(Collectors.groupingBy(t -> t.getBrand()));
                // Print manufacturers
                System.out.println("MANUFACTURERS: ");
                Set<String> keys = tvsByBrand.keySet();
                for (String key : keys) {
                    System.out.println(key);
                }
                System.out.println("======================");
                // Find and display average screenSize
                double avgScreenSize =
                        tvs
                                .stream()
                                .mapToInt(t -> t.getScreenSize())
                                .average()
                                .getAsDouble();
                System.out.println("Average Screen Size: " + avgScreenSize);
                // Find and display the largest screen
                int maxScreenSize =
                        tvs
                                .stream()
                                .mapToInt(t -> t.getScreenSize())
                                .max()
                                .getAsInt();
                System.out.println("Largest Screen Size: " + maxScreenSize);
            } catch (Exception e) {
                System.out.println("An error occurred: ");
                System.out.println(e.getMessage());
            }
        }
    }



