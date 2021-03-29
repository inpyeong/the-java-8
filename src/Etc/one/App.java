package Etc.one;

import java.util.Arrays;
import java.util.List;

@Chicken("마늘간장")
@Chicken("양념")
public class App {

    public static void main(String[] args) {
        ChickenContainer annotation = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

}
