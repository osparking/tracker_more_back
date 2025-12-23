package com.bumsoap.tracker_more.request;

import com.bumsoap.tracker_more.util.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookBody {
    private String id;
    private String tracking_number;
    private String courier_code;
    private String order_number;
    private String delivery_status;
    private LocalDateTime order_date; // setter 필요할 듯, 아니면 생성자.
    private LocalDateTime update_at; // setter 필요할 듯, 아니면 생성자.

    public WebhookBody(String id, String tracking_number,
                       String courier_code, String order_number,
                       String delivery_status, String order_date,
                       String update_at) {
        this.id = id;
        this.tracking_number = tracking_number;
        this.courier_code = courier_code;
        this.order_number = order_number;
        this.delivery_status = delivery_status;
        this.order_date = DateTimeUtils.fromString(order_date);
        this.update_at = DateTimeUtils.fromString(update_at);
    }

    @Override
    public String toString() {
        return "WebhookBody{" +
                "id='" + id + '\'' +
                ", tracking_number='" + tracking_number + '\'' +
                ", courier_code='" + courier_code + '\'' +
                ", order_number='" + order_number + '\'' +
                ", delivery_status='" + delivery_status + '\'' +
                ", order_date=" + order_date +
                ", update_at=" + update_at +
                '}';
    }
}
