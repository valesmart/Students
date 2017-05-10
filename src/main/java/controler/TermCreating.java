package controler;

import constants.Constants;
import entity.Discipline;
import entity.Term;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name="TermCreating", urlPatterns = "/term-creating")
public class TermCreating extends AbstractServlet {

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Discipline> disciplines = dateService.getAllDisciplines();

        request.setAttribute("disciplines", disciplines);
        request.setAttribute("page", "/pages/term-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Term term = new Term();

        try {

           validateRequest(
                  request.getParameter("semestr"), request.getParameter("choice")
            );

            term.setDuration(Integer.parseInt(request.getParameter("semestr")));
            int duration = term.getDuration();

            System.out.println(duration);
            String[] idDis = request.getParameterValues("choice");

            int idTerm = dateService.createTerm(term);

            for (int i = 0; i < idDis.length; i++) {
                int idDiscipline = Integer.parseInt(idDis[i]);

                boolean b = dateService.createDisByTerm(idTerm, idDiscipline);

                request.setAttribute(Constants.VALIDATION_MESSAGE, "successTermCreate");
            }
        } catch (Exception e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());
            e.printStackTrace();
        }


        List<Discipline> disciplines = dateService.getAllDisciplines();

        request.setAttribute("disciplines", disciplines);
        request.setAttribute("page", "/pages/term-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }



    public void validateRequest(String duration, String disciplines)
            throws WebtasksDataException {
        if (StringUtils.isBlank(duration)) {
            throw new WebtasksDataException("duration");
        }
        if (StringUtils.isBlank(disciplines)) {
            throw new WebtasksDataException("disciplines");
        }
    }
}