package kr.ziz.ecommercemall.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시후 다시 시도해 주세요."),
    PASSWORD_INVALIDATION("패스워드는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상을 사용하고 12자 보다 커야 합니다."),
    PASSWORD_NOT_MATCH("패스워드가 일지하지 않습니다."),
    MANAGER_EMAIL_INVALIDATION("사내메일 형식만 가능합니다."),
    NOT_EXISTS("존재하지 않은 %s 입니다."),
    REQUIRED_VALUE("%s(은)는 필수값입니다.");
    
    private final String message;

    public String getMessage(Object ... args) {
        return String.format(message, args);
    }
}
