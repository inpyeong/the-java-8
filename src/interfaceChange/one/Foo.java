package interfaceChange.one;

public interface Foo {

    void printName();

    // 기본 메소드(Defalut Methods)
    // 구현체에 따라 컴파일에러가 발생할 수도 있다.
    // 반드시 문서화를 해야 한다.(@ImplSpec)

    /**
     * @ImplSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // object 가 제공하는 기능은 기본 메소드 불가
//    default String toString() {
//
//    }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();

}
