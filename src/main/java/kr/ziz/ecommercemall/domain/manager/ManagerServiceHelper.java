package kr.ziz.ecommercemall.domain.manager;

import java.util.Optional;

public final class ManagerServiceHelper {
  public static void checkDuplicateManagerId(ManagerReader reader, String managerId) {
    Optional<Manager> optional = reader.getManager(managerId);
    if (optional.isPresent()) {
      // TODO
      throw new RuntimeException("이미 가입된 운영자 아이디입니다. " +  managerId);
    }
  }
}
