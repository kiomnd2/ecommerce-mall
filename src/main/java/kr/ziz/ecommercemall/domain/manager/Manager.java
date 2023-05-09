package kr.ziz.ecommercemall.domain.manager;

import jakarta.persistence.*;
import kr.ziz.ecommercemall.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manager extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String managerId;
  private String managerNm;
  private String managerPw;
  private String email;

  private String phoneNo;

  @Enumerated(EnumType.STRING)
  private ManagerStatus status;

  private final String UPPERCASE_REG_EXP = "^((.*)[A-Z](.*))";
  private final String LOWERCASE_REG_EXP = "^((.*)[a-z](.*))";
  private final String NUMBER_REG_EXP = "^((.*)\\d(.*))";
  private final String SPECIAL_SYMBOLS_REG_EXP = "((.*)[!@#$%^&*()](.*))";
  private final String EMAIL_REG_EXP = "@ott-mall.com";

  @Builder
  public Manager(String managerId, String managerNm, String managerPw, String email, String phoneNo) {
    if (!StringUtils.hasLength(managerId)) throw new RuntimeException("managerId는 필수값입니다.");
    if (!StringUtils.hasLength(managerNm)) throw new RuntimeException("managerNm는 필수값입니다.");
    if (!StringUtils.hasLength(phoneNo)) throw new RuntimeException("phoneNo는 필수값입니다.");
    verifyPassword(managerPw);
    verifyEmail(email);
    this.managerId = managerId;
    this.managerNm = managerNm;
    this.managerPw = managerPw;
    this.email = email;
    this.phoneNo = phoneNo;
    this.status = ManagerStatus.JOIN;
  }

  /**
   * 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열
   */
  private void verifyPassword(String password) {
    if (!StringUtils.hasLength(password) && password.length() < 12) throw new RuntimeException("길이 12자 이상");

    int appliedRegExpCnt = 0;
    if(Pattern.matches(UPPERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(LOWERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(NUMBER_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(SPECIAL_SYMBOLS_REG_EXP, password)) appliedRegExpCnt++;
    if( appliedRegExpCnt < 3 ) throw new RuntimeException("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상");
  }

  /**
   * 사내 메일만 로그인이 가능 @ott-mall.com
   * @param email
   */
  private void verifyEmail(String email) {
    if (!StringUtils.hasLength(email)) throw new RuntimeException("email는 필수값입니다.");
    boolean anyMatch = Arrays.stream(EMAIL_REG_EXP.split(",")).anyMatch(regExp -> email.lastIndexOf(regExp) > 0);
    if(!anyMatch) throw new RuntimeException("사내 이메일만 가능");
  }

  public void changePassword(String password) {
    verifyPassword(password);
    this.managerPw = password;
  }

  public void changeEmail(String email) {
    verifyEmail(email);
    this.email = email;
  }

  public void changeName(String name) {
    this.managerNm = name;
  }

  public void changePhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public void deleteManager() {
    this.status = ManagerStatus.WITHDRAWAL;
  }
}
