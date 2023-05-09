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
    Manager findManager = getManager(request.getManagerId(), request.getManagerPw());
    findManager.changePassword(request.getNewPw());
    return new ManagerInfo(findManager);
  }

  @Transactional
  @Override
  public ManagerInfo changeInfo(ManagerDto.ChangeInfoRequest request) {
    Manager findManager = getManager(request.getManagerId(), request.getManagerPw());
    changeInfo(request, findManager);
    return new ManagerInfo(findManager);
  }

  @Transactional
  @Override
  public boolean deleteManager(ManagerDto.WithdrawalRequest request) {
    Manager findManager = getManager(request.getManagerId(), request.getManagerPw());
    findManager.deleteManager();
    return false;
  }

  private Manager getManager(String managerId, String managerPw) {
    Manager findManager = managerReader.getManager(managerId).orElseThrow(() -> new RuntimeException("잘못된 회원 정보 입니다."));
    if(!findManager.getManagerPw().equals(managerPw)) throw new RuntimeException("잘못된 회원 정보 입니다.");
    return findManager;
  }

  private void changeInfo(ManagerDto.ChangeInfoRequest request, Manager findManager) {
    findManager.changeEmail(request.getEmail());
    findManager.changeName(request.getManagerMm());
    findManager.changePhoneNo(request.getPhoneNo());
  }
}
