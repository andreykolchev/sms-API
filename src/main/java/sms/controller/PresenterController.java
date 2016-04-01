package sms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sms.model.dto.PresenterDto;
import sms.service.PresenterService;

import java.util.List;

/**
 * Created by user on 15.02.16.
 */
@Controller
@RequestMapping("/presenter")
public class PresenterController {


    @Autowired
    private PresenterService presenterService;

    /**
     * @return List of Presenter items for user
     */
    @RequestMapping("/getPresenter")
    @ResponseBody
    public List<PresenterDto> getPresenter() {
        List<PresenterDto> result = presenterService.getPresenter();
        return result;
    }

}
