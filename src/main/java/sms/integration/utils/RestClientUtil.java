package sms.integration.utils;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by user on 18.02.2016.
 */
@Service
public class RestClientUtil {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(RestClientUtil.class);

    @Qualifier("integrationRestTemplate")
    @Autowired
    RestTemplate rest;

    @Value( "${1c.rest.url}" )
    private String url;

     public <T> T httpPost(String methodUrl, Object requestBody, Class<T> responseClass) {
        log.debug("Calling "+(url+methodUrl));
        return rest.postForObject(url+methodUrl, requestBody, responseClass);
    }

}
