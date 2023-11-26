package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // option + enter = 자동 import
    private static final Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);           //id를 셋팅해주고, sequence 값을 올려주면서.
        store.put(member.getId(), member);  //store에 id 저장 (map에 저장됨)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //store에서 id를 꺼내옴 / ofNullable은 값이 (id가)null이라도 가져올수있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))    //파라미터로 넘어온 name이 getName과 같은지 비교
                .findAny();     // findAny하나라도 찾는것 있으면 반환, 없으면 Optionnal에서 null이 포함되어 넘겨짐

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 있는 valuse들이 member
    }

    public void clearStore(){
        store.clear();
    }
}
