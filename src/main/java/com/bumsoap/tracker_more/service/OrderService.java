package com.bumsoap.tracker_more.service;

import com.bumsoap.tracker_more.model.BsOrder;
import com.bumsoap.tracker_more.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public BsOrder saveOrder(BsOrder order) {
        return repository.save(order);
    }
}
