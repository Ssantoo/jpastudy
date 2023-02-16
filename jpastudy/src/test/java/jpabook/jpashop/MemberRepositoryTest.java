package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {

        //entityManager를 통한 모든 데이터 변경은 항상 트랜잭션 안에서 일어나야한다.
        //transactional 어노테이션 써야함
        //test에 transactional이 있으면 db를 롤백해버림
        //@Rollback(false) 해주면 볼수 있음

        //given
  //      Member member = new Member();
//        member.setUsername("memberA");

        //when
        //Long savedId = memberRepository.save(member);
        //ctrl alt v 변수 뽑아오는거

        //Member findMember = memberRepository.find(savedId);

        //then
        //Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

        //복사 ctrl d
        //Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        //System.out.println("findMember== member"+(findMember==member));


    }    

}