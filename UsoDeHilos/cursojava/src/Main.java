import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Download webs
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com");
        links.add("https://www.bbc.com/news/uk-611196071");
        links.add("https://www.bbc.com/news/world-africa-65374093");
        links.add("https://www.bbc.com/news/world-us-canada-65379340");
        links.add("https://www.bbc.com/news/world-middle-east-65374749");

        links.stream().parallel().forEach(link -> getWebContent(link));



        String result = getWebContent(links.get(0));

        System.out.println(result);
    }

    private synchronized static String getWebContent(String link){
        System.out.println("INIT");
        System.out.println(link);
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream input = conn.getInputStream();
            System.out.println("END");
            return new BufferedReader(new InputStreamReader(input))
                    .lines().collect(Collectors.joining());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
}