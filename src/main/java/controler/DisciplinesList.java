package controler;

import entity.Discipline;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name = "DisciplinesList", urlPatterns = {"/disciplines-list"})
public class DisciplinesList extends AbstractServlet {

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Discipline> disciplines = dateService.getAllDisciplines();

        request.setAttribute("disciplines", disciplines);
        request.setAttribute("page", "/pages/disciplines-list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/pages/disciplines-list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
