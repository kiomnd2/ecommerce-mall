package kr.ziz.ecommercemall.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;

    @Override
    public MemberInfo registerMember(MemberCommand.RegisterMember memberCommand) {
        return memberStore.store(memberCommand.toEntity());
    }
}
