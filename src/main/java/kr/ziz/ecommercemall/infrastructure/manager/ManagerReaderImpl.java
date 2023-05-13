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
  public Optional<Manager> getManager(String managerToken) {
    return managerRepository.findByManagerToken(managerToken);
  }

  @Transactional
  @Override
  public Optional<Manager> getManagerByEmail(String email) {
    return managerRepository.findByEmail(email);
  }
}
