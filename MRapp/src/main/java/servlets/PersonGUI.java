package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MR_Application;

public class PersonGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the register form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		
		request.setAttribute("pagetitle", "register user");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageRegister.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Contains handling of register new user call
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {



        if (request.getParameter("action").equals("Register")) {
               
           // Append parameter of request
           String name = request.getParameter("name");
           String email= request.getParameter("email");
           int Age= Integer.parseInt(request.getParameter("Age"));
           int password=  Integer.parseInt(request.getParameter("password"));
        
           // decide weather add new user were success or not 
           // if condition will the 0 or sth-> info (object of User data)"if 0 then it fail, if not then it succeed"
   
          
        	if (MR_Application.getInstance().registerNewUser(name,email,Age,password) != null) {
                try {
                    //set request attributes
                    request.setAttribute("pagetitle", "Registration Process succeed");
                    request.setAttribute("message", "you Registered successfully");
                    // Dispatch request to template engine
                    request.getRequestDispatcher("/templates/okRepresentationRegister.ftl").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                // else means there is user in data base with the same data
            } else {
                
                try {
                	//set request attributes
                    request.setAttribute("pagetitle", "Registration Process failed");
                    request.setAttribute("message", "the Registration Process failed, Please enter a unique name and age >= 18");
                    // Dispatch request to template engine
                    request.getRequestDispatcher("/templates/failRepresentationRegister.ftl").forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

        else
            doGet(request,response);
    }

}