

package filters;

import constants.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Валера on 20.03.2017.
 */

public class AuthenticationFilter extends AbstractWebtasksFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


 HttpSession session = request.getSession();
        String auth = (String) session.getAttribute(Constants.CURRENT_SESSION_ACCOUNT);

        if (auth == null){
            if (request.getRequestURI().endsWith(".css")){//пропускание файла
                chain.doFilter(request, response);
                return;
            }
            if (request.getRequestURI().endsWith(".js")){
                chain.doFilter(request, response);
                return;
            }
            if (request.getRequestURI().endsWith("/login")){
                chain.doFilter(request, response);
                return;
            }

            response.sendRedirect("/login");
        }else{
            chain.doFilter(request, response);
        }


    }
}