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

//    @Getter
    @Setter
    private Instant dateCreated = Instant.now();

//    @Getter
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
    private int parentPostId;

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
    }

    public Post(long id, String description, Instant dateCreated, Instant dateModified, String status, String postText, int authorId, int parentPostId, boolean completed) {
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

//    public void setDateCreated(Instant dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Instant getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreate(Instant dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public Instant getDateModified() {
//        return dateModified;
//    }
//
//    public void setDateModified(Instant dateModified) {
//        this.dateModified = dateModified;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public int getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(int authorId) {
//        this.authorId = authorId;
//    }
//
//    public int getParentPostId() {
//        return parentPostId;
//    }
//
//    public void setParentPostId(int parentPostId) {
//        this.parentPostId = parentPostId;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
}
