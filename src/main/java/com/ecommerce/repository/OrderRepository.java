package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.modal.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.user.id = :userId AND o.orderStatus IN (PLACED, CONFIRMED, SHIPPED, DELIVERED)")
    public List<Order> getUserOrders(@Param("userId") Long userId);

	
	List<Order> findAllByOrderByCreatedAtDesc();
}
