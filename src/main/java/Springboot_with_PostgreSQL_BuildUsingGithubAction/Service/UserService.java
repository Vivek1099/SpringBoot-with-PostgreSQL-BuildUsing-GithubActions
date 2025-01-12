package Springboot_with_PostgreSQL_BuildUsingGithubAction.Service;

import Springboot_with_PostgreSQL_BuildUsingGithubAction.Entity.User;
import Springboot_with_PostgreSQL_BuildUsingGithubAction.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public void AddUsers(User user)
    {
        userRepository.save(user);
    }

    public List<User> ListAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> UserDetailById(int id)
    {
        return userRepository.findById(id);
    }

    public String DeleteUser(int id)
    {
        userRepository.deleteById(id);
        return "User Deleted";
    }

    public User UserDetailByName(String name)
    {
        return userRepository.getByUserName(name);
    }
}
