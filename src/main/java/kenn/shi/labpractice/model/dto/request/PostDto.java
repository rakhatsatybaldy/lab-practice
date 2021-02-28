package kenn.shi.labpractice.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class PostDto {

    private Long id;

    @NotBlank
    private Long userId;

    @NotBlank
    private String details;
}
