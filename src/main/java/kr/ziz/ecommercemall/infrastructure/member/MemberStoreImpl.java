package kr.ziz.ecommercemall.infrastructure.member;

import kr.ziz.ecommercemall.domain.member.Member;
import kr.ziz.ecommercemall.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public Member store(Member member) {
        return memberRepository.save(member);
    }

}
