package jpabook.jpashop;


import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        //Tx
        book.setName("asdf");

        //변경감지  == dirty checking
        //TX commit

        //준영속 엔티티?
        //영속성 컨텍스트가 더는 관리하지 않는 엔티티


        
    }    


}
