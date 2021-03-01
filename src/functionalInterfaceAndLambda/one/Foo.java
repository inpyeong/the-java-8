package functionalInterfaceAndLambda.one;

public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = (number) -> {
            return number + 10;
        };
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
    }
}

