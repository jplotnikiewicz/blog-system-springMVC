package blog.services;

import blog.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    boolean isValidUser(String username, String passwor);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
