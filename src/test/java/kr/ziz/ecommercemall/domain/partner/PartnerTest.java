package kr.ziz.ecommercemall.domain.partner;

import kr.ziz.ecommercemall.domain.partner.fixture.PartnerFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartnerTest {

  @Test
  public void length_less_than_12() {
    Exception exception = assertThrows(RuntimeException.class,
            () -> PartnerFixture.createPartner("12345678901"));

    String expectedMessage = "길이 12자 이상";

    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  @DisplayName("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열")
  @Test
  public void validation_password() {
    Exception exception1 = assertThrows(RuntimeException.class,
            () -> PartnerFixture.createPartner("AA3456789012"));

    Exception exception2 = assertThrows(RuntimeException.class,
            () -> PartnerFixture.createPartner("aa3456789012"));

    Exception exception3 = assertThrows(RuntimeException.class,
            () -> PartnerFixture.createPartner("##3456789012"));

    String expectedMessage = "영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상";

    Partner partner = PartnerFixture.createPartner("##AA56789012");

    assertTrue(exception1.getMessage().contains(expectedMessage));
    assertTrue(exception2.getMessage().contains(expectedMessage));
    assertTrue(exception3.getMessage().contains(expectedMessage));
    assertThat(partner.getPartnerPw()).isEqualTo("##AA56789012");
  }
}