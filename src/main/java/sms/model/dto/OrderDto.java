package sms.model.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 22.02.16.
 */
@Data
public class OrderDto {

    private Long id;
    private String integrationId;
    private Date dateTime;
    private String description;
    private Long firmId;
    private Long routeId;
    private List<OrderRowDto> rows;
    private Double sum;
    private Date shippingDate;
    private Date paymentDate;

}
