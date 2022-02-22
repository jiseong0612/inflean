package hello.core.order;

import hello.core.discount.Discountpolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final Discountpolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member findMember = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(findMember, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}