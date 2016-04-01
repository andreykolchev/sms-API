package sms.controller;

/**
 * Created by user on 15.02.16.
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity login() {
        return new ResponseEntity(HttpStatus.OK);
    }

}