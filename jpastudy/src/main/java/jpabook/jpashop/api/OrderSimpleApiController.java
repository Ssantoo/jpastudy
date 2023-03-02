package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



/*

xToOne (ManyToOne, OneToOne)  : 양방향 걸린 연관관계 '@JsonIgnore'
Order
Order -> Member
Order -> Delivery

 */


@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    private final OrderSimpleQueryRepository orderSimpleQueryRepository; //의존관계주입


    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1(){

        List<Order> all = orderRepository.findAllByString((new OrderSearch()));

        for (Order order : all){
            order.getMember().getName(); //Lazy 강제 초기화
            order.getDelivery().getAddress(); //Lazy 강제 초기화

        }

        return all;

    }


    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2(){


        //결과 2개 -> 쿼릭가 총 5번 나간다 Order / member /delivery  / 또다른 결과의 member delivery
        // 1 + N(2)  -> 1 + 회원N + 배송 N
        //특히 eagger로 하면 더 심각하다
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());

        return orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

    }

    @Data
    static class SimpleOrderDto{
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order){
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();

        }

    }

    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3(){

        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        return orders.stream()
                    .map(o-> new SimpleOrderDto(o))
                    .collect(Collectors.toList());
    }

    /**
     * V4. JPA에서 DTO로 바로 조회
     * - 쿼리 1번 호출
     * - select 절에서 원하는 데이터만 선택해서 조회
     */
    @GetMapping("/api/v4/simple-orders")
    public List<OrderSimpleQueryDto> ordersV4() {
        //return orderRepository.findOrderDtos();
        return orderSimpleQueryRepository.findOrderDtos();
    }




}
