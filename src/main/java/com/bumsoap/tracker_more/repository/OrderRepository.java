package com.bumsoap.tracker_more.repository;

import com.bumsoap.tracker_more.model.BsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<BsOrder, Long> {
}
