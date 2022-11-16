package taurus.trackerBlog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taurus.trackerBlog.Models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
