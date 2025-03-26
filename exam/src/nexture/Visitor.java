package nexture;

public class Visitor extends ServiceMenu {

	String name;
	int age, total;
	
	public Visitor(String name, int age, int[] service) {
		super();
		this.name = name;
		this.age = age;
		total = 0;

		int[] menu = {super.cut, super.color, super.perm, super.shampoo, super.massage};
		for(int i=0; i<service.length; i++) {
			total += menu[service[i]];
		}
	}

	@Override
	public String calculator() {
		String result = "";
		if (age <= 18) {
			result = name + "님의 계산서 : " + (int)(total * 0.9) + "원(10%할인)";	
		}else {
			result = name + "님의 계산서 : " + total + "원";
		}
		return result;
	}
}
