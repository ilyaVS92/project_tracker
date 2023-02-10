package taurus.trackerBlog.Services;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import taurus.trackerBlog.Exceptions.NoteNotFoundException;
import taurus.trackerBlog.Models.Note;
import taurus.trackerBlog.Repositories.NoteRepository;

@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Override
    public List<Note> findByText(String noteText) {
        return noteRepository.findByText(noteText);
    }

    @Override
    public List<Note> findByPostId(long postId) {
        return noteRepository.findByPostId(postId);
    }

    @Override
    public Note findById(long id) {
        return unwrapNote(noteRepository.findById(id));
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.delete(findById(id));        
    }

    @Override
    public Note updateNote(Note note) {
        return updateNote(note);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(long id, String noteText) {
        return null;
    }

    public Note unwrapNote(Optional<Note> note){
        if (note.isPresent()){
            return note.get();
        } else {
            throw new NoteNotFoundException();
        }
    }
    public Note unwrapNote(Optional<Note> note, long id){
        if (note.isPresent()){
            return note.get();
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    public List<Note> unwrapNoteList(Optional<List<Note>> noteList){
        if(noteList.isPresent()){
            return noteList.get();
        } else {
            throw new NoteNotFoundException();
        }
    }

}
