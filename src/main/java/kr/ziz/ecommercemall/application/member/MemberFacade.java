package kr.ziz.ecommercemall.application.member;

import kr.ziz.ecommercemall.domain.member.MemberCommand;
import kr.ziz.ecommercemall.domain.member.MemberInfo;
import kr.ziz.ecommercemall.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFacade {
    private final MemberService memberService;

    public MemberInfo registerMember(MemberCommand.RegisterMember memberCommand) {
        return memberService.registerMember(memberCommand);
    }

    public MemberInfo modifyMember(String memberToken, MemberCommand.ModifyMember memberCommand) {
        return memberService.modifyMember(memberToken, memberCommand);
    }

    public void deleteMember(String memberToken) {
        memberService.deleteMember(memberToken);
    }

    public void issueOtp(String memberToken) {
        memberService.issueOtp(memberToken);
    }
}
