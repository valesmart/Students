package controler;
import constants.Constants;
import controler.AbstractServlet;
import entity.Discipline;
import entity.Student;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name = "DisciplineModify", urlPatterns = {"/discipline-modify"})
public class DisciplineModify extends AbstractServlet {

    private static int id;
    public static final Logger LOGGER= Logger.getLogger(DisciplineModify.class);

    Discipline discipline = new Discipline();

    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id1 = request.getParameter("disid");
        int id2 = Integer.parseInt(id1);
        discipline.setId1(id2);
        System.out.println(id2);
        LOGGER.debug("id");

        Discipline disciplineId = dateService.getDisciplineId(discipline.getId1());

        id = discipline.getId1();

        request.setAttribute("discipline", disciplineId);
        request.setAttribute("page", "/pages/discipline-modify.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Discipline discipline = new Discipline();

        try {
            validateRequest(request.getParameter("disciplinename"));

            discipline.setDisciplinename(request.getParameter("disciplinename"));
            discipline.setId1(id);
            System.out.println(discipline.toString());

            boolean b = dateService.modifyDiscipline(discipline);

            request.setAttribute(Constants.VALIDATION_MESSAGE, "success");
        } catch (Exception e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());
            e.printStackTrace();
        }

        request.setAttribute("page", "/pages/discipline-modify.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    public void validateRequest(String disciplinename)
            throws WebtasksDataException {
        if (StringUtils.isBlank(disciplinename)) {
            throw new WebtasksDataException("disciplinename");
        }
    }

}
