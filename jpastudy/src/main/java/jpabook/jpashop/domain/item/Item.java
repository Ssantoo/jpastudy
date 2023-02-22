package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
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

    // ==비즈니스 로직 ==//

    //재고 수량 증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    //재고 수량 줄이기
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("재고 부족");
        }
        this.stockQuantity = restStock;
    }


}
