package sms.model.dto;

import lombok.Data;
import java.util.Date;

/**
 * Created by user on 22.02.16.
 */
@Data
public class RouteDto {

    private Long id;
    private Date date;
    private Integer priority;
    private Date dateTime;
    private TradePointDto tradePoint;

}
