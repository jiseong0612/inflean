package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;
@Component
@Qualifier("FixDiscountPolicy")
public class FixDiscountPolicy implements Discountpolicy {

	private int discountFixAmount = 1000; // 고정된 할인 금액

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}

}
