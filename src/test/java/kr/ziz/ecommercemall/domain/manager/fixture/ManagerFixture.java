package kr.ziz.ecommercemall.domain.manager.fixture;

import kr.ziz.ecommercemall.domain.manager.Manager;

public class ManagerFixture {

  public static Manager createManager() {
    return new Manager("managerId", "managerNm", "##AA56789012"
            , "email@ott-mall.com", "01012345678");
  }

  public static Manager createManagerWithPassword(String managerPw) {
    return new Manager("managerId", "managerNm", managerPw
            , "email@ott-mall.com", "01012345678");
  }

  public static Manager createManagerWithEmail(String email) {
    return new Manager("managerId", "managerNm", "##AA56789012"
            , email, "01012345678");
  }
}
