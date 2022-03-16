package interfaces;


import dbadapter.Info;
import dbadapter.MovieList;
import dbadapter.Movies;
import dbadapter.overview;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface UCmds {
	//Sign In 
	public boolean SignIn (String name, String password);
	
    //Add movie in data base
    //movie : Success, fail
    public Movies MakeAddingMovie(String title, String director,String originalpublishingDate, String actors);


    public MovieList MakeRateMovie(String movietitle, String Username, int Rate);

    //Movie Overview Show
    public List<overview> MakeAccessMovieList();

}