package functionalInterfaceAndLambda.two;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> _plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> _multiply10 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return (integer * 2);
            }
        };

        Function<Integer, Integer> multiply10 = (i) -> i * 2;
        System.out.println(multiply10.apply(1));

        Function<Integer, Integer> multiply2AndPlus10 = _plus10.compose(multiply10);
        System.out.println(multiply2AndPlus10.apply(2));

        System.out.println(plus10.andThen(multiply10).apply(2));


        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);


        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());


        Predicate<String> startsWithInpyeong = (s) -> s.startsWith("inpyeong");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println(startsWithInpyeong.test("inpyeongLee"));


        UnaryOperator<Integer> __plus10 = (i) -> i + 10;

    }
}
