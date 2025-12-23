package com.bumsoap.tracker_more.mains;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

public class DetectCourierExample {

    public static void main(String[] args) {
        try {
            TrackingMore trackingMore =
                    new TrackingMore(System.getenv("TRACKINGMORE_API_KEY"));
            TrackingMoreResponse<List<Courier>> result =
                    trackingMore.couriers.getAllCouriers();
            System.out.println(result.getMeta().getCode());
            List<Courier> couriers = result.getData();
            for (Courier courier : couriers) {
                String courierName = courier.getCourierName();
                String courierCode = courier.getCourierCode();
                System.out.println(courierName+"---"+courierCode);
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }
}
