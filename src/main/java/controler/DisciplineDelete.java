package controler;

import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Валера on 09.04.2017.
 */
@WebServlet(name = "DisciplineDelete", urlPatterns = {"/discipline-list"})
public class DisciplineDelete extends AbstractServlet{

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] id1 = request.getParameterValues("disid");

        for (int i=0; i<id1.length; i++){
            int id = Integer.parseInt(id1[i]);
            boolean b = dateService.disciplineDelete(id);
        }

        List<Discipline> disciplines = dateService.getAllDisciplines();

        request.setAttribute("disciplines", disciplines);
        request.setAttribute("page", "/pages/disciplines-list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}