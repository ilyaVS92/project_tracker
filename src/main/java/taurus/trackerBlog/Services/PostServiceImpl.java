package taurus.trackerBlog.Services;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import taurus.trackerBlog.Exceptions.PostNotFoundException;
import taurus.trackerBlog.Models.*;
import taurus.trackerBlog.Repositories.*;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public List<Post> executeSimpleSearch(String searchString){
        List<Post> searchResults;
        searchResults = findPostByText(searchString);
        List<Post> temp = findPostsByDescription(searchString);
        for (Post p : temp){
            searchResults.add(p);
        }
        return searchResults; 
    }

    public List<Post> executeExpandedSearch(SearchObj searchObj, String postText, String description){
        boolean searchText = searchObj.isIncludePostText();
        boolean searchDescription = searchObj.isIncludeTitle();
        String searchString = searchObj.getSearchStr();
        List<Post> searchResults;
        if (searchText && searchDescription){
            searchResults = findPostByText(searchString);
            List<Post> temp = findPostsByDescription(searchString);
            for (Post p : temp){
                searchResults.add(p);
            }
        } else if (!searchText && searchDescription){
            searchResults = findPostByText(searchString);
        } else {
            searchResults = findPostsByDescription(searchString);
        }
        return searchResults; 
    }

    public List<Post> findPostsByDescription(String description){
        Optional<List<Post>> postList = postRepository.findPostsByDescription(description);
        return unwrapPostList(postList);

    }
    public List<Post> findPostByText(String postText){
        Optional<List<Post>> postList = postRepository.findPostsByPostText(postText);
        return unwrapPostList(postList);
    }
    
    public Post findPostById(long id){
        Optional<Post> post = postRepository.findById(id);
        return unwrapPost(post,id);
    }
    public List<Post> findAllChildren(long id){
        return unwrapPostList(postRepository.findAllByParentId(id));
    }

    public List<Post> findNodePost(){
        Optional<List<Post>> nodePosts = postRepository.findAllByParentId(0L);
        return unwrapPostList(nodePosts); 
    }

    public void deletePost(long id){
        if (postRepository.existsById(id)){
            postRepository.deleteById(id);
        } else{
            throw new PostNotFoundException(id);
        }
    }

    @Override
    public Post updatePost(long id, String postText, String description, String status){
        Post post = unwrapPost(postRepository.findById(id));
        post.setPostText(postText);
        post.setDescription(description);
        post.setStatus(status);
        return savePost(post);
    }

    public Post savePost(Post post){
        postRepository.save(post);
        return post;
    }

    public List<Post> findAllPosts(){
        return postRepository.findAll();
    }
    public Post unwrapPost(Optional<Post> post){
        if (post.isPresent()){
            return post.get();
        } else {
            throw new PostNotFoundException();
        }
    }
    public Post unwrapPost(Optional<Post> post, long id){
        if (post.isPresent()){
            return post.get();
        } else {
            throw new PostNotFoundException(id);
        }
    }

    public List<Post> unwrapPostList(Optional<List<Post>> postList){
        if(postList.isPresent()){
            return postList.get();
        } else {
            throw new PostNotFoundException();
        }
    }
    @Override
    public Post updatePost(Post post) {
        // TODO Auto-generated method stub
        return null;
    }
}
