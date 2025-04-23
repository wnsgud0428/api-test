package com.example.api_test.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // 필요할 때만 주문 목록을 조회해서 성능 최적화
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @BatchSize(size = 10) // N+1 문제 해결을 위해 사용
    private List<Order> orders = new ArrayList<Order>();

}
