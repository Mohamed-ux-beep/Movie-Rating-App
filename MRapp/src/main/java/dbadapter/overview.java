package dbadapter;

public class overview extends Movies{

	private double average;

	public overview(int id, String title, String director, String originalpublishingDate2, String actors, double average) {
		super(id, title, director, originalpublishingDate2, actors);
		this.average=average;
		
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}


}
