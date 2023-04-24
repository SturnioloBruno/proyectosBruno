import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread first = new Thread(counter,"First");
        Thread second = new Thread(counter,"Second");


        first.start();
        second.start();
        Thread.sleep(5_000);
        System.out.println(counter.count);
    }

    static class Counter extends Thread{
        public AtomicInteger count = new AtomicInteger(0);
        public void run() {
            for (int i = 0; i < 100_000_000; i++) {
                count.addAndGet(1);
            }
        }
    }
}