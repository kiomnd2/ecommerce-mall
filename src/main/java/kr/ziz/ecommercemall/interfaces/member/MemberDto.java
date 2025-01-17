package kr.ziz.ecommercemall.interfaces.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    public static class ResponseToken {
        private String memberToken;

        public ResponseToken(String memberToken) {
            this.memberToken = memberToken;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class RequestToken {
        private String memberToken;
    }

    @Getter
    @Setter
    @ToString
    public static class RequestJoin {
        private String memberNm;
        private String memberPw;
        private String cfmMemberPw;
        private String email;
    }

    @Getter
    @Setter
    @ToString
    public static class RequestLogin {
        private String email;
        private String memberPw;
    }

    @Getter
    @Setter
    @ToString
    public static class RequestUpdate {
        private String memberToken;
        private String memberPw;
    }


    @Getter
    @Setter
    @ToString
    public static class RequestCheckOtp {
        private String memberToken;
        private String otp;
    }
}
