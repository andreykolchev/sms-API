package sms.model.dto;

import lombok.Data;
import java.util.Date;

/**
 * Created by user on 22.02.16.
 */
@Data
public class UserDto {

    private Long id;
    private String integrationId;
    private String username;
    private String email;
    private String password;
    private Date createTime;

}
