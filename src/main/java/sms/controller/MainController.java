package sms.controller;

/**
 * Created by user on 15.02.16.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String thymeleafIndexPage() {
        return "index";
    }

}