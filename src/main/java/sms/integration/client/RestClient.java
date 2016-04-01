package sms.integration.client;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sms.integration.utils.RestClientUtil;
import sms.model.Order;
import sms.model.dto.OrderDto;

/**
 * Created by Oleg Danyliuk on 23.04.2015.
 */
@Service
public class RestClient {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(RestClient.class);
    public static final String ADD_ORDERS = "/addOrders";

    @Autowired
    private RestClientUtil rest;

    @Async
    public OrderDto postOrder(OrderDto orderDto) {
        try {
            return rest.httpPost(ADD_ORDERS, orderDto, OrderDto.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
