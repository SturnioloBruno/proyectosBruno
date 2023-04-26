import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private  static Map<String, Double> pricesByAirLine;

    public static void main(String[] args) throws InterruptedException {
        init();
        String from = "BCN";
        String to = "JFK";

        Double lowestPrice = getLowestPrice(from, to);
        Double avgPrice = getAvgPrice(from,to);

        System.out.println(lowestPrice +" y "+ avgPrice);

        // el from y el to no estan implementados, pero es solo un ejemplo para mostrar variables atomicas
    }
    private static void init() {
        pricesByAirLine = new HashMap<>();
        pricesByAirLine.put("American Airlines", 550.0);
        pricesByAirLine.put("US Airway", 610.0);
        pricesByAirLine.put("Qatar Airways", 590.0);
        pricesByAirLine.put("Delta Airlines", 540.0);
        pricesByAirLine.put("Singapore Airlines",612.0);
        pricesByAirLine.put("Cathay Pacific Airways", 585.0);
        pricesByAirLine.put("Sky Airline", 540.0);
        pricesByAirLine.put("Copa Airlines Colombia", 610.0);
        pricesByAirLine.put("Avianca", 580.0);
        pricesByAirLine.put("LATAM Airlines Group", 600.0);
        pricesByAirLine.put("Aeromexico", 740.0);
        pricesByAirLine.put("Aerolineas Argentinas", 940.0);
    }

    private static Double getPriceTrip(String airLine, String from, String to) {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return pricesByAirLine.get(airLine);
    }

    private static Double getLowestPrice(String from, String to) {
        AtomicReference<Double> lowestPrice = new AtomicReference<>(null);
        pricesByAirLine.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            if (lowestPrice.get() == null || lowestPrice.get() > price) {
                lowestPrice.set(price);
            }
        });
        return lowestPrice.get();
    }

    private static Double getAvgPrice(String from, String to) {
        AtomicReference<Double> sumPrice = new AtomicReference<>(0.0);
        AtomicInteger countAirLines = new AtomicInteger(0);
        pricesByAirLine.keySet().stream().parallel().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            Double result = sumPrice.get() + price;
            sumPrice.set(result);
            countAirLines.incrementAndGet();
        });


        return sumPrice.get() / countAirLines.get();
    }

}