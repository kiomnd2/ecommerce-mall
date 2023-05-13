package kr.ziz.ecommercemall.common.exception;

import static kr.ziz.ecommercemall.common.response.ErrorCode.NOT_EXISTS;

public class NotExistsException extends BaseException{

  public NotExistsException(Object... args) {
    super(NOT_EXISTS, args);
  }
}
