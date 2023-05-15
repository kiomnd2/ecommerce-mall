package kr.ziz.ecommercemall.domain.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

}
