package kr.ziz.ecommercemall.domain.manager;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ManagerCommand {

  private String email;
  private String managerNm;
  private String managerPw;
  private String phoneNo;

  public Manager toEntity() {
    return Manager.builder()
            .email(email)
            .managerNm(managerNm)
            .managerPw(managerPw)
            .phoneNo(phoneNo)
            .build();
  }
}
