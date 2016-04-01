package sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sms.model.Presenter;
import sms.model.dto.PresenterDto;
import sms.repository.PresenterRepository;
import sms.util.DtoFactory;

import java.util.List;

/**
 * Created by user on 09.03.16.
 */
@Service
public class PresenterServiceImpl implements PresenterService {

    @Autowired
    private PresenterRepository presenterRepository;

    @Autowired
    private DtoFactory dtoFactory;

    @Override
    public List<PresenterDto> getPresenter() {
        List<Presenter> presenter = null;
        try {
            presenter = presenterRepository.findAll();
        } catch (Exception ex) {

        }
        return dtoFactory.createListOfPresenterDto(presenter);
    }
}
