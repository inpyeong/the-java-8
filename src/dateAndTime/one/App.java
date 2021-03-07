package dateAndTime.one;

import java.util.Date;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        // java.util.Date 클래스는 mutable 하다.
        // thread safe 하지 않다.
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);
    }
}
