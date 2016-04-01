package sms.model.dto;

import lombok.Data;

/**
 * Created by user on 22.02.16.
 */
@Data
public class PresenterDto {

    private Long id;
    private ItemDto item;
    private Integer priority;
    private String imageURI;

}
