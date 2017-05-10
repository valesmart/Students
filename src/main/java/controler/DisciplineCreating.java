package controler;

import constants.Constants;
import entity.Discipline;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name = "DisciplineCreating", urlPatterns = {"/discipline-creating"})
public class DisciplineCreating extends  AbstractServlet {

    public static final Logger LOGGER= Logger.getLogger(DisciplineCreating.class);

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.debug("id");

        request.setAttribute("page", "/pages/discipline-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Discipline discipline = new Discipline();

        try {
            validateRequest(request.getParameter("disciplinename"));
            discipline.setDisciplinename(request.getParameter("disciplinename"));
            System.out.println(discipline.toString());

            boolean b = dateService.createDiscipline(discipline);

            request.setAttribute(Constants.VALIDATION_MESSAGE, "success");
        } catch (Exception e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());
            e.printStackTrace();
        }

        request.setAttribute("page", "/pages/discipline-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    public void validateRequest(String disciplinename)
            throws WebtasksDataException {
        if (StringUtils.isBlank(disciplinename)) {
            throw new WebtasksDataException("disciplinename");
        }
    }
}
