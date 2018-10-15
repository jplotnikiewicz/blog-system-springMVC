package blog.services;

import blog.models.Avatar;
import blog.models.User;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {

    public Avatar storeFile(MultipartFile file,  User user);
    public Avatar getFile(String fileId);


}
