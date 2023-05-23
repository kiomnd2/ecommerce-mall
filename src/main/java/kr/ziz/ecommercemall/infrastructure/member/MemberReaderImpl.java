package kr.ziz.ecommercemall.infrastructure.member;

import kr.ziz.ecommercemall.common.exception.BaseException;
import kr.ziz.ecommercemall.common.response.ErrorCode;
import kr.ziz.ecommercemall.domain.member.Member;
import kr.ziz.ecommercemall.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;

    @Override
    public Member getMember(String memberToken) {
        return memberRepository.findMemberByMemberToken(memberToken).orElseThrow();
    }

    @Override
    public Member login(String email, String memberPw) {
        Optional<Member> m = memberRepository.findMemberByEmailAndMemberPw(email, memberPw);
        Member member = m.orElseThrow(() -> new BaseException(ErrorCode.NOT_EXISTS, "member"));
        member.checkStatus();
        return member;
    }
}
