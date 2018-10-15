package blog.services;

import blog.models.Image;
import org.springframework.web.multipart.MultipartFile;

public class ImageServiceImpl implements ImageService {
    @Override
    public Image storeFile(MultipartFile file) {
        return null;
    }

    @Override
    public Image getFile(String fileId) {
        return null;
    }
}
