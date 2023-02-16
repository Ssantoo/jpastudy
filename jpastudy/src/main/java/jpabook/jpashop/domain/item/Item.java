package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    /*상속관계 매핑이기 때문에
    부모클래스에 전략을 잡아줘야하는데
    @Inheritance를 써주고
    joined : 정령화된 상태로?
    single_table: 한테이블에 다 넣는거
    table per class: book movie album 3개만 나오는거
    @DiscriminatorColumn(name = "dtype")
    dtype : book일떄는 ~할거야 이런식
    */

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
