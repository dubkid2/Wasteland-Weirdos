
public class Character {
	
	private String Race;
	private String Body;
	private String Brain;
	private String Size;
	private String Blood;
	private String Bionics;
	private int[] Stats;
	
	private static final int Strength = 0;
	private static final int Dex = 1;
	private static final int Willpower = 2;
	private static final int Intellect = 3;
	private static final int Constitution = 4;
	private static final int Charisma = 5;


	
	
	
	Character() {
		this.Race=null;
		this.Size=null;
		this.Brain=null;
		this.Stats= new int[6];
		for(int i=0; i<6; i++) {
			Stats[i]=5;
		}
		
	}
	
	
	void SetRace(String NewRace) {
		Race= NewRace;
		
		
		switch(Race) {
		case "Red Elves":
			Stats[Strength]-=1;
			Stats[Constitution]-=1;
			Stats[Dex]+=2;
			Body="Elf";
			break;
			
		case "White Elves":
			Stats[Strength]-=1;
			Stats[Constitution]-=1;
			Stats[Dex]+=2;
			Body="Elf";
			break;
			
		case "Green Elves":
			Stats[Strength]-=1;
			Stats[Constitution]-=1;
			Stats[Dex]+=2;
			Body="Elf";
			break;
			
		case "Grey Elves":
			Stats[Strength]-=1;
			Stats[Constitution]-=1;
			Stats[Dex]+=2;
			Body="Elf";
			break;
			
		case "Shialonians":
			Race="Green Shialonian";
			Body="Shialonian";
			break;
			
		case "Shialonians ":
			Race="Red Shialonian";
			Body="Shialonian";
			break;
			
		case "Orcs":
			Stats[Strength]+=2;
			Stats[Dex]-=1;
			Stats[Constitution]-=1;
			Body="Orc";
			break;
			
		case "Dwarves":
			Body="Dwarf";
			Stats[Strength]+=2;
			Stats[Dex]-=3;
			Stats[Constitution]+=2;
			break;
			
		case "Gnome":
			Body="Gnome";
			Stats[Strength]-=3;
			Stats[Constitution]-=2;
			Stats[Dex]+=4;
			break;
			
		case "Humans":
			Body="Human";
			break;
			
		default:
			Body=Race;
		
		}
			
	}
	
	void SetBrain(String NewBrain) {	
		Brain=NewBrain;
		
		switch(Brain) {
		case "Red Elves":
			Stats[Intellect]+=2;
			Stats[Charisma]+=1;
			Stats[Willpower]-=1;
			Brain="Elf";
			break;
			
		case "White Elves":
			Stats[Intellect]+=2;
			Stats[Charisma]+=1;
			Stats[Willpower]-=1;
			Brain="Elf";
			break;
			
		case "Green Elves":
			Stats[Intellect]+=2;
			Stats[Charisma]+=1;
			Stats[Willpower]-=1;
			Brain="Elf";
			break;
			
		case "Grey Elves":
			Stats[Intellect]+=2;
			Stats[Charisma]+=1;
			Stats[Willpower]-=1;
			Brain="Elf";
			break;
			
		case "Shialonians":
			Race="Green Shialonian";
			Brain="Shialonian";
			break;
			
		case "Shialonians ":
			Race="Red Shialonian";
			Brain="Shialonian";
			break;
			
		case "Orcs":
			Stats[Willpower]+=2;
			Stats[Intellect]-=2;
			Brain="Orc";
			break;
			
		case "Dwarves":
			Brain="Dwarf";
			Stats[Willpower]+=3;
			Stats[Charisma]-=2;
			break;
			
		case "Gnome":
			Brain="Gnome";
			Stats[Intellect]+=2;
			Stats[Willpower]-=2;
			Stats[Charisma]+=1;
			break;
			
		case "Humans":
			Brain="Human";
			break;
		
		
		}
		
		System.out.print("The Characters race has been set to: " + Body + " with a " + Brain + " brain");
	}
	
	int GetStrength(){
		return Stats[Strength];
	}
	
	int GetDex() {
		return Stats[Dex];
	}
	
	int GetWill() {
		return Stats[Willpower];
	}
	
	int GetInt() {
		return Stats[Intellect];
	}
	
	int GetCon() {
		return Stats[Constitution];
	}
	
	int GetChar() {
		return Stats[Charisma];
	}
	String GetBody() {
		return this.Body;
	}


	public String GetBrain() {
		
		return Brain;
	}

}
