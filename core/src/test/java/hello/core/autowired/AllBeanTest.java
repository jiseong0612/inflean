package hello.core.autowired;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import hello.core.AutoAppConfig;
import hello.core.discount.Discountpolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

public class AllBeanTest {
	@Test
	void findAllBean() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class ,DiscountService.class);
		DiscountService discountService =  ac.getBean(DiscountService.class);
		Member member = new Member(1L, "userA", Grade.VIP);
		int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
		Assertions.assertThat(discountPrice).isEqualTo(1000);
	}
	
	static class DiscountService{
		private final Map<String, Discountpolicy> policyMap;
		private final List<Discountpolicy> policies;
		
		public DiscountService(Map<String, Discountpolicy> policyMap, List<Discountpolicy> policies) {
			this.policyMap = policyMap;
			this.policies = policies;
			
			System.out.println("policyMap >>> "+policyMap);
			System.out.println("policies >>> "+policies);
		}

		public int discount(Member member, int price, String discountCode) {
			Discountpolicy discountpolicy = policyMap.get(discountCode);
			return discountpolicy.discount(member, price);
		}
	}
}
