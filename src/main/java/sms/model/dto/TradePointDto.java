package sms.model.dto;

/**
 * Created by user on 22.02.16.
 */

import lombok.Data;

@Data
public class TradePointDto {

    private Long id;
    private String description;
    private String contact;
    private String phoneNumber;
    private String region;
    private String address;
    private Double latitude;
    private Double longitude;

}
