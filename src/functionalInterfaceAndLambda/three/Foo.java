package functionalInterfaceAndLambda.three;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(1, 2));

        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        // 자바 8에서는 변수가 사실상 final이면(변경되지 않는다면) final 키워드 생략 가능
        // effective final
        // 로컬 클래스와 익명 클래스에서 만약 baseNumber와 같은 이름의 변수가 있다면 쉐도잉된다.(각자 별도의 스코프를 가지기 때문이다.)
        //
        int baseNumber = 10;

        // 로컬 클래스, 중첩 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        };

        // 람다 표현식
        IntConsumer printInt = (i) -> {
            // int baseNumber = 11;
            System.out.println(i + baseNumber);
        };

        // final이 아니게 되여서 람다에서 참조할 수 없게 된다.
        // baseNumber++;

        LocalClass localClass = new LocalClass();
        localClass.printBaseNumber();
        integerConsumer.accept(10);
        printInt.accept(10);
    }
}
