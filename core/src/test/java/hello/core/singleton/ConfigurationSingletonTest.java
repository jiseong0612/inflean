package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	@Test
	public void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//하위 자손의 클래스 명으로도 검색 가능
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		
		MemberRepository memberRepo = memberService.getMemberRepository();
		MemberRepository orderRepo = memberService.getMemberRepository();
		MemberRepository memberRepository = ac.getBean(MemberRepository.class);	 //본체
		
		//AppConfig.class 에선 분명 각각 new 해서 MemberRepository를 가져오는건데 같은 객체임을 확인할 수 있다.
		System.out.println(memberRepo);
		System.out.println(orderRepo);
		System.out.println(memberRepository);
		Assertions.assertThat(memberRepo).isSameAs(orderRepo);
		
		//세 놈다 같다.
	}
	
	@Test
	public void AppConfigTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		AppConfig bean = ac.getBean(AppConfig.class);
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		
		
		System.out.println("AppConfig 클래스 네임 : "+ bean.getClass()); // class hello.core.AppConfig$$EnhancerBySpringCGLIB$$989baddf
		System.out.println("memberService 클래스 네임 : "+ memberService.getClass()); // class hello.core.member.MemberServiceImpl
	}
}
