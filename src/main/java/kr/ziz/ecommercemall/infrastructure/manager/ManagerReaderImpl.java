package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import kr.ziz.ecommercemall.domain.manager.ManagerReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ManagerReaderImpl implements ManagerReader {

  private final ManagerRepository managerRepository;

  @Transactional
  @Override
  public Optional<Manager> getManager(Long id) {
    return Optional.empty();
  }

  @Transactional
  @Override
  public Optional<Manager> getManager(String managerId) {
    return managerRepository.findByManagerId(managerId);
  }
}
