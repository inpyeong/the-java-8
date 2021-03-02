package interfaceChange.one;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("inpyeong");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
