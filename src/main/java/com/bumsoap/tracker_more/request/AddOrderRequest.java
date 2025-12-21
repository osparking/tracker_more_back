package com.bumsoap.tracker_more.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrderRequest {
    private String orderStatusLabel;

    @Column(unique = true)
    private String waybillNo;
}
