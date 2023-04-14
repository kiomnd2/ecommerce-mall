package kr.ziz.ecommercemall.domain.partner.fixture;

import kr.ziz.ecommercemall.domain.common.Address;
import kr.ziz.ecommercemall.domain.partner.Partner;

public class PartnerFixture {
  public static Partner createPartner(String partnerPw) {
    return new Partner("partnerId", "partnerNm", partnerPw
            , "email", "N", "bizNo", new Address(), "");
  }
}
