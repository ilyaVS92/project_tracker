package taurus.trackerBlog.Models;

import lombok.AllArgsConstructor;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class SearchObj {
    private String searchStr;
    private boolean includeTitle;
    private boolean includePostText;

}
