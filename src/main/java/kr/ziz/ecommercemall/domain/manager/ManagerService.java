package kr.ziz.ecommercemall.domain.manager;

import kr.ziz.ecommercemall.interfaces.manager.ManagerDto;

public interface ManagerService {

  ManagerInfo registerManager(ManagerCommand command);

  ManagerInfo changePassword(ManagerDto.ChangePasswordRequest request);

  ManagerInfo changeInfo(ManagerDto.ChangeInfoRequest request);

  void deleteManager(ManagerDto.WithdrawalRequest request);
}
