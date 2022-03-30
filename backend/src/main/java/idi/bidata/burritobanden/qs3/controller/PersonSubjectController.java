package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.PersonSubject;
import idi.bidata.burritobanden.qs3.service.PersonService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonSubjectController {

    @Autowired private UserService userService;

    // Save operation
    @PostMapping("/users")
    public User saveUser(
            @Valid @RequestBody User user)
    {
        return userService.saveUser(user);
    }

    // Read operation
    @GetMapping("/users")
    public List<User> fetchUserList()
    {
        return userService.fetchUserList();
    }


    // Update operation
    @PutMapping("/users/{id}")
    public User
    updateUser(@RequestBody User user,
               @PathVariable("id") Long userId)
    {
        return userService.updateUser(
                user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id")
                                         Long userId)
    {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
