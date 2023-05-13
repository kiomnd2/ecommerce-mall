package kr.ziz.ecommercemall.interfaces.manager;

import jakarta.validation.Valid;
import kr.ziz.ecommercemall.application.manager.ManagerFacade;
import kr.ziz.ecommercemall.common.response.CommonResponse;
import kr.ziz.ecommercemall.domain.manager.ManagerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerApiController {

  private final ManagerFacade managerFacade;

  private final ManagerDtoMapper managerDtoMapper;

  @PostMapping("/join")
  public CommonResponse<ManagerDto.TokenResponse> managerJoin(@RequestBody @Valid ManagerDto.JoinRequest request) {
    ManagerInfo managerInfo = managerFacade.registerManager(request.toCommand());
    ManagerDto.TokenResponse response = managerDtoMapper.of(managerInfo.getManagerToken());
    return CommonResponse.success(response);
  }

  @PostMapping("/password")
  public CommonResponse<ManagerDto.TokenResponse> changeManagerPassword(@RequestBody @Valid ManagerDto.ChangePasswordRequest request) {
    ManagerInfo managerInfo = managerFacade.updateManagerForPassword(request);
    ManagerDto.TokenResponse response = managerDtoMapper.of(managerInfo.getManagerToken());
    return CommonResponse.success(response);
  }

  @PostMapping("/info")
  public CommonResponse<ManagerDto.TokenResponse> changeManagerInfo(@RequestBody @Valid ManagerDto.ChangeInfoRequest request) {
    ManagerInfo managerInfo = managerFacade.updateManagerForInfo(request);
    ManagerDto.TokenResponse response = managerDtoMapper.of(managerInfo.getManagerToken());
    return CommonResponse.success(response);
  }

  @DeleteMapping("/")
  public CommonResponse<ManagerDto.TokenResponse> deleteManager(@RequestBody @Valid ManagerDto.WithdrawalRequest request) {
    managerFacade.deleteManager(request);
    ManagerDto.TokenResponse response = managerDtoMapper.of(request.getManagerToken());
    return CommonResponse.success(response);
  }
}
