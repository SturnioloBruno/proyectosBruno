import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Streams /Lambda

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Tokyo");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Bogota");
        cities.add("Ciudad de México");
        cities.add("Lima");

        for (int i = 0 ; i < cities.size() ; i++) {
            System.out.println(cities.get(i));
        }
        System.out.println("Hello world!");

        for (String city :
                cities) {
            System.out.println(city);
        }

        cities.stream().forEach(city -> System.out.println(city));
        cities.stream().forEach(Main::printCity);

        cities.stream().forEach(System.out::println);
        cities.forEach(System.out::println);

        cities.stream().parallel().forEach(System.out::println);
        cities.stream().filter(city -> city.startsWith("B")).forEach(System.out::println);

        cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .forEach(System.out::println);
    }

    public static void printCity(String city) {
        System.out.println(city);
    }
    public static boolean filterCity(String city) {
        return city.startsWith("B");
    }
}