package view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNoteView {
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Add Note</title></head><body>");
        out.println("<h1>Add a New Note</h1>");
        out.println("<form action='notes' method='post'>");
        out.println("<label>Title:</label><br>");
        out.println("<input type='text' name='title'><br>");
        out.println("<label>Content:</label><br>");
        out.println("<textarea name='content'></textarea><br>");
        out.println("<input type='submit' value='Add Note'>");
        out.println("</form>");
        out.println("</body></html>");

        out.close();
    }
}
