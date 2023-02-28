package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Setter @Getter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    //@NotEmpty
    private String name;

    @Embedded
    private Address address;
    //embedded: @Embeddable를 포함하고 있다는거 표시
    //내장 타입

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    //mappedBy 적는 순간 난 매핑하는 애가 아니고
    //orderTable에 member에 난 그냥 거울일 뿐이야..(읽기 전용이 됨)


}
