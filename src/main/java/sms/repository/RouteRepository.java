package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.User;
import sms.model.Route;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 15.02.16.
 */
@Repository
@Transactional
public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route> findByDateAndUser(Date date, User user);

}
