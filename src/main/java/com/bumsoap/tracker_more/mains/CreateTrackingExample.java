package com.bumsoap.tracker_more.mains;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import com.trackingmore.model.tracking.CreateTrackingParams;
import com.trackingmore.model.tracking.Tracking;

import java.io.IOException;
import java.util.List;

public class CreateTrackingExample {

    public static void main(String[] args) {
        try {
            TrackingMore trackingMore =
                    new TrackingMore(System.getenv("TRACKINGMORE_API_KEY"));
            CreateTrackingParams createTrackingParams = new CreateTrackingParams();
            createTrackingParams.setTrackingNumber("363131774051");
            createTrackingParams.setCourierCode("cjlogistics");
            createTrackingParams.setTitle("백설공주 5개 외...");
            createTrackingParams.setLanguage("ko");
            createTrackingParams.setNote("도어 밖에 두세요.");
            TrackingMoreResponse<Tracking> result =
                    trackingMore.trackings.CreateTracking(createTrackingParams);
            System.out.println(result.getMeta().getCode());
            if (result.getData()!=null) {
                Tracking trackings = result.getData();
                System.out.println(trackings);
                System.out.println(trackings.getTrackingNumber());
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }
}
