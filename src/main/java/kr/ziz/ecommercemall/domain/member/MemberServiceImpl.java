package kr.ziz.ecommercemall.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;

    @Transactional
    @Override
    public MemberInfo registerMember(MemberCommand.RegisterMember memberCommand) {
        return new MemberInfo(memberStore.store(memberCommand.toEntity()));
    }

    @Transactional
    @Override
    public MemberInfo modifyMember(String memberToken, MemberCommand.ModifyMember memberCommand) {
        Member member = memberReader.getMember(memberToken);
        member.changeMember(memberCommand);
        return new MemberInfo(member);
    }
    @Transactional

    @Override
    public void deleteMember(String memberToken) {
        Member member = memberReader.getMember(memberToken);
        member.deleteMember();
    }
}
