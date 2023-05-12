package kr.ziz.ecommercemall.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfo {

    private final Long id;
    private final String memberToken;
    private final String memberId;
    private final String memberNm;
    private final String memberPw;
    private final String phoneNo;
    private final String email;
    private final MemberStatus status;

    @Builder
    public MemberInfo(Member member) {
        this.id = member.getId();
        this.memberToken = member.getMemberToken();
        this.memberId = member.getMemberId();
        this.memberNm = member.getMemberNm();
        this.memberPw = member.getMemberPw();
        this.phoneNo = member.getPhoneNo();
        this.email = member.getEmail();
        this.status = member.getStatus();
    }
}
