package blog.forms;

import javax.validation.constraints.NotNull;

public class CommentForm {

    @NotNull(message = "Comment body can't be left empty")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
