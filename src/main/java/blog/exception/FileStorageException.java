package blog.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String message){
        super(message);
    }

    public FileStorageException(String messsage, Throwable cause){
        super(messsage,cause);
    }


}
