package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
