package taurus.trackerBlog.Services;

import taurus.trackerBlog.Models.*;
import java.util.List;

public interface NoteService {
    public List<Note> findByText(String noteText);
    public List<Note> findByPostId(long postId);
    public Note findById(long id);
    public void deleteNote(long id);
    public Note updateNote(Note comment);
    public Note saveNote(Note comment);
    public List<Note> findAll();
    public Note updateNote(long id, String noteText);
}
