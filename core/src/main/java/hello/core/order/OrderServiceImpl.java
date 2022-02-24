package hello.core.order;

import org.springframework.stereotype.Component;

import hello.core.discount.Discountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final Discountpolicy discountPolicy;

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
