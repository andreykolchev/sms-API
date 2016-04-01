package sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sms.integration.client.RestClient;
import sms.model.dto.OrderDto;
import sms.service.OrderService;

import java.util.Objects;


/**
 * Created by user on 18.02.16.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestClient restClient;

    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id")Long orderId) {
        if (orderId==null){
            throw new IllegalArgumentException("Order id cannot be null.");
        }
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrder/", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> postOrder(@RequestBody OrderDto orderDto) {
        try {
            OrderDto order = orderService.createOrder(orderDto);//create in database
            if (Objects.nonNull(order.getId())){
                restClient.postOrder(order);//post to 1c
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
