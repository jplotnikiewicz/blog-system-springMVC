package blog.services;

import blog.models.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public Image storeFile(MultipartFile file);
    public Image getFile(String fileId);

}
