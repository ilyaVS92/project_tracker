package taurus.trackerBlog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taurus.trackerBlog.Exceptions.PostNotFoundException;
import taurus.trackerBlog.Models.Post;
import taurus.trackerBlog.Repositories.PostRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    public List<Post> findPostsByDescription(String postDescription);
    public List<Post> findPostByText(String postText);
    public Post findPostById(long id);
    public List<Post> findNodePost();
    public void deletePost(long id);
    public Post updatePost(Post post);
    public Post savePost(Post post);
    public List<Post> findAllPosts();
    public Post updatePost(long id, String postText, String description, String status);
//      {
// //        boolean isGlobalSearch = true;
//         ArrayList<Post> resultsByDescription;
//         if (isExtendedSearch) {
//             resultsByDescription = this.postRepository.findPostsByDescriptionAndText(searchTerm, searchTerm);
//             System.out.println("extended search complete");
//         } else {
//             resultsByDescription = this.postRepository.findPostsByDescription(searchTerm);
//             System.out.println("limited search complete");
//         }
//         return resultsByDescription;
//     }
    public Object findAllChildren(long id);

    // public Iterable<Post> findNodePosts() {
    //     return this.postRepository.findNodePosts();
    // }

    // // public boolean existsById(long id){ -- already exists in repo
    // //     return postRepository.existsById(id);
    // // }

    // public Optional<Post> findById(long id){
    //     if (existsById(id)) {
    //         return this.postRepository.findById(id);
    //     } else {
    //         throw new PostNotFoundException(id);
    //     }
    // }
    // public boolean editPost(long id, String desc, String postText, String status){
    //     Optional<Post> singlePostItem = findById(id);
    //     Post editedPost = checkPostOption(id, singlePostItem);

    //     editedPost.setPostText(postText);
    //     editedPost.setDescription(desc);
    //     editedPost.setStatus(status);
    //     editedPost.setDateModified(Instant.now());

    //     savePost(editedPost);
    //     return true;
    // }

    // public Optional<Post> getSinglePost(long id) {
    //     Optional<Post> singlePostResult = this.postRepository.findById(id);
    //     return singlePostResult;
    // }
    // public ArrayList<Post> showChildPosts(long id);
    // //     ArrayList<Post> childPosts = this.postRepository.findAllChildPosts(id);
    // //     return childPosts;
    // // }
    // public Post addPost(String description, String postText, String status){
    //     Post postItem = new Post(description, postText, status);
    //     return this.postRepository.save(postItem);
    //     //add try-catch here?
    // }
    // public Post checkPostOption(long id, Optional<Post> optionalPost){
    //     if (optionalPost.isPresent()){
    //         return optionalPost.get();
    //     } else {
    //         throw new PostNotFoundException(id);
    //     }
    // }
}