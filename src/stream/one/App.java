package stream.one;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        // 중개 오퍼레이션은 기본적으로 Lazy 하면서
        // 종료 오퍼레이션이 올 때까지 실행하지 않는다.
        // 그래서 항상 스트림 끝에는 터미널 오퍼레이션이 와야 한다.
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("------------");

        // names의 데이터는 변하지 않는다.
        names.forEach(System.out::println);

        for(String name : names) {
            if(name.startsWith("k")) {
                System.out.println(name.toUpperCase());
            }
        }

        // 데이터가 정말 방대한 경우 병렬 처리 사용한다.
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }
}
