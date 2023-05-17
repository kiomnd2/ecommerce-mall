package kr.ziz.ecommercemall.infrastructure.member.otp;

import kr.ziz.ecommercemall.domain.member.otp.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
}
