package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import kr.ziz.ecommercemall.domain.manager.ManagerInfo;
import kr.ziz.ecommercemall.domain.manager.ManagerReader;
import kr.ziz.ecommercemall.domain.manager.ManagerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ManagerStoreImpl implements ManagerStore {

  private final ManagerRepository managerRepository;
  private final ManagerReader managerReader;

  @Override
  public ManagerInfo store(Manager initManager) {
    String email = initManager.getEmail();
    managerReader.getManagerByEmail(email).orElseThrow(() -> new RuntimeException("이미 가입된 운영자 이메일입니다. " + email));
    Manager manager = managerRepository.save(initManager);
    return new ManagerInfo(manager);
  }
}
