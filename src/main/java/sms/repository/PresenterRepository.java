package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.Presenter;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andrey on 20.02.2016.
 */
@Repository
@Transactional
public interface PresenterRepository extends CrudRepository<Presenter,Long>{

    List<Presenter> findAll();

}
