package kr.ziz.ecommercemall.domain.manager;

import jakarta.persistence.*;
import kr.ziz.ecommercemall.common.exception.EmailValidationException;
import kr.ziz.ecommercemall.common.exception.PasswordValidationException;
import kr.ziz.ecommercemall.common.exception.RequiredValueException;
import kr.ziz.ecommercemall.common.response.ErrorCode;
import kr.ziz.ecommercemall.domain.BaseEntity;
import kr.ziz.ecommercemall.common.util.TokenGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

import static kr.ziz.ecommercemall.common.response.ErrorCode.MANAGER_EMAIL_INVALIDATION;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manager extends BaseEntity {

  private static final String PREFIX_MANAGER = "MANAGER_";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String managerToken;
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
    if (!StringUtils.hasLength(managerNm)) throw new RequiredValueException("이름");
    if (!StringUtils.hasLength(phoneNo)) throw new RequiredValueException("휴대폰");
    verifyPassword(managerPw);
    verifyEmail(email);
    this.managerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_MANAGER);
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
    if (!StringUtils.hasLength(password) && password.length() < 12) throw new PasswordValidationException();

    int appliedRegExpCnt = 0;
    if(Pattern.matches(UPPERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(LOWERCASE_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(NUMBER_REG_EXP, password)) appliedRegExpCnt++;
    if(Pattern.matches(SPECIAL_SYMBOLS_REG_EXP, password)) appliedRegExpCnt++;
    if( appliedRegExpCnt < 3 ) throw new PasswordValidationException();
  }

  /**
   * 사내 메일만 로그인이 가능 @ott-mall.com
   * @param email
   */
  private void verifyEmail(String email) {
    if (!StringUtils.hasLength(email)) throw new RequiredValueException("이메일");
    boolean anyMatch = Arrays.stream(EMAIL_REG_EXP.split(",")).anyMatch(regExp -> email.lastIndexOf(regExp) > 0);
    if(!anyMatch) throw new EmailValidationException(MANAGER_EMAIL_INVALIDATION);
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
