package com.bumsoap.tracker_more.model;

import com.bumsoap.tracker_more.util.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Column(unique = true)
    private String waybillNo;

    public BsOrder(String waybillNo, OrderStatus orderStatus) {
        this.waybillNo = waybillNo;
        this.orderStatus = orderStatus;
    }
}
