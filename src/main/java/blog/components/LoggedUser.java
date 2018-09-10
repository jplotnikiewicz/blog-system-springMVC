package blog.components;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser {


    public LoggedUser(String username) {
        this.username = username;
    }

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
