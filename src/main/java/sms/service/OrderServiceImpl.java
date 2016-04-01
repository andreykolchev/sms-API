package sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sms.model.dto.OrderDto;
import sms.repository.OrderRepository;
import sms.util.DtoFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 24.03.16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DtoFactory dtoFactory;

    @Override
    public OrderDto getOrder(Long id) {
        return dtoFactory.createOrderDto(orderRepository.findOne(id));
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderDto> orderDtos = orderRepository.findAll().stream()
                .map(order -> dtoFactory.createOrderDto(order))
                .collect(Collectors.toList());
        return orderDtos;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        return dtoFactory.createOrderDto(dtoFactory.createOrder(orderDto));
    }

}
