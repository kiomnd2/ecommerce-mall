package kr.ziz.ecommercemall.interfaces.member;

import kr.ziz.ecommercemall.application.member.MemberFacade;
import kr.ziz.ecommercemall.common.response.CommonResponse;
import kr.ziz.ecommercemall.domain.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApiController {
    private final MemberFacade memberFacade;

    @PostMapping("/join")
    public CommonResponse<MemberDto.ResponseToken> join(@RequestBody MemberDto.RequestJoin requestJoin) {
        MemberInfo memberInfo = memberFacade.registerMember(MemberMapper.INSTANCE.of(requestJoin));
        return CommonResponse.success(new MemberDto.ResponseToken(memberInfo.getMemberToken()));
    }

    @PostMapping("/logged-in")
    public CommonResponse<MemberDto.ResponseToken> login(@RequestBody MemberDto.RequestLogin requestLogin) {
        MemberInfo memberInfo = memberFacade.loginMember(MemberMapper.INSTANCE.of(requestLogin));
        return CommonResponse.success(new MemberDto.ResponseToken(memberInfo.getMemberToken()));
    }

    @PutMapping
    public CommonResponse<MemberDto.ResponseToken> update(@RequestBody MemberDto.RequestUpdate requestUpdate) {
        MemberInfo memberInfo = memberFacade.updateMember(requestUpdate.getMemberToken(),
                MemberMapper.INSTANCE.of(requestUpdate));
        return CommonResponse.success(new MemberDto.ResponseToken(memberInfo.getMemberToken()));
    }

    @DeleteMapping
    public CommonResponse<String> delete(@RequestBody MemberDto.RequestToken requestDelete) {
        memberFacade.deleteMember(requestDelete.getMemberToken());
        return CommonResponse.success("삭제되었습니다.");
    }

    @PostMapping("/otp")
    public CommonResponse<String> issueOtp(@RequestBody MemberDto.RequestToken requestToken) {
        memberFacade.issueOtp(requestToken.getMemberToken());
        return CommonResponse.success("인증키 발급 되었습니다.");
    }

    @PostMapping("/otp/check")
    public CommonResponse<String> checkOtp(@RequestBody MemberDto.RequestCheckOtp requestCheckOtp) {
        return CommonResponse.success("토큰 인증 되었습니다.");
    }

}
