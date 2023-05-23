package kr.ziz.ecommercemall.domain.member;

import kr.ziz.ecommercemall.domain.member.otp.Otp;
import kr.ziz.ecommercemall.domain.member.otp.OtpInfo;
import kr.ziz.ecommercemall.domain.member.otp.OtpStore;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

//@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final OtpStore otpStore;

    @Override
    public MemberInfo login(MemberCommand.LoginMember loginCommand) {
        return new MemberInfo(memberReader.login(loginCommand.getEmail(), loginCommand.getMemberPw()));
    }

    @Transactional(readOnly = true)
    @Override
    public MemberInfo registerMember(MemberCommand.RegisterMember memberCommand) {
        return new MemberInfo(memberStore.store(memberCommand.toEntity()));
    }

    @Transactional
    @Override
    public MemberInfo modifyMember(String memberToken, MemberCommand.UpdateMember memberCommand) {
        Member member = memberReader.getMember(memberToken);
        member.changeMember(memberCommand);
        return new MemberInfo(member);
    }
    @Transactional
    @Override
    public void deleteMember(String memberToken) {
        Member member = memberReader.getMember(memberToken);
        member.deleteMember();
    }

    @Transactional
    @Override
    public OtpInfo issueOtp(String memberToken) {
        Otp store = otpStore.store(Otp.builder().memberToken(memberToken).build());
        return OtpInfo.builder().otp(store).build();
    }


}
