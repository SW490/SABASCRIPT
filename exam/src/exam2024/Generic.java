package exam2024;

class Printer {
    void print(Integer a) {
        System.out.println("A" + a);
    }
    void print(Object a) {
        System.out.println("B" + a);
    }
    void print(Number a) {
        System.out.println("C" + a);
    }
}

public class Generic {

    public static void main(String[] args) {

        new Container<>(0).print();
    }
    public static class Container<T>{
        T value;
        public Container(T t) {
            value = t;
        }
        public void print() {
            new Printer().print(value);
        }
    }
}