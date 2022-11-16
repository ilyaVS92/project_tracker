package taurus.trackerBlog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import taurus.trackerBlog.Models.Post;
import taurus.trackerBlog.Repositories.PostRepository;

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
    public String getPostPage (Model model){
        Iterable<Post> postItems = postRepository.findAll();
        model.addAttribute("postItems",postItems);
        return "post-page";
    }
    @GetMapping("/add-item")
    public String getAddItemPage(Model model){
        return "add-item";
    }
    @GetMapping("/item-details/{id}")
    public String showItemDetails(Model model, @PathVariable(value = "id") long id){//pass idValue to search for the post with that id
        if(!postRepository.existsById(id)){
            return "landingDNE";
        }
        Optional<Post> singlePostItem = postRepository.findById(id);
        ArrayList<Post> singlePostItemResult = new ArrayList<>();
        singlePostItem.ifPresent(singlePostItemResult :: add);
        model.addAttribute("singlePostItem", singlePostItemResult);
        return "item-details";
    }
    @PostMapping("/add-item")
    public String addPostItem(@RequestParam String description, @RequestParam String postText, @RequestParam String status, Model model){
        Post postItem = new Post(description, postText, status);
        postRepository.save(postItem);
        return "successMessage";
    }
}
