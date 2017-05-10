package controler;

import constants.Constants;
import controler.AbstractServlet;
import entity.Account;
import entity.Role;
import exeptions.WebtasksDataException;
import org.apache.commons.lang.StringUtils;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Валера on 06.04.2017.
 */

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends AbstractServlet {
    @Override
    protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Role> roles = dateService.getRoles();

        request.getSession().setAttribute("roles", roles);
        System.out.println(roles);

        request.setAttribute(Constants.VALIDATION_MESSAGE_TITLE, "login");
        request.setAttribute("page", "/pages/login.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        int idRole = Integer.parseInt(request.getParameter("role"));

        try {
            validateRequest(login, password);

            LoginService loginService = new LoginService();
            Account a = loginService.login(dateService, login, password, idRole);

            String user = a.getLogin();

            request.getSession().setAttribute(Constants.CURRENT_SESSION_ACCOUNT, a);
            request.getSession().setAttribute(Constants.CURRENT_ROLE, idRole);
            request.getSession().setAttribute(Constants.SESSION_USER, user );
            request.getSession().setAttribute(Constants.CURRENT_SESSION_ACCOUNT, "on" );

            response.sendRedirect("/");

        } catch (WebtasksDataException e) {
            request.setAttribute(Constants.VALIDATION_MESSAGE,
                    e.getMessage());
            doGetHandler(request, response);
        }

    }

    protected void validateRequest(String username, String password)
            throws WebtasksDataException {
        if (StringUtils.isBlank(username)) {
            throw new WebtasksDataException("username");
        }
        if (StringUtils.isBlank(password)) throw new WebtasksDataException("password");
    }
}

