package kr.ziz.ecommercemall.domain.member;

import kr.ziz.ecommercemall.domain.member.otp.OtpInfo;

public interface MemberService {
    MemberInfo registerMember(MemberCommand.RegisterMember memberCommand);
    MemberInfo modifyMember(String memberToken, MemberCommand.ModifyMember memberCommand);
    void deleteMember(String memberToken);
    OtpInfo issueOtp(String memberToken);
}
