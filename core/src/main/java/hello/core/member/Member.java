package hello.core.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
	private Long id;
	private String name;
	private Grade grade;
	
	public static void main(String[] args) {
		Member member = new Member(1L, "userA", Grade.VIP);
		System.out.println(member);
	}
}
