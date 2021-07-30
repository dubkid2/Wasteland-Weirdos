
public class Character {
	
	
	private String Race;
	private String Size;
	private int[] Stats;
	
	
	
	void Character() {
		this.Race=null;
		this.Size=null;
		this.Stats= new int[4];
		
	}
	
	
	void SetRace(String NewRace) {
		Race= NewRace;
		System.out.print("The Caracters race has been set to: " + Race);
	}
		

}
