package kr.ziz.ecommercemall.domain.notification;

import kr.ziz.ecommercemall.domain.member.otp.OtpInfo;

public interface NotificationService {
    void sendEmail(OtpInfo info);
}
