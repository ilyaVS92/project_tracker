package taurus.trackerBlog.Models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Component
@Entity
public class Post implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Instant dateCreated = Instant.now();

    @Getter
    @Setter
    private Instant dateModified = Instant.now();

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String postText;

    @Getter
    @Setter
    private int authorId;

    @Getter
    @Setter
    private long parentPostId;

    @Getter
    @Setter
    private boolean completed;

    public Post(){

    }

    public Post(String description, String postText, String status){
        this.description = description;
        this.completed = false;
        this.postText = postText;
        this.status = status;
        this.dateModified = Instant.now();
    }
    public Post(String description, String postText, String status, long parentPostId){
        this.description = description;
        this.completed = false;
        this.postText = postText;
        this.status = status;
        this.dateModified = Instant.now();
        this.parentPostId = parentPostId;
    }

    public Post(long id, String description, Instant dateCreated, Instant dateModified, String status, String postText, int authorId, long parentPostId, boolean completed) {
        this.id = id;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.status = status;
        this.postText = postText;
        this.authorId = authorId;
        this.parentPostId = parentPostId;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", status='" + status + '\'' +
                ", postText='" + postText + '\'' +
                ", authorId=" + authorId +
                ", parentPostId=" + parentPostId +
                ", completed=" + completed +
                '}';
    }
}
