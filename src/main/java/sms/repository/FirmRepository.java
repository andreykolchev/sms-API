package sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sms.model.Firm;

import javax.transaction.Transactional;

/**
 * Created by Andrey on 20.02.2016.
 */
@Repository
@Transactional
public interface FirmRepository extends CrudRepository<Firm,Long>{

}
