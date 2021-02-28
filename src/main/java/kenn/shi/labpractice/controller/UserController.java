package kenn.shi.labpractice.controller;

import kenn.shi.labpractice.model.dto.request.UserDto;
import kenn.shi.labpractice.model.entity.User;
import kenn.shi.labpractice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Lazy UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public Map<String , Object> create(@Valid @RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @GetMapping(value = "/id/{id}")
    public User user(@PathVariable(name = "id")Long id){
        return userService.getById(id);
    }
}
