package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

  Optional<Manager> findByManagerToken(String managerToken);

  Optional<Manager> findByEmail(String email);
}
