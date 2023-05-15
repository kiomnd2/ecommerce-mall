package kr.ziz.ecommercemall.domain.manager;


import kr.ziz.ecommercemall.interfaces.manager.ManagerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ManagerServiceImpl implements ManagerService {

  private final ManagerStore managerStore;
  private final ManagerReader managerReader;

  @Transactional
  @Override
  public ManagerInfo registerManager(ManagerCommand command) {
    return managerStore.store(command.toEntity());
  }

  @Transactional
  @Override
  public ManagerInfo changePassword(ManagerDto.ChangePasswordRequest request) {
    Manager findManager = ManagerServiceHelper.checkPassword(managerReader, request.getManagerToken(), request.getManagerPw());
    findManager.changePassword(request.getNewPw());
    return new ManagerInfo(findManager);
  }

  @Transactional
  @Override
  public ManagerInfo changeInfo(ManagerDto.ChangeInfoRequest request) {
    Manager findManager = ManagerServiceHelper.checkPassword(managerReader, request.getManagerToken(), request.getManagerPw());
    changeInfo(request, findManager);
    return new ManagerInfo(findManager);
  }

  @Transactional
  @Override
  public void deleteManager(ManagerDto.WithdrawalRequest request) {
    Manager findManager = ManagerServiceHelper.checkPassword(managerReader, request.getManagerToken(), request.getManagerPw());
    findManager.deleteManager();
  }

  private void changeInfo(ManagerDto.ChangeInfoRequest request, Manager findManager) {
    findManager.changeName(request.getManagerMm());
    findManager.changePhoneNo(request.getPhoneNo());
  }
}
