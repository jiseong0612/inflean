package hello.core.member;

public class MemberServiceImpl implements MemberService{
	  private final MemberRepository repository = new MemoryMemberRepository();
	
	@Override
	public void join(Member member) {
		repository.save(member);
	}

	@Override
	public Member findMeber(Long memberId) {
		return repository.findById(memberId);
	}

}
