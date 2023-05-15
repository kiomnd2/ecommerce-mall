package kr.ziz.ecommercemall.domain.member;

public interface OtpStore {
    void store(String memberToken, String otp);
}
