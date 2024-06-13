package controller;

import model.Note;
import repository.NoteRepository;
import view.AddNoteView;
import view.ListNotesView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NoteController extends HttpServlet {
    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        noteRepository = new NoteRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/notes":
                listNotes(request, response);
                break;
            case "/notes/new":
                showAddNoteForm(request, response);
                break;
            case "/notes/delete":
                deleteNoteById(request, response);
                break;
            default:
                response.sendRedirect("/notes");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/notes":
                addNote(request, response);
                break;
            default:
                response.sendRedirect("/notes");
                break;
        }
    }

    void listNotes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Note> notes = noteRepository.getAllNotes();
        ListNotesView view = new ListNotesView(notes);
        view.render(request, response);
    }

    private void showAddNoteForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AddNoteView view = new AddNoteView();
        view.render(request, response);
    }

    void addNote(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        noteRepository.addNote(newNote);

        response.sendRedirect(request.getContextPath() + "/notes");
    }

    private void deleteNoteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        noteRepository.deleteNoteById(id);
        response.sendRedirect(request.getContextPath() + "/notes");
    }
}
