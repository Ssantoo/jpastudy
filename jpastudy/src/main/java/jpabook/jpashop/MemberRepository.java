package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;
    //스프링 부트가 이 어노테이션 있으면 entityManger를 주입해줌

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }
    //커멘드랑 쿼리랑 분리해라

    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
