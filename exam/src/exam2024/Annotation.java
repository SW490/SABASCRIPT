package exam2024;


class B {
    int x = 3;
    int getX() {
        return x * 2;
    }
}

class A extends B {
    int x = 7;
    @Override
    int getX() {
        return x * 3;
    }
}
public class Annotation {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        System.out.println(b.getX());
        System.out.println(a.getX());
        System.out.println("________________________");

        B b1 = new A();
        A b2 = new A();
        System.out.println(b1.x);
        System.out.println(b1.getX());
        System.out.println(b2.x);
        System.out.println(b2.getX());
        System.out.println("sum: " + (b1.x + b1.getX() + b2.x + b2.getX()));
    }
}
