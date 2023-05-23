package kr.ziz.ecommercemall.domain.member;

public interface MemberReader {
    Member getMember(String memberToken);

    Member login(String email, String memberPw);
}
