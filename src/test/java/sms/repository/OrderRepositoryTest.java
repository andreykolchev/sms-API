package sms.repository;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import sms.model.Item;
import sms.model.Order;
import sms.model.OrderRow;
import sms.BootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 24.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApplication.class)
@WebAppConfiguration
@Transactional
public class OrderRepositoryTest extends TestCase {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;


    @Test
    public void testCreateOrder() {

        Item item = itemRepository.findOne(1L);
        Order order = new Order();
        Set<OrderRow> rows = new HashSet<>();
        OrderRow orderRow = new OrderRow();
        orderRow.setItem(item);
        orderRow.setQuantity(10);
        orderRow.setPrice(100.00);
        orderRow.setSum(1000.00);

        rows.add(orderRow);
        order.setRows(rows);
        orderRepository.save(order);

    }


}