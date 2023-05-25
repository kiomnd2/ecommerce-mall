package kr.ziz.ecommercemall.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse <T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>(Result.SUCCESS, data, message, null);
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode, T data) {
        return new CommonResponse<>(Result.FAIL, data, errorCode.getMessage(), errorCode.name());
    }

    public static <T> CommonResponse<T> fail(ErrorCode errorCode) {
        return fail(errorCode, null);
    }

    public enum Result {
        SUCCESS, FAIL
    }
}
