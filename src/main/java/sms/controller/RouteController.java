package sms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sms.model.dto.RouteDto;
import sms.service.RouteService;

import java.util.List;

/**
 * Created by user on 15.02.16.
 */
@Controller
@RequestMapping("/routs")
public class RouteController {


    @Autowired
    private RouteService routeService;

    /**
     * @return List of routs for user
     */
    @RequestMapping("/getRouts")
    @ResponseBody
    public List<RouteDto> getRouts() {
        List<RouteDto> result = routeService.getRouts();
        return result;
    }

}
