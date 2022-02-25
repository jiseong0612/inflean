package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.core.discount.Discountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final Discountpolicy discountPolicy;

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("FixDiscountPolicy") Discountpolicy rateDiscountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = rateDiscountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member findMember = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(findMember, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	// 테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
