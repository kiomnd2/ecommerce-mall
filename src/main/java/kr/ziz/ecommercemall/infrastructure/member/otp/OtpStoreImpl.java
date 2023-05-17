package kr.ziz.ecommercemall.infrastructure.member.otp;

import kr.ziz.ecommercemall.domain.member.otp.Otp;
import kr.ziz.ecommercemall.domain.member.otp.OtpStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OtpStoreImpl implements OtpStore {
    private final OtpRepository otpRepository;

    @Override
    public void store(Otp otp) {
        otpRepository.save(otp);
    }
}
