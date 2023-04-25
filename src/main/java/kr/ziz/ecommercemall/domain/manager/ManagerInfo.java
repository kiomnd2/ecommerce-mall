package kr.ziz.ecommercemall.domain.manager;

public class ManagerInfo {

  private Long id;
  private String managerId;
  private String managerNm;
  private String managerPw;
  private String email;
  private String phoneNo;

  public ManagerInfo(Manager manager) {
    this.id = manager.getId();
    this.managerId = manager.getManagerId();
    this.managerNm = manager.getManagerNm();
    this.managerPw = manager.getManagerPw();
    this.email = manager.getEmail();
    this.phoneNo = manager.getPhoneNo();
  }
}
