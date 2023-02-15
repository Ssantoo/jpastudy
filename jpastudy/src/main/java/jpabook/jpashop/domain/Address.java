package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    //@Embeddable : 어딘가 내장될 수 있다.


    private String city;
    private String street;
    private String zipcode;
}
