package kr.ziz.ecommercemall.common.exception;

import static kr.ziz.ecommercemall.common.response.ErrorCode.REQUIRED_VALUE;

public class RequiredValueException extends BaseException{

  public RequiredValueException(Object... args) {
    super(REQUIRED_VALUE, args);
  }
}
