package kr.ziz.ecommercemall.application.member;

import kr.ziz.ecommercemall.domain.member.MemberCommand;
import kr.ziz.ecommercemall.domain.member.MemberInfo;
import kr.ziz.ecommercemall.domain.member.MemberService;
import kr.ziz.ecommercemall.domain.member.otp.OtpInfo;
import kr.ziz.ecommercemall.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFacade {
    private final MemberService memberService;
    private final NotificationService notificationService;

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
        OtpInfo otp = memberService.issueOtp(memberToken);
        notificationService.sendEmail(otp);
    }
}
