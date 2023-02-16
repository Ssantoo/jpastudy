package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Autowired EntityManager em;

    //insert문 보고 싶으면 rollback false / transactional해놔서
    @Test
    @Rollback(false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("cho");

        //when
        Long savedId = memberService.join(member);


        //then

        //em.flush();
        /*rollback이지만 db에 쿼리 날리는거 보고 싶으면
          1. @Autowired EntityManager em;
          2. em.flush();

        */

        assertEquals(member, memberRepository.findOne(savedId));


    }    
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given

        Member member1 = new Member();
        member1.setName("Cho1");

        Member member2 = new Member();
        member2.setName("Cho1");

        //when
        memberService.join(member1);
        memberService.join(member2);

//        try{
//            memberService.join(member2); //예외 발생
//        } catch (IllegalStateException e){
//            return;
//        }


        //then
        fail("예외발생");



    }    
    
    
    
    
}