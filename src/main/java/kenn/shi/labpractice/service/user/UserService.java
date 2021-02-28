package kenn.shi.labpractice.service.user;

import kenn.shi.labpractice.model.dto.request.UserDto;
import kenn.shi.labpractice.model.entity.User;

import java.util.Map;

public interface UserService {
    Map<String  , Object> addUser(UserDto request);
    void save(User user);
    User getById(Long id);
}
