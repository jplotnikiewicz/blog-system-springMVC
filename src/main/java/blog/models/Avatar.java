package blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Avatar extends Image {


    @OneToOne
    @NotNull
    private User user;

    public Avatar(){

    }

    public Avatar(String fileName, String fileType, byte[] data, @NotNull User user) {
        super(fileName, fileType, data);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
