package com.myapp.BookingApp.repository;

import com.myapp.BookingApp.model.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Long> {
}
