package kr.ziz.ecommercemall.domain.member;

public interface MemberService {
    MemberInfo registerMember(MemberCommand.RegisterMember memberCommand);
}
