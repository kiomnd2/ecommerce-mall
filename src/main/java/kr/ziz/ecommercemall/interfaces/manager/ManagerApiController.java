package kr.ziz.ecommercemall.interfaces.manager;

import jakarta.validation.Valid;
import kr.ziz.ecommercemall.application.manager.ManagerFacade;
import kr.ziz.ecommercemall.domain.manager.ManagerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerApiController {

  private final ManagerFacade managerFacade;

  // TODO 응답 공통 처리
  @PostMapping("/join")
  public ManagerInfo managerJoin(@RequestBody @Valid ManagerDto.JoinRequest request) {
   return managerFacade.registerManager(request.toCommand());
  }

  @PostMapping("/password")
  public ManagerInfo changeManagerPassword(@RequestBody @Valid ManagerDto.ChangePasswordRequest request) {
    return managerFacade.updateManagerForPassword(request);
  }

  @PostMapping("/info")
  public ManagerInfo changeManagerInfo(@RequestBody @Valid ManagerDto.ChangeInfoRequest request) {
    return managerFacade.updateManagerForInfo(request);
  }

  @DeleteMapping("/")
  public String deleteManager(@RequestBody @Valid ManagerDto.WithdrawalRequest request) {
    return "운영자 탈퇴";
  }
}
