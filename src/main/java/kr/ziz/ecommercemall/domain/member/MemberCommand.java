package kr.ziz.ecommercemall.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class MemberCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterMember {
        private final String memberNm;
        private final String memberPw;
        private final String phoneNo;
        private final String email;

        public Member toEntity() {
            return Member.builder()
                    .memberNm(memberNm)
                    .memberPw(memberPw)
                    .phoneNo(phoneNo)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class LoginMember {
        private final String email;
        private final String memberPw;
    }

    @Getter
    @Builder
    @ToString
    public static class UpdateMember {
        private final String memberNm;
        private final String memberPw;
        private final String phoneNo;

        public Member toEntity() {
            return Member.builder()
                    .memberNm(memberNm)
                    .memberPw(memberPw)
                    .phoneNo(phoneNo)
                    .build();
        }
    }
}
