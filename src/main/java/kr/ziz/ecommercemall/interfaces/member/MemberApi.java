package kr.ziz.ecommercemall.interfaces.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApi {

    @PostMapping("/join")
    public String join() {
        return "회원";
    }

    @PostMapping("/logged-in")
    public String login() {
        return "로그인";
    }
}
