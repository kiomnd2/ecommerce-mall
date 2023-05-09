package kr.ziz.ecommercemall.interfaces.manager;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerApiController {

  @PostMapping("/join")
  public String managerJoin(@RequestBody @Valid ManagerDto.JoinRequest request) {
    return "운영자 회원가입";
  }

  @PostMapping("/password")
  public String changeManagerPassword(@RequestBody @Valid ManagerDto.LoginRequest request) {
    return "운영자 비밀번호 수정";
  }

  @PostMapping("/info")
  public String changeManagerInfo(@RequestBody @Valid ManagerDto.ChangePasswordRequest request) {
    return "운영자 정보 수장";
  }

  @DeleteMapping("/")
  public String deleteManager(@RequestBody @Valid ManagerDto.WithdrawalRequest request) {
    return "운영자 탈퇴";
  }
}
