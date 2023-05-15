package kr.ziz.ecommercemall.domain.manager;

import java.util.Optional;

public interface ManagerReader {

  Optional<Manager> getManager(String managerToken);

  Optional<Manager> getManagerByEmail(String email);
}
