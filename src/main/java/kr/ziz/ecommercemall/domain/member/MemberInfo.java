package kr.ziz.ecommercemall.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfo {

    private final Long id;
    private final String memberId;
    private final String memberNm;
    private final String memberPw;
    private final String phoneNo;
    private final String email;
    private final String authKey;
    private final Boolean authYn;

    @Builder
    public MemberInfo(Long id, String memberId, String memberNm, String memberPw,
                      String phoneNo, String email, String authKey, Boolean authYn) {
        this.id = id;
        this.memberId = memberId;
        this.memberNm = memberNm;
        this.memberPw = memberPw;
        this.phoneNo = phoneNo;
        this.email = email;
        this.authKey = authKey;
        this.authYn = authYn;
    }
}
