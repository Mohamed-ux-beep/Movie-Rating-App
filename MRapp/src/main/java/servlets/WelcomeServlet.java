package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/templates/index.ftl").forward(
					request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		doGet(request, response);}


}