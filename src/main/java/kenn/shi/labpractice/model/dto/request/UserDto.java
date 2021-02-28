package kenn.shi.labpractice.model.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
public class UserDto {
    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private String location;

    @Email
    private String email;
}
