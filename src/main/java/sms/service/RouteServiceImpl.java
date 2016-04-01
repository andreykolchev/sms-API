package sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sms.model.User;
import sms.model.Route;
import sms.model.dto.RouteDto;
import sms.repository.UserRepository;
import sms.repository.RouteRepository;
import sms.util.DtoFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by user on 22.02.16.
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DtoFactory dtoFactory;

    @Override
    public List<RouteDto> getRouts() {
        List<Route> routs = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        if (Objects.nonNull(user)) {
            try {
                routs = routeRepository.findByDateAndUser(new Date(), user);
            }catch (Exception ex){}
        }
       return dtoFactory.createListOfRoutsDto(routs);
    }

}
