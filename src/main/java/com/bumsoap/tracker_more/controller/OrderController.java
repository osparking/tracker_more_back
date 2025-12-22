package com.bumsoap.tracker_more.controller;

import com.bumsoap.tracker_more.dto.ApiResponse;
import com.bumsoap.tracker_more.model.BsOrder;
import com.bumsoap.tracker_more.request.AddOrderRequest;
import com.bumsoap.tracker_more.request.TrackingRequest;
import com.bumsoap.tracker_more.service.OrderService;
import com.bumsoap.tracker_more.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addOrder(
            @RequestBody AddOrderRequest addOrderReq) {
        try {
            var statusLabel = addOrderReq.getOrderStatusLabel();
            OrderStatus status = OrderStatus.valueOfLabel(statusLabel);
            BsOrder order = new BsOrder(addOrderReq.getWaybillNo(), status);

            BsOrder orderSaved = orderService.saveOrder(order);

            return ResponseEntity.ok(new ApiResponse(
                    "주문상태 및 운송장번호 저장됨", orderSaved));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/track")
    public ResponseEntity<ApiResponse> trackDelivery(
            @RequestBody TrackingRequest deliveryTracking) {
        try {
            System.out.println("배송 추적: " + deliveryTracking);

            return ResponseEntity.ok(new ApiResponse(
                    "배송 상태 변화 정보 도착", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
}
