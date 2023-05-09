package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.*;
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
    ManagerServiceHelper.checkDuplicateManagerId(managerReader, initManager.getManagerId());
    Manager manager = managerRepository.save(initManager);
    return new ManagerInfo(manager);
  }
}
