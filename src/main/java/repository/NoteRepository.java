package repository;

import model.Note;
import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private List<Note> notes = new ArrayList<>();
    private int nextId = 1;

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNoteById(int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    public void addNote(Note note) {
        note.setId(nextId++);
        notes.add(note);
    }

    public void deleteNoteById(int id) {
        notes.removeIf(note -> note.getId() == id);
    }
}
