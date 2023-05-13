package kr.ziz.ecommercemall.common.exception;

import static kr.ziz.ecommercemall.common.response.ErrorCode.PASSWORD_INVALIDATION;

public class PasswordValidationException extends BaseException {

  public PasswordValidationException() {
    super(PASSWORD_INVALIDATION, null);
  }
}
