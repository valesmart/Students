package controler;

import controler.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomePageController", urlPatterns = {""})
public class HomePageController extends AbstractServlet {

	@Override
	protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", "/pages/home.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}