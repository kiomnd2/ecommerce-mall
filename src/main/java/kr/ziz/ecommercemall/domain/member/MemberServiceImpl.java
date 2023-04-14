package kr.ziz.ecommercemall.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;

    @Override
    public MemberInfo registerMember(MemberCommand.RegisterMember memberCommand) {
        return memberStore.store(memberCommand.toEntity());
    }
}
