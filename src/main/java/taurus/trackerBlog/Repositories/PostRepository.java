package taurus.trackerBlog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import taurus.trackerBlog.Models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
