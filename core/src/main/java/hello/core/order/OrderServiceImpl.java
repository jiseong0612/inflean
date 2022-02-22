package hello.core.order;

import hello.core.discount.Discountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final Discountpolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, Discountpolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy  = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member findMember = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(findMember, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
