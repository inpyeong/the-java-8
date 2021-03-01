package functionalInterfaceAndLambda.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        UnaryOperator<String> hi = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return "hi " + s;
            }
        };

        UnaryOperator<String> _hi = (s) -> "hi " + s;

        // 스테틱 메소드 참조
        UnaryOperator<String> __hi = Greeting::hi;

        // 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        // 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        Function<String, Greeting> inpyeongGreeting = Greeting::new;

        Greeting greeting1 = newGreeting.get();
        Greeting greeting2 = inpyeongGreeting.apply("inpyeong");

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = { "inpyeong", "jinee", "coolcool" };
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(hi.apply("inpyeong"));
        System.out.println(_hi.apply("inpyeong"));
        System.out.println(__hi.apply("inpyeong"));
        System.out.println(hello.apply("inpyeong"));
        System.out.println(greeting1.getName());
        System.out.println(greeting2.getName());
        System.out.println(Arrays.toString(names));
    }
}
