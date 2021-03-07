package Optional.two;

import Optional.one.OnlineClass;
import Optional.one.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

//        boolean present = onlineClass.isPresent();
//        System.out.println(present);

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

//        optional 이 존재하더라도 createNewClass 메소드는 실행한다.
//        OnlineClass onlineClass = optional.orElseGet(() -> createNewClass());

//        Supplier 가 작동하지 않는다.
//        함수형 인터페이스의 구현체이기 때문에 LAZY 하게 작동
        OnlineClass onlineClass = optional.orElseGet(App::createNewClass);
        System.out.println(onlineClass.getTitle());

//        대안이 없는 경우
//        optional.orElseThrow(IllegalStateException::new);

//        있는 것을 가정하고 해야 한다.
//        Optional<OnlineClass> onlineClass1 = optional.filter(oc -> !oc.isClosed());





        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
