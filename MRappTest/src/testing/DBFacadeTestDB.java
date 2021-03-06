package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dbadapter.Configuration;
import dbadapter.DBFacade;
import dbadapter.Info;
import dbadapter.MovieList;
import dbadapter.Movies;
import junit.framework.TestCase;

/**
 * Testing our DBFacade.
 * 
 * @author swe.uni-due.de
 *
 */
public class DBFacadeTestDB extends TestCase {
	private Info testUser;
	private Movies testmovie;
	private MovieList testmovielist;
	

	/**
	 * Preparing classes with static methods
	 */
	@Before
	public void setUp() {
		// new user to be tested
		testUser= new Info("Ahmed","Ahmed@gamil.com",20,123);
		testmovie= new Movies (1,"3 idiots","James Cameron","2009-12-18","sam Worthington, Zoe Saldana");
		testmovielist= new MovieList ("3 idiots","Ahmed",0);
		

		// SQL statements
		String sqlCleanDB = "DROP TABLE IF EXISTS Info,Movies,MovieList";
		String sqlCreateTableInfo="create table info (name varchar(50),Email varchar(50),Age int,password int);";
	    String sqlCreateTableMovies ="create table movies (id int,title varchar(50),director varchar(50), originalpublishingDate varchar(50),actors varchar(500));";
	    String sqlCreateTableMovieList="create table movielist (movietitle varchar(50),username varchar(50),rate int);";
	    String sqlInsertUser = "insert into info values(?,?,?,?)";
	    String sqlInsertMovie= "insert into movies values (?,?,?,?,?);";
	    String sqlInsertRate ="insert into movielist values (?,?,?);";
	
		// Perform database updates
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
			try (PreparedStatement psCreateInfo = connection.prepareStatement(sqlCreateTableInfo)) {
				psCreateInfo.executeUpdate();
			}
			try (PreparedStatement psCreateMovies = connection.prepareStatement(sqlCreateTableMovies)) {
				psCreateMovies.executeUpdate();
			}
			try (PreparedStatement psCreateMovieList = connection.prepareStatement(sqlCreateTableMovieList)) {
				psCreateMovieList.executeUpdate();
			}
			try (PreparedStatement psInsertUser = connection.prepareStatement(sqlInsertUser)) {
				psInsertUser.setString(1,testUser.getName() );
				psInsertUser.setString(2,testUser.getEmail());
				psInsertUser.setInt(3,testUser.getAge() );
				psInsertUser.setInt(4,testUser.getPassword());
				psInsertUser.executeUpdate();
			}
			try (PreparedStatement psInsertMovie = connection.prepareStatement(sqlInsertMovie)) {
				psInsertMovie.setInt(1, testmovie.getId());
				psInsertMovie.setString(2, testmovie.getTitle());
				psInsertMovie.setString(3, testmovie.getDirector());
				psInsertMovie.setString(4, testmovie.getOriginalpublishingDate());
				psInsertMovie.setString(5,testmovie.getActors());
				psInsertMovie.executeUpdate();
	     	} 
			try (PreparedStatement psInsertRate = connection.prepareStatement(sqlInsertRate)) {
				psInsertRate.setString(1,testmovielist.getMovietitle());
				psInsertRate.setString(2,testmovielist.getUsername());
				psInsertRate.setInt(3,testmovielist.getRate());
				psInsertRate.executeUpdate();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Testing registerNewUser with  new user data.
	 * @throws SQLException 
	 */
	@Test
	public void testRegisterNewUser() throws SQLException {
		
		//
			Info info = DBFacade.getInstance().Registering("Islam","Isalm@gmail.com",20 ,13);
		// Verify return values
		assertTrue(info !=null);
 	}

	/**
	 * Testing registerNewUser with the same user data. null means that the user will not be added because he is already exist
	 * @throws SQLException 
	 */
	@Test
	public void testRegisterNewUserEmpty() throws SQLException {
		//
		Info info = DBFacade.getInstance().Registering("Ahmed","Ahmed@gmail.com",20 ,12);
		// Verify return values
		assertTrue(info == null);

	}
	
	// add new Movie 
	@Test 
	public void testAddedMovies() throws SQLException {
		Movies movie = DBFacade.getInstance().AddedMovies("Titanic","James Cameron","1997-11-01","Leonardo Dicaprio, Billy Zane");
		assertTrue(movie !=null);
	}
	
	// add existed movie
	@Test 
	public void testAddedMoviesEmpty() throws SQLException {
		Movies movie = DBFacade.getInstance().AddedMovies("3 idiots","James Cameron","2009-12-18","sam Worthington, Zoe Saldana");
		assertTrue(movie ==null);
	}
	
	// add new rate for an movie after added it to the movie list
	@Test 
	public void testratingMovie() throws SQLException {
		MovieList movielist = DBFacade.getInstance().ratingMovie("3 idiots","Ahmed", 2);
		assertTrue(movielist !=null);
	}

	// add new rate for an movie after added it to the movie list
	/*@Test 
	public void testratingMovieEmpty() throws SQLException {
		MovieList movielist = DBFacade.getInstance().ratingMovie("3 idiots","Ahmed", 1);
		assertTrue(movielist == null);
	}*/

	
	
	/**
	 * Rest database
	 */

	@After
	public void tearDown() {

		// SQL statements
		String sqlCleanDB = "DROP TABLE IF EXISTS info,movies,movielist;";

		// Perform database updates
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
