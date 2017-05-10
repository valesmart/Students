package controler;

import constants.Constants;
import entity.Discipline;
import entity.Term;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name="TermModify", urlPatterns = "/term-modify")
public class TermModify extends AbstractServlet {

    static int idTerm;

    public static final Logger LOGGER= Logger.getLogger(TermModify.class);

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Term term = new Term();

        try {
            validateRequest(
                    request.getParameter("termod"), request.getParameter("choice")
            );
            String[] idDis = request.getParameterValues("choice");

            term.setId(idTerm);
            term.setDuration(Integer.parseInt(request.getParameter("termod")));

            boolean termDelete = dateService.deleteTermById(idTerm);
            boolean idTerm = dateService.createModTerm(term);

            for (int i = 0; i < idDis.length; i++) {
                int idDiscipline = Integer.parseInt(idDis[i]);
                System.out.println(idDiscipline);
                boolean b = dateService.createDisByTerm(term.getId(), idDiscipline);
            }

            request.setAttribute(Constants.VALIDATION_MESSAGE, "successTermMod");

        } catch (Exception e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());
            e.printStackTrace();
        }

            List<Discipline> disciplines = dateService.getAllDisciplines();

            request.setAttribute("discipline", disciplines);
            request.setAttribute("term", term);
            request.setAttribute("page", "/pages/term-modify.jsp");
            request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Term term = new Term();
        term.setId(Integer.parseInt(request.getParameter("choice")));
        idTerm=term.getId();
        System.out.println(term.getId());

        Term termDuration = dateService.getTermById(term.getId());

        List<Discipline> disciplines = dateService.getAllDisciplines();

        request.setAttribute("term", termDuration);
        request.setAttribute("discipline", disciplines);
        request.setAttribute("page", "/pages/term-modify.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

        public void validateRequest (String duration, String disciplines)
            throws WebtasksDataException {
            if (StringUtils.isBlank(duration)) {
                throw new WebtasksDataException("duration");
            }
            if (StringUtils.isBlank(disciplines)) {
                throw new WebtasksDataException("disciplines");
            }
        }
}
