package exam2024;

class Parent2 {
	int compute(int num) {
		if(num <= 1)
			return num;
		return compute(num - 1) + compute(num - 2);
	}
}
class Child2 extends Parent2 {
	int compute(int num) {
		if(num <= 1)
			return num;
		return compute(num - 1) + compute(num - 3);
	}
}

public class Main {
    
    public static void main(String[] args) {
        Parent2 obj = new Child2();
        System.out.print(obj.compute(7));
        
    }
}
/*c(7)
= c(6) + c(4)
= c(5) + c(3) + c(3) + c(1)
= c(4) + c(2) + c(2) + c(0) + c(2) + c(0) + 1
= c(3) + c(1) + c(1) + c(-1) + c(1) + c(-1) + 0 + c(1) + c(-1) + 0 + 1
= c(2) + c(0) + 1 + 1 - 1 + 1 - 1 + 0 + 1 - 1 + 0 + 1
= c(1) + c(-1) + 0 + 1 + 1 - 1 + 1 - 1 + 0 + 1 - 1 + 0 + 1
= 1 - 1 + 0 + 1 + 1 - 1 + 1 - 1 + 0 + 1 - 1 + 0 + 1 = 2
*/