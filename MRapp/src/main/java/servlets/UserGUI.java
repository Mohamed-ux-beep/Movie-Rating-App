package servlets;


import application.MR_Application;

import dbadapter.Movies;
import dbadapter.overview;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String Username;

	
	


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

		// Set pagetitle and navtype

	// Show page of sign in	
  if (request.getParameter("action").equals("signIn")) {
	  
 
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebappUser.ftl").forward(
					request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
  // Show page if Add movie
  else if (request.getParameter("action").equals("AddMovie")) {
	  
	  
		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/addmovieform.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
  
  //Show page of Rate movie
  else if (request.getParameter("action").equals("RateMovie")) {
	   

	  // Call application to request the results
	  List<Movies> availableMovielist = new ArrayList();
		try {
			availableMovielist = MR_Application.getInstance().getAvilableMovieList();
            
			request.setAttribute("Movies", availableMovielist);
            	request.getRequestDispatcher("/templates/MovieRate.ftl").forward(request, response);
            
			// Dispatch results to template engine
			
		

		}catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
  
  //Show page of movie overview
  else if (request.getParameter("action").equals("MovieOverview")) {
	  
	    List<overview> ov = new ArrayList();
	    
		// Dispatch request to template engine
		try {
			ov=MR_Application.getInstance().MakeAccessMovieList();
			request.setAttribute("moviesOverview", ov);
			request.getRequestDispatcher("/templates/MovieShowOverview.ftl").forward(
					request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
  // about
  else if (request.getParameter("action").equals("about")) {
	  
		// Dispatch request to template engine
		try {

			request.getRequestDispatcher("/templates/About.ftl").forward(
					request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("errormessage",
					"Template error: please contact the administrator");
			e.printStackTrace();
		}
	}
	 
	}
	
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
   
    	// Sign In process "take user inputs and forward it to DB"
     if (request.getParameter("action").equals("signIn")) {
    	  Username= request.getParameter("uname");
    	 String password = request.getParameter("psw");
    	 if((MR_Application.getInstance().SignIn(Username,password))==true) {
    			// Dispatch request to template engine
    			try {
    				request.getRequestDispatcher("/templates/header.ftl").forward(
    						request, response);
    			} catch (ServletException | IOException e) {
    				request.setAttribute("errormessage",
    						"Template error: please contact the administrator");
    				e.printStackTrace();
    			}
    		 
    	 }else {
    		  try {
              	//set request attributes "take user inputs and forward it to DB"
                  request.setAttribute("pagetitle", "failed");
                  request.setAttribute("message", "Please try again");
                  // Dispatch request to template engine
                  request.getRequestDispatcher("/templates/failedLogin.ftl").forward(request, response);
              } catch (ServletException | IOException e) {
                  e.printStackTrace();
              }
    	 }
     }	
    
     
     // add new movie to data base "take user inputs and forward it to DB"
    else if (request.getParameter("action").equals("AddMovie")) {
    	// Append parameter of request
        String title = request.getParameter("movietitle");
        String director= request.getParameter("director");
        String originalpublishingDate= request.getParameter("originalpublishingDate");
        String actors=request.getParameter("actors");
        if (MR_Application.getInstance().MakeAddingMovie(title,director,originalpublishingDate,actors) != null) {
            try {
                //set request attributes
                request.setAttribute("pagetitle", "Add Movie Process succeed");
                request.setAttribute("message", "you Added Movie successfully");
                // Dispatch request to template engine
                request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            // else means there is user in data base with the same data
        } else {
            
            try {
            	//set request attributes
                request.setAttribute("pagetitle", "Add Movie Process failed");
                request.setAttribute("message", "the Add Movie Process failed,you entered a not vaild data or the movie is already exist");
                // Dispatch request to template engine
                request.getRequestDispatcher("/templates/failRepresentation.ftl").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        
        }
        }    
     // Rate Movie "take user inputs and forward it to DB"
    else if (request.getParameter("action").equals("RateMovie")){
    	
		
    	
    	// Append parameter of request
        String movietitle = request.getParameter("movietitle");
        int Rate= Integer.parseInt(request.getParameter("Rate"));

        if (MR_Application.getInstance().MakeRateMovie(movietitle, this.Username, Rate) != null) {
            try {
                //set request attributes
                request.setAttribute("pagetitle", "Rate Movie Process succeed");
                request.setAttribute("message", "you Rated Movie successfully");
                // Dispatch request to template engine
                request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            // else means there is user in data base with the same data
        } else {
            
            try {
            	//set request attributes
                request.setAttribute("pagetitle", "Rate Movie Process failed");
                request.setAttribute("message", "the Rating Movie Process failed,you entered a not vaild data or you rated the movie already");
                // Dispatch request to template engine
                request.getRequestDispatcher("/templates/failRepresentation.ftl").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        
        }
    }
     
     // Movie Overview process
    else if (request.getParameter("action").equals("MovieOverview")) {

    
    }
    
    else
    {doGet(request,response);} 
    }

    
	
}