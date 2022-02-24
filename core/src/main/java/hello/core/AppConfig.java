package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.Discountpolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
//	private int number = 0;
//	@Bean
//	public MemberService memberService() {
//		number ++;
//		System.out.println("call memberService");
//		System.out.println(number);
//		return new MemberServiceImpl(memberRepository());
//	}
//
//	@Bean
//	public MemberRepository memberRepository() {
//		number ++;
//		System.out.println("call memberRepository");
//		System.out.println(number);
//		return new MemoryMemberRepository();
//	}
//
//	@Bean
//	public OrderService orderService() {
//		number ++;
//		System.out.println("call orderService");
//		System.out.println(number);
//		return new OrderServiceImpl(memberRepository(), discountpolicy());
//	}
//
//	@Bean
//	public Discountpolicy discountpolicy() {
//		return new RateDiscountPolicy();
//	}
}
