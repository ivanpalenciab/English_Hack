package servlets;

import controller.LessonController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletLessonGrade", urlPatterns = {"/ServletLessonGrade"})
public class ServletLessonGrade extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletLessonGrade() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LessonController lesson = new LessonController();
        String user = request.getParameter("username");
        int lessonID = Integer.parseInt("lessonId");
        boolean finished = Boolean.parseBoolean("finished");
        double grade = Double.parseDouble("grade");
        String result = lesson.sendGrade(user, lessonID, finished, grade);
        
        response.setContentType("text-html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
