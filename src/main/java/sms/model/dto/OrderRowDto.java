package sms.model.dto;

import lombok.Data;

/**
 * Created by user on 22.02.16.
 */
@Data
public class OrderRowDto {

    private Long id;
    private Long orderId;
    private Long itemId;
    private Double price;
    private Double quantity;
    private Double sum;

}
