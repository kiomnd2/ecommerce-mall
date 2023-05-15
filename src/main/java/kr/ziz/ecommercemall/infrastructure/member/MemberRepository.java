package kr.ziz.ecommercemall.infrastructure.member;

import kr.ziz.ecommercemall.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByMemberToken(String memberToken);
    Optional<Member> findMemberByMemberId(String memberId);
}
