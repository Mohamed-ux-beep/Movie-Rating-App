package interfaces;

import dbadapter.Info;
import dbadapter.MovieList;
import dbadapter.Movies;
import dbadapter.overview;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface Idatabase {
	//Sign In
	public boolean SignIn (String name, String password);
	
   // Info : Accepted, Rejected
    public Info Registering(String name, String Email, int Age, int password) throws SQLException;

    //movies: success, fail
    public Movies AddedMovies(String title, String director, String originalpublishingDate,String actors);

    //List<Info> : list of registered users
    public List<Info> get_Registered();

    //List<MovieList> : list of all rated movies
    public List<MovieList> get_Rated();

    //MovieList: sucess, fail
    public MovieList ratingMovie(String movietitle,String Username, int Rate);

    //availableMovieList in pdf means all movies exist , therefore we used Movies as return data type
    public List<Movies> get_availableMovieList();

    //availableRatedMovieList in pdf means: return all rated movies , that is why we put MovieList as return data type
    public List<overview> get_availableRatedMovieList();
}