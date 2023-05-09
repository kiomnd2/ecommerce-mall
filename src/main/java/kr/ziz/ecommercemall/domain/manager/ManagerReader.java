package kr.ziz.ecommercemall.domain.manager;

import java.util.Optional;

public interface ManagerReader {

  Optional<Manager> getManager(Long id);

  Optional<Manager> getManager(String managerId);
}
