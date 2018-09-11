package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    public static final String LOGGED_USER_SESSION_KEY = "loggedUser";

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HttpSession httpSession;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {

        List<Long> ids = new ArrayList<>(1);
        ids.add(id);
        List<User> users = this.userRepo.findAllById(ids);
        User user = users.get(0);
        return user;
    }


    @Override
    public User findByUsername(String username, String password) {
        User user = userRepo.findByUsername(username, password);
        if(user != null)
            httpSession.setAttribute(LOGGED_USER_SESSION_KEY, user);
        return user;
    }

    @Override
    public void logout(){
        httpSession.removeAttribute(LOGGED_USER_SESSION_KEY);
    }


    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {

        this.userRepo.deleteById(id);
    }


}
