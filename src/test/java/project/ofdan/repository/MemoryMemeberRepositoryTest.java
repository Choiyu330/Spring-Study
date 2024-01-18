package project.ofdan.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import project.ofdan.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemeberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /* 메소드가 실행되고 끝날 때 마다 동작하는 콜백 메소드 */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        /*
        jupiter 에서 제공하는 Assertions 메소드 (과거)
        Assertions.assertEquals(member, result);
        */

        // Assertj 에서 제공하는 Assertions 메소드 (현재, 조금 더 간편하게 사용가능함)
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
