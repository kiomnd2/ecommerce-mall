package kr.ziz.ecommercemall.domain.member;

import jakarta.persistence.*;
import kr.ziz.ecommercemall.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "otps")
public class Otp {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberToken;
    private String otp;
    private LocalDateTime expiredAt;
    private OtpStatus status;

    public enum OtpStatus {
        ISSUE, EXPIRED
    }

    @Builder
    public Otp(String memberToken) {
        if (!StringUtils.hasLength(memberToken)) throw new RuntimeException("managerNm는 필수값입니다.");
        this.memberToken = memberToken;
        this.otp = TokenGenerator.randomCharacter(6);
        this.expiredAt = LocalDateTime.now().plusHours(1); // 한시간 뒤 만료
        this.status = OtpStatus.ISSUE;
    }
}
