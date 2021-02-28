package kenn.shi.labpractice.service.user;

import kenn.shi.labpractice.model.dto.request.UserDto;
import kenn.shi.labpractice.model.entity.Location;
import kenn.shi.labpractice.model.entity.User;
import kenn.shi.labpractice.repository.user.UserRepository;
import kenn.shi.labpractice.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final LocationService locationService;
    private final Map<String , Object> result;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LocationService locationService, Map<String, Object> result) {
        this.userRepository = userRepository;
        this.locationService = locationService;
        this.result = result;
    }

    @Override
    public Map<String, Object> addUser(UserDto request) {
        boolean existByEmail = userRepository.existsByEmail(request.getEmail());
        if (existByEmail){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "User with email " + request.getEmail() + " is already exists"
            );
        }
        Location location = locationService.findByName(request.getLocation());
        if (location==null){
            location = new Location(request.getLocation());
            locationService.save(location);
        }
        User user  = new User(request , location);
        save(user);
        result.put("message" , "Successfully created");
        result.put("status" , HttpStatus.OK);
        return result;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        User user = userRepository.getById(id);
        if (user==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "does not exist"
            );
        }
        return user;
    }
}
