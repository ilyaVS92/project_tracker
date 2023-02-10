package taurus.trackerBlog.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String noteText;
    @Getter
    @Setter
    private Date date;
    @Getter
    @Setter
    private long authorId;
    @Getter
    @Setter
    private long postId;
}
