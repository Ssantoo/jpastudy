package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext
//    private EntityManager em;
//    //스프링 부트가 이 어노테이션 있으면 entityManger를 주입해줌
//
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }

    private final EntityManager em;
    //스프링 부트 라이브러리를 쓰면 jpa를 쓰면  @PersistenceContext -> @Autowired 로 바꿀 수 있다.



//    public Long save(Member member){
//        em.persist(member);
//        return member.getId();
//    }
//    //커멘드랑 쿼리랑 분리해라
//
//    public Member find(Long id){
//        return em.find(Member.class, id);
//    }

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //맴버 검색
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //jpql : Entity 객체를 대상으로
    //sql : 테이블을 대상으로
    
    //이름으로 검색
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }



}
