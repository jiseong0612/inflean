package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {
	@Test
	@DisplayName("스프링 없는 순수 DI 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		
		//MemberService memberService1 = appConfig.memberService();
		//MemberService memberService2 = appConfig.memberService();
		
//		System.out.println(memberService1);
//		System.out.println(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 적용")
	public void singletonTest() {
		SingletonService service1 =  SingletonService.getInstance();
		SingletonService service2 =  SingletonService.getInstance();
		System.out.println(service1);
		System.out.println(service2);
		Assertions.assertThat(service1).isSameAs(service2);
		
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	public void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService mc = ac.getBean("memberService", MemberService.class);
		MemberService mc2 = ac.getBean("memberService", MemberService.class);
		System.out.println("mc : "+mc);
		System.out.println("mc2 : "+mc2);
		Assertions.assertThat(mc).isSameAs(mc2);
	}
}
