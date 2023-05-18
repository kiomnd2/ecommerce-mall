package kr.ziz.ecommercemall.domain.member.otp;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class OtpInfo {

    private final String memberToken;
    private final String otp;
    private final LocalDateTime expiredAt;
    private final Otp.OtpStatus status;

    @Builder
    public OtpInfo(Otp otp) {
        this.memberToken = otp.getMemberToken();
        this.otp = otp.getMemberToken();
        this.expiredAt = otp.getExpiredAt();
        this.status = otp.getStatus();
    }
}
