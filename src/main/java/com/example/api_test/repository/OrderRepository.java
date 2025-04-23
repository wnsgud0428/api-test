package com.example.api_test.repository;

import com.example.api_test.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.person WHERE  = :orderId")
    Optional<Order> findOrderWithPerson(@Param("orderId") Long orderId);

    List<Order> findByPersonId(Long personId);

    @Query("SELECT o FROM Order o JOIN FETCH o.person")
    List<Order> findAllWithPerson();

    @Query("SELECT o FROM Order o JOIN FETCH o.person p WHERE  = :personId")
    List<Order> findByPersonIdWithPerson(@Param("personId") Long personId);
}
