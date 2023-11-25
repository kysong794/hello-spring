package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);     //Optional은 반환값이 null일 경우 Optional로 감싸서 보냄, 자바8에 추가된 기능
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
