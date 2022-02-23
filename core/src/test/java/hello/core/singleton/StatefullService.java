package hello.core.singleton;

public class StatefullService {
	private int price;	// 상태를 유지하는 필드
	
	public void order(String name, int price) {
		System.out.println("name : "+name + " price : "+price);
		this.price = price;	// 여기가 문제
	}
	
	// ==> stateless 한 코드
	public int orderFix(String name, int price) {
		System.out.println("name : "+name + " price : "+price);
		return price;
	}
	
	public int getPrice() {
		return price;
	}
}
