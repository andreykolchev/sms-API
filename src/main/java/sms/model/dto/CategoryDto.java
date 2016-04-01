package sms.model.dto;

import lombok.Data;

/**
 * Created by user on 22.02.16.
 */
@Data
public class CategoryDto {

    private Long id;
    private String name;
    private CategoryDto parent;

}
