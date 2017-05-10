package controler;

import constants.Constants;
import entity.Student;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Валера on 08.03.2017.
 */
@WebServlet(name = "StudentCreatig", urlPatterns = "/student-creating")
public class StudentCreating extends  AbstractServlet {
    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("page", "/pages/student-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");

        Student student = new Student();

        try {
            validateRequest(  //проверка на заполненые поля, проверка каждой переменной на пустоту
                    request.getParameter("name"),
                    request.getParameter("secondname"),
                    request.getParameter("group")
            );

            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("secondname"));
            student.setDate(textFormat.parse(request.getParameter("data")));
            student.setGroup(request.getParameter("group"));
            System.out.println(student.toString());

            boolean b = dateService.createStudent(student);

            request.setAttribute(Constants.VALIDATION_MESSAGE, "successcreate");

        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute(Constants.VALIDATION_MESSAGE, "date");
        }  catch (WebtasksDataException e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE, e.getMessage());// вывод сообщения при ошибке
        e.printStackTrace();
    }

        request.setAttribute("page", "/pages/student-creating.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

        public void validateRequest(String name, String surname, String group)
            throws WebtasksDataException {
            if (StringUtils.isBlank(name)) {
                throw new WebtasksDataException("name");
            }
            if (StringUtils.isBlank(surname)) {
                throw new WebtasksDataException("surname");
            }
            if (StringUtils.isBlank(group)) {
                throw new WebtasksDataException("group");
            }
        }
}
