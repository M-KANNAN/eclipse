package CricketApplication;

public class PlayerPojo {
	
	private String name;
	private int score;
	private int ballFaced;
	private int smashedFours;
	private int smashedSixers;
	private boolean availableStatus;
	private boolean wicketStatus;
	private int ballsBowled;
	private int runGivenInBowling;
	private int wicketTaken;
	
	
	public int getWicketTaken() {
		return wicketTaken;
	}
	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}
	public int getballsBowled() {
		return ballsBowled;
	}
	public void setballsBowled(int oversBowled) {
		this.ballsBowled = oversBowled;
	}
	public int getRunGivenInBowling() {
		return runGivenInBowling;
	}
	public void setRunGivenInBowling(int runGivenInBowling) {
		this.runGivenInBowling = runGivenInBowling;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBallFaced() {
		return ballFaced;
	}
	public void setBallFaced(int ballFaced) {
		this.ballFaced = ballFaced;
	}
	public int getSmashedFours() {
		return smashedFours;
	}
	public void setSmashedFours(int smashedFours) {
		this.smashedFours = smashedFours;
	}
	public int getSmashedSixers() {
		return smashedSixers;
	}
	public void setSmashedSixers(int smashedSixers) {
		this.smashedSixers = smashedSixers;
	}
	public boolean getAvailableStatus() {
		return availableStatus;
	}
	public void setAvailableStatus(boolean availableStatus) {
		this.availableStatus = availableStatus;
	}
	public boolean getWicketStatus() {
		return wicketStatus;
	}
	public void setWicketStatus(boolean wicketStatus) {
		this.wicketStatus = wicketStatus;
	}
	

	
	

}
