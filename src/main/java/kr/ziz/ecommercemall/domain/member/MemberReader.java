package kr.ziz.ecommercemall.domain.member;

public interface MemberReader {
    Member readMember(MemberCommand.LoginMember member);
}
