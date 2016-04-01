package sms.service;

import org.springframework.stereotype.Service;
import sms.model.dto.OrderDto;

import java.util.List;

/**
 * Created by user on 24.03.16.
 */
@Service
public interface OrderService {

    OrderDto getOrder(Long id);

    List<OrderDto> getOrders();

    OrderDto createOrder(OrderDto orderDto);

}
