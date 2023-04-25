package kr.ziz.ecommercemall.domain.manager;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ManagerCommand {

  private String managerId;
  private String managerNm;
  private String managerPw;
  private String phoneNo;
  private String email;
}
