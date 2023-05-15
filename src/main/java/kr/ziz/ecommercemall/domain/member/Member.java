package kr.ziz.ecommercemall.domain.member;

import jakarta.persistence.*;
import kr.ziz.ecommercemall.common.util.TokenGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "members")
public class Member {
    private final String PREFIX = "MEMBER_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberToken;
    private String memberId;
    private String memberNm;
    private String memberPw;
    private String phoneNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private final String UPPERCASE_REG_EXP = "^((.*)[A-Z](.*))";
    private final String LOWERCASE_REG_EXP = "^((.*)[a-z](.*))";
    private final String NUMBER_REG_EXP = "^((.*)\\d(.*))";
    private final String SPECIAL_SYMBOLS_REG_EXP = "((.*)[!@#$%^&*()](.*))";

    @Builder
    public Member(String memberId, String memberNm, String memberPw
            , String phoneNo, String email) {
        if (!StringUtils.hasLength(memberId)) throw new RuntimeException("managerId는 필수값입니다.");
        if (!StringUtils.hasLength(memberNm)) throw new RuntimeException("managerNm는 필수값입니다.");
        if (!StringUtils.hasLength(phoneNo)) throw new RuntimeException("phoneNo는 필수값입니다.");
        verifyPassword(memberPw);

        this.memberToken = TokenGenerator.randomCharacterWithPrefix(PREFIX);
        this.memberId = memberId;
        this.memberNm = memberNm;
        this.memberPw = memberPw;
        this.phoneNo = phoneNo;
        this.email = email;
        this.status = MemberStatus.NOT_AUTHED; // 미인증 상태
    }

    public void changeMember(MemberCommand.ModifyMember member) {
        verifyPassword(member.getMemberPw());
        this.memberNm = member.getMemberNm();
        this.memberPw = member.getMemberPw();
        this.phoneNo = member.getPhoneNo();
    }

    public void deleteMember() {
        status = MemberStatus.DORMANCY;
    }

    private void verifyPassword(String password) {
        if (!StringUtils.hasLength(password) && password.length() < 12) throw new RuntimeException("길이 12자 이상");

        int appliedRegExpCnt = 0;
        if(Pattern.matches(UPPERCASE_REG_EXP, password)) appliedRegExpCnt++;
        if(Pattern.matches(LOWERCASE_REG_EXP, password)) appliedRegExpCnt++;
        if(Pattern.matches(NUMBER_REG_EXP, password)) appliedRegExpCnt++;
        if(Pattern.matches(SPECIAL_SYMBOLS_REG_EXP, password)) appliedRegExpCnt++;
        if( appliedRegExpCnt < 3 ) throw new RuntimeException("영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상");
    }


}
