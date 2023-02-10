package taurus.trackerBlog.Exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long postId) {
        super("The post with id: '" + postId+ "' does not exist in our records");
    }
    public PostNotFoundException() {
        super("The post requested does not exist in our records");
    }
}