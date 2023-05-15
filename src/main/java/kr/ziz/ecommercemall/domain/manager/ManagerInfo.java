package kr.ziz.ecommercemall.domain.manager;

import lombok.Getter;

@Getter
public class ManagerInfo {

  private String managerToken;
  private String managerNm;
  private String managerPw;
  private String email;
  private String phoneNo;

  public ManagerInfo(Manager manager) {
    this.managerToken = manager.getManagerToken();
    this.managerNm = manager.getManagerNm();
    this.managerPw = manager.getManagerPw();
    this.email = manager.getEmail();
    this.phoneNo = manager.getPhoneNo();
  }
}
