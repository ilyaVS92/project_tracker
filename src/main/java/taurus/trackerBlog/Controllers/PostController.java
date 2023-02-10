package taurus.trackerBlog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import taurus.trackerBlog.Models.Post;
import taurus.trackerBlog.Services.PostService;
import taurus.trackerBlog.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import taurus.trackerBlog.Models.*;

@AllArgsConstructor
@Controller
public class PostController {

    private PostService postService;
    private NoteService noteService;

    @GetMapping("/")
    public String getWelcomePage(){
        return "landing";
    }

    @GetMapping("/Auth")
    public String getAuthPage(){
        return "auth";
    }

    @GetMapping("/get-regpage")
    public String getRegistrationPage(){
        return "registration-page";
    }

    @PostMapping("/extended-search-page")
    public String findPostsByDescription (Model model, @RequestParam String searchTerm, @RequestParam(required = false) boolean isChecked){

        return "search-results-page";
    }


    @GetMapping("/extended-search-page")
    public String displaySearchPage (Model model){
        SearchObj searchObj = new SearchObj("",false,false);
        return "extended-search-page";
    }

    @GetMapping("/add-item")
    public String getAddItemPage(Post post){
        postService.savePost(post);
        return "add-item";
    }

    @GetMapping("/To-Do_lists")
    public String getPostPageWithAllNodes (Model model){
        model.addAttribute("postItems",postService.findNodePost());
        return "post-page";
    }

    @GetMapping("/item-details/{id}")
    public String showItemDetails(Model model, @PathVariable(value = "id") long id){

        //return a post with an id - to display details
        Post post = postService.findPostById(id);
        long postId = post.getId();
        model.addAttribute("childPosts", postService.findAllChildren(id));
        model.addAttribute("singlePostItem", post);
        model.addAttribute("noteList",noteService.findByPostId(id));
        return "details-child-list";
    }

    @PostMapping("/save-item")
    public Post addPostItem(Post post){
        return postService.savePost(post);
    }

    @GetMapping("/item-details/{id}/edit-item")
    public String editItemDetails(Model model, @PathVariable(value = "id") long id){//pass idValue to search for the post with that id
        // Optional<Post> singlePostItem = postService.findById(id);
        // ArrayList<Post> singlePostItemResult = new ArrayList<>();
        // singlePostItem.ifPresent(singlePostItemResult :: add);
        // model.addAttribute("singlePostItem", singlePostItemResult);
        return "edit-item";

    }

    @PostMapping("/item-details/{id}/edit-item")
    public String saveEditsToPostItem(@PathVariable(value="id") long id, @RequestParam String description, @RequestParam String postText, @RequestParam String status, Model model){
        // if(!postService.existsById(id)){
        //     return "landingDNE";
        // }
        // postService.editPost(id,description,postText,status);
        // System.out.println(id);
        return "successMessage";
    }
    @GetMapping("/FAQs")
    public String displayFAQ(Model model){
        return "FAQs";
    }
    @PostMapping("/item-details/{id}/delete-item")
    public String deletePostItem(@PathVariable(value = "id") long id, Model model){
        // Optional<Post> tempPostOptional = postService.findById(id);
        // if(tempPostOptional.isEmpty()){
        //     return "landingDNE";
        // }
        // ArrayList<Post> temp = new ArrayList<>();
        // tempPostOptional.ifPresent(temp :: add);

        // postService.deletePost(temp.get(0));
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
        postService.savePost(postItem);
//        return "item-details/{id}";
//        return "item-details/"+id;
        return "/item-details/{id}";
    }

}
