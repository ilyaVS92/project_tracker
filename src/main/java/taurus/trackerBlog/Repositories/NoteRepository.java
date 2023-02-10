package taurus.trackerBlog.Repositories;

import taurus.trackerBlog.Models.*;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByText(String noteText);

    List<Note> findByPostId(long postId);
    
}
