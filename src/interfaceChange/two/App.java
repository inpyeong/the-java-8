package interfaceChange.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesum");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        names.forEach((s) -> System.out.println(s));

        names.forEach(System.out::println);

        for(String name : names) {
            System.out.println(name);
        }

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("------");
        while (spliterator1.tryAdvance(System.out::println));

        long k = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println(k);

        names.removeIf(s -> s.startsWith("k"));
        names.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);

    }
}
