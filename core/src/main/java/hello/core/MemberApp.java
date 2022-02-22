package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		//순수 자바
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		
		//스프링
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMeber(1L);
		System.out.println("new Memberr =  "+member.getName());
		System.out.println("find Memer =  "+ findMember.getName());
		
	}

}
