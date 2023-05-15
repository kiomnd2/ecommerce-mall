package kr.ziz.ecommercemall.common.exception;

import kr.ziz.ecommercemall.common.response.ErrorCode;

public class EmailValidationException extends BaseException {

  public EmailValidationException(ErrorCode errorCode) {
    super(errorCode);
  }
}
