package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.Order;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by user on 15.02.16.
 */
@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

}
