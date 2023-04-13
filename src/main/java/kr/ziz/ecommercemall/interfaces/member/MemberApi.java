package kr.ziz.ecommercemall.interfaces.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApi {

    @GetMapping("/join")
    public String join() {
        return "지장이재석";
    }
}
