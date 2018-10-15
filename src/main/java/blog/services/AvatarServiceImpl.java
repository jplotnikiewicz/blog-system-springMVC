package blog.services;

import blog.exception.FileStorageException;
import blog.exception.MyFileNotFoundException;
import blog.models.Avatar;
import blog.models.User;
import blog.repositories.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class AvatarServiceImpl implements AvatarService {


    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public Avatar storeFile(MultipartFile file, User user) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Avatar avatar = new Avatar(fileName, file.getContentType(), file.getBytes(), user);


            return avatarRepository.save(avatar);

        } catch (IOException ex){
            throw new FileStorageException("Could not store file " + fileName + ". Please try again", ex);
        }
    }

    @Override
    public Avatar getFile(String fileId) {
        return avatarRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
