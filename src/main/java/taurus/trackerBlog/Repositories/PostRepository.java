package taurus.trackerBlog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taurus.trackerBlog.Models.Post;

import java.util.Optional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

        Optional<List<Post>> findPostsByDescription(String description);
        Optional<List<Post>> findPostsByPostText(String postText);
        Optional<List<Post>> findAllById(long id);
        Optional<List<Post>> findAllByParentId(long parentId);
//     @Query(
//             value = "SELECT * FROM post WHERE parent_post_id=0",
//             nativeQuery = true)
//     Iterable<Post> findNodePosts();

//     @Query(
//             value = "SELECT * FROM post WHERE parent_post_id=?",
//             nativeQuery = true)
//     ArrayList<Post> findAllChildPosts(long id);

//     @Query(
//             value = "SELECT * FROM post WHERE description LIKE %?%",
//             nativeQuery = true)
//     ArrayList<Post> findPostsByDescription(String searchDescription);

//     @Query(
//             value = "SELECT * FROM post WHERE TEXT LIKE %?%",
//             nativeQuery = true)
//     ArrayList<Post> findPostsByText(String searchText);

//     @Query(
//             value = "SELECT * FROM post WHERE 'TEXT' LIKE %?1% " +
//                     "OR description LIKE %?2%",
//             nativeQuery = true)
// //    @Query(
// //            value = "SELECT p FROM Post WHERE postText LIKE %?1% " +
// //                    "OR description LIKE %?2%",
// //            nativeQuery = false)
//     ArrayList<Post> findPostsByDescriptionAndText(String textOne, String textTwo);

//     @Query(
//             value = "SELECT count() FROM post WHERE parent_post_id=?",
//             nativeQuery = true)
//     Iterable<Long> getPostCount(long id);
}

