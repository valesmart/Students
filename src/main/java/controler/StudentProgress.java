package controler;

import constants.Constants;
import entity.Discipline;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name = "StudentProgress", urlPatterns = "/student-progress")
public class StudentProgress extends AbstractServlet {

    private  static int ids;

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();

        int id = Integer.parseInt(request.getParameter("studentid"));

        ids = id;
        student = dateService.getAllStudentsId(id);

        List<Term> terms = dateService.getAllTerms();

        request.setAttribute("terms", terms);
        request.setAttribute("student", student);
        request.setAttribute("page", "/pages/student-progress.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();
        Term term = new Term();

        term.setId(Integer.parseInt(request.getParameter("choice")));
        int idTerm = term.getId();
        System.out.println(idTerm);

        Term termDuration = dateService.getTermById(idTerm);

        List<Discipline> disciplineByTerm = dateService.getDisciplinesByTerm(idTerm);

        List<Term> terms = dateService.getAllTerms();

        student = dateService.getAllStudentsId(ids);

        request.setAttribute("discipline", disciplineByTerm);
        request.setAttribute("term", termDuration);
        request.setAttribute("terms", terms);
        request.setAttribute("student", student);
        request.setAttribute("page", "/pages/student-progress.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
