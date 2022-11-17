package taurus.trackerBlog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taurus.trackerBlog.Models.Post;
import taurus.trackerBlog.Repositories.PostRepository;

import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String getWelcomePage(Model model){
        return "landing";
    }

    @GetMapping("/To-Do_lists")
    public String getPostPageWithAllNodes (Model model){
        Iterable<Post> postItems = postRepository.findNodePosts();
//        Iterable<Post> postItems = postRepository.findAll();
//        Optional<ArrayList<Post>> results = postRepository.findNodePosts();
//        ArrayList<Post> postItems = postRepository.findNodePosts();
//        ArrayList<Post> postItems = results.get();
        model.addAttribute("postItems",postItems);
        return "post-page";
    }

    @GetMapping("/add-item")
    public String getAddItemPage(Model model){
        return "add-item";
    }

    @GetMapping("/item-details/{id}")
    public String showItemDetails(Model model, @PathVariable(value = "id") long id){
        if(!postRepository.existsById(id)){
            return "landingDNE";
        }
        Optional<Post> singlePostItem = postRepository.findById(id);
        ArrayList<Post> singlePostItemResult = new ArrayList<>();
        singlePostItem.ifPresent(singlePostItemResult :: add);

        ArrayList<Post> childPosts = postRepository.findAllChildPosts(id);

        model.addAttribute("childPosts", childPosts);
        model.addAttribute("singlePostItem", singlePostItemResult);
        return "details-child-list";
    }
//    @GetMapping("/item-details/{id}")//newest 22-xi-17
//    public String showChildrenPosts(Model model, @PathVariable(value = "id") long id){
//        if(!postRepository.existsById(id)){
//            return "landingDNE";
//        }
//
//        Iterable<Post> childPosts = postRepository.findAllChildPosts(id);
//
////        Optional<Post> singlePostItem = postRepository.findById(id);
////        ArrayList<Post> singlePostItemResult = new ArrayList<>();
////        singlePostItem.ifPresent(singlePostItemResult :: add);
//        model.addAttribute("childPosts", childPosts);
//        return "item-details";
//    }

    @PostMapping("/add-item")
    public String addPostItem(@RequestParam String description, @RequestParam String postText, @RequestParam String status, Model model){
        Post postItem = new Post(description, postText, status);
        postRepository.save(postItem);
        return "successMessage";
    }

    @GetMapping("/item-details/{id}/edit-item")
    public String editItemDetails(Model model, @PathVariable(value = "id") long id){//pass idValue to search for the post with that id
        if(!postRepository.existsById(id)){
            return "landingDNE";
        }
        Optional<Post> singlePostItem = postRepository.findById(id);
        ArrayList<Post> singlePostItemResult = new ArrayList<>();
        singlePostItem.ifPresent(singlePostItemResult :: add);
        model.addAttribute("singlePostItem", singlePostItemResult);
        return "edit-item";
    }

    @PostMapping("/item-details/{id}/edit-item")
    public String saveEditsToPostItem(@PathVariable(value="id") long id, @RequestParam String description, @RequestParam String postText, @RequestParam String status, Model model){
        if(!postRepository.existsById(id)){
            return "landingDNE";
        }
        Optional<Post> singlePostItem = postRepository.findById(id);

        ArrayList<Post> singlePostItemResult = new ArrayList<>();
        singlePostItem.ifPresent(singlePostItemResult :: add);

        Post editedPost = singlePostItemResult.get(0);

        editedPost.setPostText(postText);
        editedPost.setDescription(description);
        editedPost.setStatus(status);
        editedPost.setDateModified(Instant.now());

//        model.addAttribute("singlePostItem", singlePostItemResult);

        postRepository.save(editedPost);
        return "successMessage";
    }

    @PostMapping("/item-details/{id}/delete-item")
    public String deletePostItem(@PathVariable(value = "id") long id, Model model){
        Optional<Post> tempPostOptional = postRepository.findById(id);
        if(tempPostOptional.isEmpty()){
            return "landingDNE";
        }
        ArrayList<Post> temp = new ArrayList<>();
        tempPostOptional.ifPresent(temp :: add);

        postRepository.delete(temp.get(0));
        return "successMessage";
    }

    @GetMapping("/item-details/{id}/add-child-item")
    public String showAddChildItemPage(@PathVariable(value="id") long id, Model model){
        return "add-child-item";
    }

    @PostMapping("/item-details/{id}/add-child-item")
    public String addChildPost(@PathVariable(value="id") long id, @RequestParam String description, @RequestParam String postText, @RequestParam String status, Model model){
        System.out.println(id);
        Post postItem = new Post(description, postText, status, id);
        System.out.println(postItem.toString());
        postRepository.save(postItem);
        return "successMessage";
    }

}
