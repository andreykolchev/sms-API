package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.TradePoint;

import javax.transaction.Transactional;

/**
 * Created by Andrey on 20.02.2016.
 */
@Repository
@Transactional
public interface TradePointRepository extends CrudRepository<TradePoint,Long> {

}
