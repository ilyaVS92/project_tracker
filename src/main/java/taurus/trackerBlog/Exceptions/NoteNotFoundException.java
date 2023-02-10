package taurus.trackerBlog.Exceptions;

public class NoteNotFoundException extends RuntimeException{
    
    public NoteNotFoundException(Long noteId) {
        super("The note with id: '" + noteId+ "' does not exist in our records");
    }
    public NoteNotFoundException() {
        super("The note requested does not exist in our records");
    }
}
