package kr.ziz.ecommercemall.common.exception;

import kr.ziz.ecommercemall.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private ErrorCode errorCode;

    public BaseException() {}


    public BaseException(ErrorCode errorCode, Object ... args) {
        super(errorCode.getMessage(args));
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BaseException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }
}
