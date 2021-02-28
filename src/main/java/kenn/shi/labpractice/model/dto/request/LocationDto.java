package kenn.shi.labpractice.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LocationDto {

    @NotBlank
    private String name;
}
