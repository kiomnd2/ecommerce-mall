package kr.ziz.ecommercemall.common.exception;

import static kr.ziz.ecommercemall.common.response.ErrorCode.PASSWORD_NOT_MATCH;

public class PasswordNotMatchException extends BaseException {

  public PasswordNotMatchException() {
    super(PASSWORD_NOT_MATCH, null);
  }
}
