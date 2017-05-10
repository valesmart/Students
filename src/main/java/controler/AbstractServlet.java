package controler;

/*import database.DataService;*/

import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet extends HttpServlet {

    DataService dateService = new DataService();

	protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doGetHandler(req, resp);

		} catch (Throwable e) {
			System.out.println("Application can't fulfil this request");
			e.printStackTrace();

		}

	}

	protected abstract void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			doPostHandler(req, resp);

		} catch (Throwable e) {
			System.out.println("Application can't fulfil this request");
			e.printStackTrace();
		}

	}

	protected abstract void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
