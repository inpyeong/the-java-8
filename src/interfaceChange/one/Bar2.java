package interfaceChange.one;

public interface Bar2 {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
