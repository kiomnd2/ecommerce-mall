package kr.ziz.ecommercemall.domain.manager;

import kr.ziz.ecommercemall.common.exception.EmailValidationException;
import kr.ziz.ecommercemall.common.exception.PasswordValidationException;
import kr.ziz.ecommercemall.domain.manager.fixture.ManagerFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.ziz.ecommercemall.common.response.ErrorCode.MANAGER_EMAIL_INVALIDATION;
import static kr.ziz.ecommercemall.common.response.ErrorCode.PASSWORD_INVALIDATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManagerTest {

  @DisplayName("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열")
  @Test
  public void validation_password() {
    // 12자 미만 케이스
    assertThatThrownBy(() -> ManagerFixture.createManagerWithPassword("12345678901"))
            .isInstanceOf(PasswordValidationException.class)
            .hasMessage(PASSWORD_INVALIDATION.getMessage());

    // 12자 이상이지만 3종류 사용 안한 케이스
    assertThatThrownBy(() -> ManagerFixture.createManagerWithPassword("AA3456789012"))
            .isInstanceOf(PasswordValidationException.class)
            .hasMessage(PASSWORD_INVALIDATION.getMessage());

    assertThatThrownBy(() -> ManagerFixture.createManagerWithPassword("aa3456789012"))
            .isInstanceOf(PasswordValidationException.class)
            .hasMessage(PASSWORD_INVALIDATION.getMessage());

    assertThatThrownBy(() -> ManagerFixture.createManagerWithPassword("3456789012"))
            .isInstanceOf(PasswordValidationException.class)
            .hasMessage(PASSWORD_INVALIDATION.getMessage());

    // 정상 케이스
    Manager manager = ManagerFixture.createManagerWithPassword("##AA56789012");

    assertThat(manager.getManagerPw()).isEqualTo("##AA56789012");
  }

  @DisplayName("운영자의 아이디는 반드시 사내 메일을 사용")
  @Test
  public void validation_email() {

    assertThatThrownBy(() -> ManagerFixture.createManagerWithEmail("ottmall@gmail.com"))
            .isInstanceOf(EmailValidationException.class)
            .hasMessage(MANAGER_EMAIL_INVALIDATION.getMessage());

    String email = "ottmall@ott-mall.com";
    Manager manager = ManagerFixture.createManagerWithEmail(email);

    assertThat(manager.getEmail()).isEqualTo(email);
  }
}