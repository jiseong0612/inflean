package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		Member member = new Member(1L, "memberA", Grade.VIP);
		service.join(member);
		
		Member findMember = service.findMeber(1L);
		System.out.println("new Memberr =  "+member.getName());
		System.out.println("find Memer =  "+ findMember.getName());
	}

}
