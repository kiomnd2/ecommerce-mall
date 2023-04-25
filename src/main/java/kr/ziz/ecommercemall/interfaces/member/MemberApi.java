package kr.ziz.ecommercemall.interfaces.member;

import kr.ziz.ecommercemall.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApi {

    @PostMapping("/join")
    public CommonResponse join(@RequestBody MemberDto.RequestJoin requestJoin) {
        return CommonResponse.success("memberToken");
    }

    @PostMapping("/logged-in")
    public CommonResponse login(@RequestBody MemberDto.RequestLogin requestLogin) {
        return CommonResponse.success("memberToken");
    }

    @PutMapping
    public CommonResponse update(@RequestBody MemberDto.RequestUpdate requestUpdate) {
        return CommonResponse.success("수정완료");
    }

    @DeleteMapping
    public CommonResponse delete(@RequestBody MemberDto.RequestDelete requestDelete) {
        return CommonResponse.success("");
    }

    @GetMapping("/otp/{email}")
    public CommonResponse issueOtp(@PathVariable("email") String email) {
        return CommonResponse.success("인증키 발급 되었습니다.");
    }

    @PostMapping("/otp")
    public CommonResponse checkOtp() {
        return CommonResponse.success("토큰 인증 되었습니다.");
    }

}
