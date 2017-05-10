package controler;

import constants.Constants;
import entity.Discipline;
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
@WebServlet(name="TermsList", urlPatterns = "/terms-list")
public class TermsList extends AbstractServlet {
    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Term> terms = dateService.getAllTerms();

        request.setAttribute("terms", terms);
        request.setAttribute("page", "/pages/terms-list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("termDelete"));
        Term term = new Term();

        if (request.getParameter("termDelete")!=null){
            term.setId(Integer.parseInt(request.getParameter("choice")));
            int idTerm = term.getId();

            boolean termDelete = dateService.deleteTermById(idTerm);

            request.setAttribute(Constants.VALIDATION_MESSAGE, "succsemestrdelete");
        }else {
            term.setId(Integer.parseInt(request.getParameter("choice")));
            int idTerm = term.getId();
            System.out.println(idTerm);

            Term termDuration = dateService.getTermById(idTerm);

            List<Discipline> disciplineByTerm = dateService.getDisciplinesByTerm(idTerm);

            request.setAttribute("discipline", disciplineByTerm);
            request.setAttribute("term", termDuration);
        }

        List<Term> terms = dateService.getAllTerms();

        request.setAttribute("terms", terms);
        request.setAttribute("page", "/pages/terms-list.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
