package controler;

import controler.AbstractServlet;
import database.DataService;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "StudentList", urlPatterns = {"/student list"})
public class StudentList extends AbstractServlet {

	@Override
	protected void doGetHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Student> students = dateService.getAllStudents();

			request.setAttribute("students", students); //сначала переменная потом значение
			request.setAttribute("page", "/pages/student list.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		}

	@Override
	protected void doPostHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}