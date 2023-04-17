package kr.ziz.ecommercemall.domain.manager;

import kr.ziz.ecommercemall.domain.manager.fixture.ManagerFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {

  @Test
  public void length_less_than_12() {
    Exception exception = assertThrows(RuntimeException.class,
            () -> ManagerFixture.createManager("12345678901"));

    String expectedMessage = "길이 12자 이상";

    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  @DisplayName("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열")
  @Test
  public void validation_password() {
    Exception exception1 = assertThrows(RuntimeException.class,
            () -> ManagerFixture.createManager("AA3456789012"));

    Exception exception2 = assertThrows(RuntimeException.class,
            () -> ManagerFixture.createManager("aa3456789012"));

    Exception exception3 = assertThrows(RuntimeException.class,
            () -> ManagerFixture.createManager("##3456789012"));

    String expectedMessage = "영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상";

    Manager manager = ManagerFixture.createManager("##AA56789012");

    assertTrue(exception1.getMessage().contains(expectedMessage));
    assertTrue(exception2.getMessage().contains(expectedMessage));
    assertTrue(exception3.getMessage().contains(expectedMessage));
    assertThat(manager.getMemberPw()).isEqualTo("##AA56789012");
  }
}