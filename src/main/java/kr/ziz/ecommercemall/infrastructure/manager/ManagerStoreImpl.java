package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import kr.ziz.ecommercemall.domain.manager.ManagerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ManagerStoreImpl implements ManagerStore {

  private final ManagerRepository managerRepository;

  @Override
  public void store(Manager initManager) {
    managerRepository.save(initManager);
  }
}
