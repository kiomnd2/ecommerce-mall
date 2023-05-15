package kr.ziz.ecommercemall.interfaces.member;

import kr.ziz.ecommercemall.domain.member.MemberCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberCommand.RegisterMember of(MemberDto.RequestJoin join);
    MemberCommand.LoginMember of (MemberDto.RequestLogin login);
}
