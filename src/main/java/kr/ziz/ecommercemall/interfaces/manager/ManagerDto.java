package kr.ziz.ecommercemall.interfaces.manager;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import kr.ziz.ecommercemall.domain.manager.ManagerCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ManagerDto {

  @Getter
  @Setter
  @ToString
  public static class JoinRequest {

    @NotEmpty(message = "managerId 는 필수값입니다")
    private String managerId;

    @NotEmpty(message = "managerNm 는 필수값입니다")
    private String managerNm;

    @NotEmpty(message = "managerPw 는 필수값입니다")
    private String managerPw;

    @NotEmpty(message = "phoneNo 는 필수값입니다")
    private String phoneNo;

    @Email(message = "email 형식에 맞아야 합니다")
    @NotEmpty(message = "email 는 필수값입니다")
    private String email;

    public ManagerCommand toCommand() {
      return ManagerCommand.builder()
              .managerId(managerId)
              .managerNm(managerNm)
              .managerPw(managerPw)
              .phoneNo(phoneNo)
              .email(email)
              .build();
    }
  }

  @Getter
  @Setter
  @ToString
  public static class LoginRequest {
    @NotEmpty(message = "managerId 는 필수값입니다")
    private String managerId;

    @NotEmpty(message = "managerPw 는 필수값입니다")
    private String managerPw;
  }

  @Getter
  @Setter
  @ToString
  public static class ChangePasswordRequest {
    @NotEmpty(message = "managerId 는 필수값입니다")
    private String managerId;

    @NotEmpty(message = "managerPw 는 필수값입니다")
    private String managerPw;

    @NotEmpty(message = "newPw 는 필수값입니다")
    private String newPw;
  }

  @Getter
  @Setter
  @ToString
  public static class ChangeInfoRequest {
    @NotEmpty(message = "managerId 는 필수값입니다")
    private String managerId;

    @NotEmpty(message = "managerPw 는 필수값입니다")
    private String managerPw;

    @NotEmpty(message = "managerMm 는 필수값입니다")
    private String managerMm;

    @NotEmpty(message = "phoneNo 는 필수값입니다")
    private String phoneNo;

    @Email(message = "email 형식에 맞아야 합니다")
    @NotEmpty(message = "email 는 필수값입니다")
    private String email;
  }

  @Getter
  @Setter
  @ToString
  public static class WithdrawalRequest {
    @NotEmpty(message = "managerId 는 필수값입니다")
    private String managerId;

    @NotEmpty(message = "managerPw 는 필수값입니다")
    private String managerPw;
  }
}
