package view;

import model.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListNotesView {
    private List<Note> notes;

    public ListNotesView(List<Note> notes) {
        this.notes = notes;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>List of Notes</title></head><body>");
        out.println("<h1>List of Notes</h1>");
        out.println("<ul>");
        for (Note note : notes) {
            out.println("<li><strong>" + note.getTitle() + "</strong><br>" + note.getContent() + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='notes/new'>Add New Note</a>");
        out.println("</body></html>");

        out.close();
    }
}
