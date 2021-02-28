package kenn.shi.labpractice.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kenn.shi.labpractice.model.dto.request.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    @OneToOne
    private Location location;

    @Column(name = "email")
    private String email;

    public User(UserDto userDto , Location location) {
        this.firstname = userDto.getFirstname();
        this.lastname = userDto.getLastname();
        this.location = location;
        this.email = userDto.getEmail();
    }
}
