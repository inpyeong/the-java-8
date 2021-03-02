package interfaceChange.one;

// 기본 메소드가 겹치는 경우 컴파일에러 발생
// 이런 경우 오버라이딩을 해줘야 한다.
//public class DefaultFoo implements Foo, Bar2 {

public class DefaultFoo implements Foo {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    // 기본 메소드도 override 가능
//    @Override
//    public void printNameUpperCase() {
//        System.out.println(this.name.toUpperCase());
//    }

    @Override
    public String getName() {
        return this.name;
    }
}
