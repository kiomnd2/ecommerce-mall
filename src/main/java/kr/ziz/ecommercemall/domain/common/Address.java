package kr.ziz.ecommercemall.domain.common;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;


@Embeddable
@RequiredArgsConstructor
public class Address {

  private String zipCode;
  private String address1;
  private String address2;

  public Address(String zipCode, String address1, String address2) {
    if (StringUtils.isBlank(zipCode) || StringUtils.isBlank(address1)) {
      // TODO 예외 추상화 처리
      throw new RuntimeException("필수값 누락.");
    }
    this.zipCode = zipCode;
    this.address1 = address1;
    this.address2 = address2;
  }
}
