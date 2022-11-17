package taurus.trackerBlog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taurus.trackerBlog.Models.Post;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            value = "SELECT * FROM post WHERE parent_post_id=0",
            nativeQuery = true)
    Iterable<Post> findNodePosts();

    @Query(
            value = "SELECT * FROM post WHERE parent_post_id=?",
            nativeQuery = true)
    ArrayList<Post> findAllChildPosts(long id);

    @Query(
            value = "SELECT * FROM post WHERE description=?",
            nativeQuery = true)
    Optional<Post> findPostsByDescription(String description);
}

