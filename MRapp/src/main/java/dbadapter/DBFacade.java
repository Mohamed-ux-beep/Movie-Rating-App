package dbadapter;

import interfaces.Idatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;







// have a look on D3  to implement DBFacade
public class DBFacade implements Idatabase {
    private static DBFacade instance;

    /**
     * Constructor which loads the corresponding driver for the chosen database type
     */
    private DBFacade() {
        try {
            Class.forName("com." + Configuration.getType() + ".cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implementation of the Singleton pattern.
     *
     * @return
     */
    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }

        return instance;
    }

    public static void setInstance(DBFacade dbfacade) {
        instance = dbfacade;
    }
     
    public boolean SignIn (String name, String password) {
    	boolean User;
    	  String sqlQueryname="SELECT * FROM INFO WHERE NAME=? and password=?";
         
        
    	  String url = "jdbc:mysql://127.0.0.1:3306/mrapp?user=root&password=" + Configuration.getPassword() 
     		+ "&useUnicode=true&characterEncoding=UTF-8"
     		+ "&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
                    try (Connection connection = DriverManager.getConnection(url)){
          	
          	try(PreparedStatement psSelect = connection.prepareStatement(sqlQueryname)){
          		psSelect.setString(1, name);
      			psSelect.setString(2, password);
				    ResultSet QueryRES = psSelect.executeQuery();
				    // if db  empty
				    if ( QueryRES.last() ==false ) {
	
				    	return false;
				    }
          		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return true;
          		

    	
    }
    
    
    @Override
    	public Info Registering(String name, String Email,int Age,int password) throws SQLException {
        	
        	Info info=null;
        	
            // Declare necessary SQL queries.
            String sqlQueryname="SELECT * FROM INFO WHERE NAME=?;";
            String sqlInsertInfo="INSERT INTO INFO(name,Email,Age,password) VALUES(?,?,?,?);";
          
            try (Connection connection = DriverManager.getConnection(
    			"jdbc:" + Configuration.getType() + "://"
                        + Configuration.getServer() + ":"
    			     	+ Configuration.getPort() + "/" 
    					+ Configuration.getDatabase()
    					,Configuration.getUser(), Configuration.getPassword())){

            	try(
            	   
    			   PreparedStatement psSelect = connection.prepareStatement(sqlQueryname);
    		       PreparedStatement psInsert = connection.prepareStatement(sqlInsertInfo)){
            		
         
    				psSelect.setString(1, name);
    				 
    			   ResultSet QueryRES = psSelect.executeQuery();
//   QueryRES: carries a set of user data , if it empty so the user name is unique, if not it will reject registration 
//   QueryRES.next()
    			   if( (QueryRES.next() == false)  && Age >=18) {
    				info = new Info(name, Email,Age,password);

    				// Insert new User if the user name is unique and his age >= 18
    				psInsert.setString(1, info.getName());
    				psInsert.setString(2, info.getEmail());
    				psInsert.setInt(3, info.getAge());
    				psInsert.setInt(4, info.getPassword());
    				psInsert.executeUpdate();
            		  
    		       System.out.println(psInsert+ "COMPLETED");
    				return info;}
    				
            	}catch (SQLException e) {
    				e.printStackTrace();}
    				}catch (SQLException e) {
    					e.printStackTrace();}
    		
         
    		return info;


}
    

    @Override
    public Movies AddedMovies(String title,String director,String originalpublishingDate, String actors) {
      Movies movie=null;
     	
      // Declare necessary SQL queries.
      String sqlQuerytitle="SELECT * FROM MOVIES WHERE TITLE=?;";
      String sqlInsertMo="INSERT INTO movies(title,director ,originalpublishingDate,actors) VALUES(?,?,?,?);";
      
      //establish connection 
      try (Connection connection = DriverManager.getConnection(
  			"jdbc:" + Configuration.getType() + "://"
                      + Configuration.getServer() + ":"
  			     	+ Configuration.getPort() + "/" 
  					+ Configuration.getDatabase()
  					,Configuration.getUser(), Configuration.getPassword())){
          	try(
          	   
  			   PreparedStatement psSelect = connection.prepareStatement(sqlQuerytitle);
  		       PreparedStatement psInsert = connection.prepareStatement(sqlInsertMo)){
          		

          	
          		
  				psSelect.setString(1, title);
  				 
  			   ResultSet titlers = psSelect.executeQuery();
  		    
  			   if(!(titlers.last())) {
  			      
  			      
  			        movie = new Movies(0,title,director,originalpublishingDate,actors);

  				// Insert new User
  				psInsert.setString(1, movie.getTitle());
  				psInsert.setString(2, movie.getDirector());
  				psInsert.setString(3, originalpublishingDate);
  				psInsert.setString(4, movie.getActors());
  				psInsert.executeUpdate();
  			return movie;
  			}
  				
          	}catch (SQLException e) {
  				e.printStackTrace();}
  				}catch (SQLException e) {
  					e.printStackTrace();}
  		
       
  		return movie;

  
    }

    @Override
    public List<Info> get_Registered() {
        return null;
    }

    @Override
    public List<MovieList> get_Rated() {
        return null;
    }

    @Override
    public MovieList ratingMovie(String movietitle, String Username, int Rate) {
    	MovieList movielist=null;
     	
        // Declare necessary SQL queries.
        String sqlQueryRes="select * from movielist Where movietitle=? and username=? and rate=?;";
        String sqlUpdateRes="update movielist set rate=? where movietitle=? and username=?;";
        //establish connection 
        //Connection and Query
   	   String url = "jdbc:mysql://127.0.0.1:3306/mrapp?user=root&password=" + Configuration.getPassword() 
   		+ "&useUnicode=true&characterEncoding=UTF-8"
   		+ "&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
                  try (Connection connection = DriverManager.getConnection(url)){
            	try(
                   PreparedStatement psSelect = connection.prepareStatement(sqlQueryRes);
    		       PreparedStatement psInsert = connection.prepareStatement(sqlUpdateRes)){
	                 	psSelect.setString(1,movietitle);
	    				psSelect.setString(2,Username);
	    				psSelect.setInt(3, 0);
    				 
	    				ResultSet titlers = psSelect.executeQuery();
    		
    			   if(!(titlers.last())){
    				   return null;}
    			   else {
    				   movielist = new MovieList(movietitle,Username,Rate);

    				// Insert new User
    				psInsert.setInt(1, movielist.getRate());
    				psInsert.setString(2, movielist.getMovietitle());
    				psInsert.setString(3, movielist.getUsername());
    				
    				psInsert.executeUpdate();
    			   }
    			   }catch (SQLException e) {
       				e.printStackTrace();}
    				
            	}catch (SQLException e) {
    					e.printStackTrace();}
                 
         
    		return movielist;
    }

    
    //  show movies in user movie list, rate movie
    @Override
    public List<Movies> get_availableMovieList() {
        List<Movies> movies = new ArrayList();
        String allmoviesInDb= "select * from movies;";
        //Connection and Query
   	 String url = "jdbc:mysql://127.0.0.1:3306/mrapp?user=root&password=" + Configuration.getPassword() 
   		+ "&useUnicode=true&characterEncoding=UTF-8"
   		+ "&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
                  try (Connection connection = DriverManager.getConnection(url)) {
   			try (PreparedStatement psSelect = connection.prepareStatement(allmoviesInDb)) {
        		ResultSet movieTobeShowninRateMovie=psSelect.executeQuery();
        	while(movieTobeShowninRateMovie.next()) {
        		System.out.println(movieTobeShowninRateMovie);
        		Movies movie= new Movies(movieTobeShowninRateMovie.getInt("id"),
        				movieTobeShowninRateMovie.getString("title"),
        				movieTobeShowninRateMovie.getString("director"),
        				movieTobeShowninRateMovie.getString("originalpublishingDate"),
        				movieTobeShowninRateMovie.getString("actors"));
        			movies.add(movie);	
        	}
        	return movies;
        	}
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return movies;
    }

    
    
    // show movie overview
    @Override
    public List<overview> get_availableRatedMovieList() {
           List<overview> Overivewlist = new ArrayList();
    	    // Declare necessary SQL queries.
            String sqlQueryDBM="select * from movies m left join (select movietitle,avg(rate) from movielist group by movietitle)ml on m.title=ml.movietitle;";
           
            //establish connection 
            //Connection and Query
          	 String url = "jdbc:mysql://127.0.0.1:3306/mrapp?user=root&password=" + Configuration.getPassword() 
        		+ "&useUnicode=true&characterEncoding=UTF-8"
        		+ "&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
                       try (Connection connection = DriverManager.getConnection(url)){
                	try(PreparedStatement psSelect = connection.prepareStatement(sqlQueryDBM)){
                		ResultSet MoviesRates = psSelect.executeQuery();
                		while(MoviesRates.next()) {
                			overview ov=new overview(
                			 MoviesRates.getInt("id"),		
                			 MoviesRates.getString("title"),
                			 MoviesRates.getString("director"),
                			 MoviesRates.getString("originalpublishingDate"),
                			 MoviesRates.getString("actors"),
                			 MoviesRates.getDouble("avg(Rate)")); 
                			Overivewlist.add(ov);
	                     
                		}
                		return Overivewlist;
                		}catch (SQLException e) {
           				e.printStackTrace();}
            }catch (SQLException e) {
        					e.printStackTrace();}
			return Overivewlist;
		
	
    }
}