package kr.ziz.ecommercemall.domain.member.fixture;

import kr.ziz.ecommercemall.domain.member.Member;
import kr.ziz.ecommercemall.interfaces.member.MemberDto;

public class MemberFixture {

    public static Member createMember() {
        return Member.builder()
                .memberNm("kiomnd2")
                .memberPw("qwer1234!@")
                .email("kiomnd2@naver.com")
                .phoneNo("01000000000")
                .build();
    }

    public static MemberDto.RequestJoin createJoinDto() {
        String memberId = "kiomnd2";
        String email = "kiomnd2@naver.com";
        String cfmMemberPw = "qwer1234";
        String memberPw = "qwer1234";

        MemberDto.RequestJoin requestJoin = new MemberDto.RequestJoin();

        requestJoin.setMemberNm(memberId);
        requestJoin.setCfmMemberPw(cfmMemberPw);
        requestJoin.setMemberPw(memberPw);
        requestJoin.setEmail(email);

        return requestJoin;
    }

    public static MemberDto.RequestLogin createLoginDto() {
        String email = "kiomnd2@naver.com";
        String memberPw = "qwer1234!@";
        MemberDto.RequestLogin requestLogin = new MemberDto.RequestLogin();
        requestLogin.setMemberPw(memberPw);
        requestLogin.setEmail(email);
        return requestLogin;
    }

    public static MemberDto.RequestUpdate createUpdateDto() {
        String token = "qwer123412122";
        MemberDto.RequestUpdate requestUpdate = new MemberDto.RequestUpdate();
        requestUpdate.setMemberToken(token);
        requestUpdate.setMemberPw("qwer1234!@#");
        return requestUpdate;
    }

    public static MemberDto.RequestToken createRequestToken() {
        MemberDto.RequestToken token = new MemberDto.RequestToken();
        token.setMemberToken("qwer1234!@");
        return token;
    }

}
