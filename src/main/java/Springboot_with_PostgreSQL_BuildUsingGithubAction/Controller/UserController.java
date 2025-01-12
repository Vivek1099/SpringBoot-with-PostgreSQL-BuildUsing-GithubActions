package Springboot_with_PostgreSQL_BuildUsingGithubAction.Controller;

import Springboot_with_PostgreSQL_BuildUsingGithubAction.Entity.User;
import Springboot_with_PostgreSQL_BuildUsingGithubAction.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public String test()
    {
        return "Github actions with database";
    }

    @PostMapping("/save")
    public User CreateUser(@RequestBody User user)
    {
        userService.AddUsers(user);
        return user;
    }

    @GetMapping("/show")
    public List<User> ShowAllUsers()
    {
        return userService.ListAllUsers();
    }

    @GetMapping("/byid/{id}")
    public Optional<User> DetailById(@PathVariable int id)
    {
        return userService.UserDetailById(id);
    }

    @GetMapping("/byname/{name}")
    public User DetailByName(@PathVariable String name)
    {
        return userService.UserDetailByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteUser(@PathVariable int id)
    {
        return userService.DeleteUser(id);
    }
}
