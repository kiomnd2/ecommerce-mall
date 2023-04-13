package kr.ziz.ecommercemall.interfaces.partner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partner")
public class PartnerApi {

  @PostMapping("/join")
  public String join() {
    return "파트너 회원가입";
  }
}
