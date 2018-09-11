package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostForm {

    @NotNull(message = "Title can't be left empty")
    @Size(max=300, message = "Title must not has more than 300 words")
    private String title;

    @NotNull(message = "Body can't be left empty")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
