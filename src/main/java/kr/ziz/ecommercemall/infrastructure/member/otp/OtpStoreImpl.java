package kr.ziz.ecommercemall.infrastructure.member.otp;

import kr.ziz.ecommercemall.domain.member.OtpStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OtpStoreImpl implements OtpStore {
    private final OtpRepository otpRepository;

    @Override
    public void store(String memberToken, String otp) {

    }
}
