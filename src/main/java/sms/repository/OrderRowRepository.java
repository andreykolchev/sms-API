package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.OrderRow;

import javax.transaction.Transactional;

/**
 * Created by Andrey on 20.02.2016.
 */
@Repository
@Transactional
public interface OrderRowRepository extends CrudRepository<OrderRow, Long> {

}
