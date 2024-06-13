package repository;

import model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NoteRepositoryTest {
    private NoteRepository noteRepository;

    @BeforeEach
    public void setUp() {
        noteRepository = new NoteRepository();
    }

    @Test
    public void testAddNote() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("This is a test note");

        noteRepository.addNote(note);
        List<Note> notes = noteRepository.getAllNotes();

        assertEquals(1, notes.size());
        assertEquals(note, notes.get(0));
    }

    // Additional tests for other repository methods can be added similarly
}
