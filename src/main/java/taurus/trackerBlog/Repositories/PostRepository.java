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
            value = "SELECT * FROM post WHERE description LIKE %?%",
            nativeQuery = true)
    ArrayList<Post> findPostsByDescription(String searchDescription);

//    @Query(
//            value = "SELECT * FROM post WHERE TEXT LIKE %?%",
//            nativeQuery = true)
//    ArrayList<Post> findPostsByText(String searchText);
////    SELECT title FROM pages WHERE my_col LIKE %$param1% OR another_col LIKE %$param2%;
//    @Query(
//            value = "SELECT * FROM post WHERE TEXT LIKE %?% OR description LIKE %?%",
//            nativeQuery = true)
//    ArrayList<Post> findPostsByDescAndText(String searchText);


//    @Query(
//            value = "SELECT count() FROM post WHERE parent_post_id=?",
//            nativeQuery = true)
//    Iterable<Long> getPostCount(long id);
}

