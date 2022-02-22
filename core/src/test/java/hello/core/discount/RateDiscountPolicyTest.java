package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다.")
	public void vip_o() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		//when
		int discountPrice = discountPolicy.discount(member, 50000);
		//then
		Assertions.assertThat(discountPrice).isEqualTo(5000);
	}
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다.")
	public void vip_x() {
		//given
		Member member = new Member(1L, "memberA", Grade.BASIC);
		//when
		int discountPrice = discountPolicy.discount(member, 50000);
		//then
		Assertions.assertThat(discountPrice).isEqualTo(5000);
	}
}
