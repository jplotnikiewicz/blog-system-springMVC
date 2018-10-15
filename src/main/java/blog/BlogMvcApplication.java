package blog;

import blog.propertis.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class BlogMvcApplication {

    public static void main(String []  args){
        SpringApplication.run(BlogMvcApplication.class, args);
    }

}
