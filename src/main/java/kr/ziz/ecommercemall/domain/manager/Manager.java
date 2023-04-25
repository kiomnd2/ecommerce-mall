package kr.ziz.ecommercemall.domain.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manager {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String managerId;
  private String managerNm;
  private String managerPw;
  private String email;

  private String phoneNo;

  private final String UPPERCASE_REG_EXP = "^((.*)[A-Z](.*))";
  private final String LOWERCASE_REG_EXP = "^((.*)[a-z](.*))";
  private final String NUMBER_REG_EXP = "^((.*)\\d(.*))";
  private final String SPECIAL_SYMBOLS_REG_EXP = "((.*)[!@#$%^&*()](.*))";
  private final String EMAIL_REG_EXP = "ott-mall.com";

  public Manager(String managerId, String managerNm, String managerPw, String email, String phoneNo) {
    verifyPassword(managerPw);
    verifyEmail(email);
    this.managerId = managerId;
    this.managerNm = managerNm;
    this.managerPw = managerPw;
    this.email = email;
    this.phoneNo = phoneNo;
  }

  /**
   * 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열
   */
  private void verifyPassword(String password) {
    if (StringUtils.hasLength(password) && password.length() < 12) throw new RuntimeException("길이 12자 이상");

    int appliedRegExpCnt = 0;
    if(Pattern.matches(UPPERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(LOWERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(NUMBER_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(SPECIAL_SYMBOLS_REG_EXP, password)) appliedRegExpCnt++;

    if( appliedRegExpCnt < 3 ) throw new RuntimeException("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상");
  }

  private void verifyEmail(String email) {
    if(!Pattern.matches(EMAIL_REG_EXP, email)) throw new RuntimeException("사내 메일만 가능");
  }
}
