package kr.ziz.ecommercemall.infrastructure.member;

import kr.ziz.ecommercemall.common.exception.BaseException;
import kr.ziz.ecommercemall.domain.member.Member;
import kr.ziz.ecommercemall.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;

    @Override
    public Member getMember(String memberToken) {
        return memberRepository.findMemberByMemberToken(memberToken).orElseThrow();
    }
}
