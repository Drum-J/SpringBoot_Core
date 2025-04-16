package hello.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() throws Exception {
        //given
        Member member = new Member("idA", "memberA");
        memberRepository.initTable();

        //when
        memberRepository.save(member);
        Member findMember = memberRepository.find(member.getMemberId());

        //then
        assertEquals(findMember.getName(), member.getName());
        assertEquals(findMember.getMemberId(), member.getMemberId());
    }
}