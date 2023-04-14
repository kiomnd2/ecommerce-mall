package kr.ziz.ecommercemall.domain.common;

import jakarta.persistence.Embeddable;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Embeddable
@RequiredArgsConstructor
public class PhoneNumber {

  private String phone1;
  private String phone2;
  private String phone3;

  public PhoneNumber(String phone1, String phone2, String phone3) {
    if(StringUtils.isBlank(phone1) || StringUtils.isBlank(phone2) || StringUtils.isBlank(phone3)){
      throw new RuntimeException("필수 누락.");
    }
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.phone3 = phone3;
  }
}
