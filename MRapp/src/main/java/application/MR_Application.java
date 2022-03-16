package application;



import dbadapter.DBFacade;
import dbadapter.Info;
import dbadapter.MovieList;
import dbadapter.Movies;
import dbadapter.overview;
import interfaces.PCmds;
import interfaces.UCmds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MR_Application implements UCmds, PCmds {
    private static MR_Application instance;
    /**
     * Implementation of the Singleton pattern.
     *
     * @return
     */
    public static MR_Application getInstance() {
        if (instance == null) {
            instance = new MR_Application();
        }

        return instance;
    }
    /**
     * Forwards a new user to the database.
     *
     * param name
     * param email
     * param age

     */
    //register process
    @Override
    public Info registerNewUser(String name, String Email, int Age, int password) {
        // Create result object
        Info okfail = null;
        // Parse inputs to correct data types
        try{
            okfail =DBFacade.getInstance().Registering(name,Email,Age,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return okfail;
       
    }
    // SIGN IN PROCESS
    @Override
    public boolean SignIn (String name, String password) {
    	// Create result object
    	boolean User =false;
    	try{
    		User =DBFacade.getInstance().SignIn(name,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    	return User;
    }
    
    // adding new movie 

    @Override
    public Movies MakeAddingMovie(String title, String director, String originalpublishingDate, String actors) {
        // Create result object
    	Movies okfail = null;
        // Parse inputs to correct data types
        try{
            okfail =DBFacade.getInstance().AddedMovies(title, director, originalpublishingDate, actors);
        }catch (Exception e){
            e.printStackTrace();
        }
        return okfail;
    }
    
    // Rate movie process

    @Override
    public MovieList MakeRateMovie(String movietitle,String Username, int Rate) {
        // Create result object
    	MovieList okfail = null;
        // Parse inputs to correct data types
        try{
            okfail =DBFacade.getInstance().ratingMovie(movietitle, Username, Rate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return okfail;
    }
    

  //Show movie exist in user's movie list in rate movie page
    public List<Movies> getAvilableMovieList() {
    	// Create result object
    	 List<Movies> res = new ArrayList();
        // Parse inputs to correct datatypes
        try{
            res =DBFacade.getInstance().get_availableMovieList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
    //Show movie overview
    @Override
    public List<overview> MakeAccessMovieList() {
    	// Create result object
    	 List<overview> res = new ArrayList();
        // Parse inputs to correct datatypes
        try{
            res =DBFacade.getInstance().get_availableRatedMovieList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
    
}