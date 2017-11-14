package sprintbootrestexample.sprintbootrestexample.controller;

import sprintbootrestexample.sprintbootrestexample.entity.User;
import sprintbootrestexample.sprintbootrestexample.entity.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sprintbootrestexample.sprintbootrestexample.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest)
    {
        User newUser = new User();
        newUser.setName(addUserRequest.getName());
        newUser.setLastname(addUserRequest.getLastame());
        userRepository.save(newUser);
    }
}
