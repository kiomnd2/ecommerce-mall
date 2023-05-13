package kr.ziz.ecommercemall.domain.manager;

import kr.ziz.ecommercemall.common.exception.NotExistsException;
import kr.ziz.ecommercemall.common.exception.PasswordNotMatchException;

public final class ManagerServiceHelper {

  /**
   * 토큰값과 패스워드를 통해 본인 확인을 처리하는 헬퍼 메서드
   * @param reader
   * @param managerToken
   * @param managerPw
   * @return
   */
  public static Manager checkPassword(ManagerReader reader,String managerToken, String managerPw) {
    Manager findManager = reader.getManager(managerToken).orElseThrow(() -> new NotExistsException("운영자"));
    if (findManager.getManagerPw().equals(managerPw)) {
      throw new PasswordNotMatchException();
    }
    return findManager;
  }
}
