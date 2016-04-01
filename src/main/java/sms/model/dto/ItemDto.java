package sms.model.dto;

import lombok.Data;

/**
 * Created by user on 22.02.16.
 */
@Data
public class ItemDto {

    private Long id;
    private String description;
    private CategoryDto category;

}
