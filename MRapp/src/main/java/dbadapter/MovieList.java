
package dbadapter;


public class MovieList {

    //attributes:
    private String movietitle;
    private String Username;
    private int Rate;

    //Contractor:

    public MovieList(String movietitle, String username, int rate) {
    	this.movietitle = movietitle;
        this.Username = username;
        this.Rate = rate;
    }

    //getters and setters:


    public String getMovietitle() {
        return movietitle;
    }

    public void setmovietitle(String movietitle) {
    	this.movietitle = movietitle;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }
}