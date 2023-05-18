package kr.ziz.ecommercemall.infrastructure.member;

import kr.ziz.ecommercemall.domain.member.otp.OtpInfo;
import kr.ziz.ecommercemall.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailNotificationExecutor implements NotificationService {


    @Override
    public void sendEmail(OtpInfo info) {
        log.info(info.getMemberToken());
        log.info(info.getOtp());
    }
}
