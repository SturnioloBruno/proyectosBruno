import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> countries = new ArrayList<>();
        countries.add("United States");
        countries.add("Argentina");
        countries.add("Spain");
        countries.add("Italy");

        Optional<String> country = countries.stream().filter(c -> c.startsWith("Arg")).findFirst();

        country.ifPresent(System.out::println);
    }

    public static void exampleOptional() {
        Optional<Double> result = averageScores(7.0,8.0,4.0,10.0);
        if (result.isPresent()) {
            System.out.println(result.get());
        }else {
            System.out.println("Nothing");
        }
    }

    public static Optional<Double> averageScores(Double ...scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (Double score :
                scores) {
            sum+=score;
        }
        return Optional.of(sum/scores.length);
    }
}