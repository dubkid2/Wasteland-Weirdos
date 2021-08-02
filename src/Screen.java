

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;


public class Screen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame Window;
	private GraphicsDevice vc;
	private JTextField field;
	private JPanel window;
	private JPanel BR;
	private JPanel Layers;
	private Character player=null;

	
	public Screen() {
		
		GraphicsEnvironment env= GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		vc=env.getDefaultScreenDevice();
	}
	
	public void SetFullscreen(DisplayMode dm, JFrame window) {
		
		
		window.setUndecorated(true);
		window.setResizable(false);
		vc.setFullScreenWindow(window);
		Color BR = new Color(170, 229, 47);
		 window.getContentPane().setBackground(BR);
		 
		window.setVisible(true);	 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
	}
	
	public void SetWindowed(DisplayMode dm, JFrame windows) {
		Window=windows;
		window= new JPanel();
		window.setLayout(null);
		Layers=new JPanel();
		Layers.setLayout(null);
		BR = new JPanel();
		BR.setLayout(null);
		BR.setSize(800, 800);
		DisplayMode windowed= vc.getDisplayMode();
		vc.setFullScreenWindow(windows);
		vc.setDisplayMode(windowed);
		window.setSize(800,800);
		windows.setSize(800, 800);
		Color BRC = new Color(1f, 1f, 1f, 0f);
		window.setBackground(BRC);
		//window.setUndecorated(false);
		windows.setResizable(false);		
		window.setVisible(true);	 
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Layers.add(window);
        Layers.add(BR);
        Layers.setComponentZOrder(window, 0);
        Layers.setComponentZOrder(BR, 1);
        Layers.setSize(800,800);
        windows.add(Layers);

        
		int HsSize=400;
		
		windows.setTitle("Wasteland Weirdos");
		
		JLabel label1= new JLabel("Wasteland Weirdos");
			 label1.setBounds(50,100, 800,75);
			 label1.setVisible(true);
			 label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
			 window.add(label1);
			 
			 
			 
			 ImageIcon image = new ImageIcon("src/hs.jpg");
	        JLabel imageLabel = new JLabel(image); 
	        imageLabel.setBounds(200, 200, HsSize, HsSize);
	        imageLabel.setVisible(true);
	        window.add(imageLabel);
	        

	        field= new JTextField(25);
	        field.addActionListener(this);
	        field.setActionCommand("Text");
	        field.setBounds(50,700, 700, 50);
	        field.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	        field.setVisible(true);
	        BR.add(field);
			BR.setComponentZOrder(field, 0);
			//ImageIcon ButtonBR = new ImageIcon("src/button.jpg");

	        
	        ImageIcon image2 = new ImageIcon("src/background.jpg");
	        JLabel imageLabel2 = new JLabel(image2); 
	        imageLabel2.setBounds(0, 0, 800, 800);
	        imageLabel2.setVisible(true);
	        BR.add(imageLabel2);
			BR.setComponentZOrder(imageLabel2, 1);


			
	        
	        JButton Start = new JButton ("New Game");
	        //Start.setIcon(ButtonBR);
	        Start.setVisible(true);
	        Start.setBounds(200,650, 200, 50);
	        Start.addActionListener(this);
	        window.add(Start);

	        
	        JButton Settings = new JButton ("settings");
	        Settings.setVisible(true);
	        Settings.setBounds(400, 650, 200, 50);
	        Settings.addActionListener(this);
	        window.add(Settings);


	        

			
			
	        Layers.repaint();
	        
	        //field.setText(" ");


	        SimpleAudioPlayer audioPlayer;
			try {
				audioPlayer = new SimpleAudioPlayer();
			    audioPlayer.play();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
		}
	
	

	public DisplayMode GetDM() {
		return vc.getDisplayMode();
	}
	
	

	
	
	private void GoToScreen(int sc) {
		window.removeAll();
		BR.repaint();
		
		switch(sc) {
		
		case 2:
			CharCreator();
			break;
		
		case 3:
			Intro();
			break;
		
		default: System.out.println("You shouldn't be here...");
		}
		
		
		
	}
	
	private JPanel SubRace=null;
	private JLabel RACE_S;
	private JTextArea description;
	private JButton select;
	private JLabel which=null;
	
	private void CharCreator () {
		
		window.removeAll();
		Layers.repaint();

		
        JPanel Races = new JPanel(new GridLayout(0,1));
		Races.setBounds(50, 50, 200, 300);
		if(SubRace!=null) {SubRace.setBounds(0,0,0,0);}
		if(player==null) {description=new JTextArea();}
		description.setBounds(50,450,675,250);
		description.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		Color BRC = new Color(1f, 1f, 1f, 0f);
		description.setBackground(BRC);
		description.setEditable(false);
		description.setText("");
		description.getCaret().deinstall( description );
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		window.add(description);
		window.setComponentZOrder(description, 0);

		
		SubRace= new JPanel(new GridLayout(0,1));
		Layers.add(SubRace);
		Layers.setComponentZOrder(SubRace, 0);
		
		field.setText(" ");
		 
		window.add(Races);
		Races.setVisible(true);

		select= new JButton( "Select");
		select.setBounds( 50,375,200,50);
		select.addActionListener(this);
		if(player==null) {select.setActionCommand("CC_Select");}
		else {select.setActionCommand("CC_Select2");}
		select.setEnabled(false);
		window.add(select);
		
	
		JButton Elves= new JButton("Elf");
		Elves.setVisible(true);
		Elves.setBounds(0,0,200,50);
		Elves.addActionListener(this);
		Elves.setActionCommand("CC_Elves");
		if(player==null) {Elves.setToolTipText("Dexterity +2, Strength -1, Constitution -1");}
		else {Elves.setToolTipText("Intellect +2, Charisma +1, Willpower -1");}
		//Elves.setComponentPopupMenu(Elves_P);
		Races.add(Elves);		

		
		JButton Shialonians= new JButton("Shialonian");
		Shialonians.setVisible(true);
		Shialonians.setBounds(0,50,200,50);
		Shialonians.addActionListener(this);
		Shialonians.setActionCommand("CC_Shialonians");
		Shialonians.setEnabled(false);
		Shialonians.setBackground(Color.gray);
		Races.add(Shialonians);
		
		JButton Orcs= new JButton("Orc");
		Orcs.setVisible(true);
		Orcs.setBounds(0,100,200,50);
		Orcs.addActionListener(this);
		Orcs.setActionCommand("CC_Orcs");
		if(player==null) {Orcs.setToolTipText("strength +2, Dexterity -1, Constitution -1");}
		else {Orcs.setToolTipText("Willpower +2, Intellect -2");}
		Races.add(Orcs);
		
		JButton Dwarves= new JButton("Dwarf");
		Dwarves.setVisible(true);
		Dwarves.setBounds(0,150,200,50);
		Dwarves.addActionListener(this);
		Dwarves.setActionCommand("CC_Dwarves");
		if(player==null) {Dwarves.setToolTipText("Strength +2, Desterity -3, Constitution +2");}
		else {Dwarves.setToolTipText("Willpower +3, Charisma -2");}
		Races.add(Dwarves);
		
		JButton Gnomes= new JButton("Gnome");
		Gnomes.setVisible(true);
		Gnomes.setBounds(0,200,200,50);
		Gnomes.addActionListener(this);
		Gnomes.setActionCommand("CC_Gnomes");
		if(player==null) {Gnomes.setToolTipText("Strength -3, Constitution -2, Dexterity +4");}
		else {Gnomes.setToolTipText("Intellect +2, Willpower -2, Charisma +1");}
		Races.add(Gnomes);
		
		
		JButton Humans= new JButton("Human");
		Humans.setVisible(true);
		Humans.setBounds(0,250,200,50);
		Humans.addActionListener(this);
		Humans.setActionCommand("CC_Humans");
		Humans.setToolTipText("Humans do not affect stats");
		Races.add(Humans);	
		

		if(player==null) {which= new JLabel("Choose Your Body");}
		else {which.setText("Choose Your Brain");}
		 which.setBounds(475,50, 350,50);
		 which.setVisible(true);
		 which.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		 window.add(which);
		 
		JLabel label2= new JLabel("Race Selected:");
		//if(player!=null) {label2.setText("Brain Selected: ");}
		 label2.setBounds(500,100, 350,50);
		 label2.setVisible(true);
		 label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		 window.add(label2);
		 
		if(player==null) { RACE_S= new JLabel("");}
		 RACE_S.setBounds(500,150, 200,50);
		 RACE_S.setVisible(true);
		 RACE_S.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		 RACE_S.setHorizontalAlignment(SwingConstants.CENTER);
		 window.add(RACE_S);
		
		 JPanel Stats = new JPanel(new GridLayout(0,2));
		 Stats.setBackground(BRC);
		 Stats.setBounds(275, 250, 200,200);
		 window.add(Stats);
		 window.setComponentZOrder(Stats, 0);

		 Stats.add(new JLabel("Strength:"));		 
		 JLabel Strength =new JLabel();
		 Stats.add(Strength);
		 if(player==null) {Strength.setText("5");}
		 else {Strength.setText(String.valueOf(player.GetStrength()));}
		 
		 Stats.add(new JLabel("Dexterity:"));
		 JLabel Dex =new JLabel();
		 Stats.add(Dex);
		 if(player==null) {Dex.setText("5");}
		 else {Dex.setText(String.valueOf(player.GetDex()));}
		 
		 Stats.add(new JLabel("Willpower:"));
		 JLabel Will =new JLabel();
		 Stats.add(Will);
		 if(player==null) {Will.setText("5");}
		 else {Will.setText(String.valueOf(player.GetWill()));}
		 
		 Stats.add(new JLabel("Intellect:"));
		 JLabel Int =new JLabel();
		 Stats.add(Int);
		 if(player==null) {Int.setText("5");}
		 else {Int.setText(String.valueOf(player.GetInt()));}
		 
		 Stats.add(new JLabel("Constitution:"));
		 JLabel Con =new JLabel();
		 Stats.add(Con);
		 if(player==null) {Con.setText("5");}
		 else {Con.setText(String.valueOf(player.GetCon()));}
		 
		 Stats.add(new JLabel("Charisma:"));
		 JLabel Charisma =new JLabel();
		 Stats.add(Charisma);
		 if(player==null) {Charisma.setText("5");}
		 else {Charisma.setText(String.valueOf(player.GetChar()));}

		 

		if(player!=null) {
		RACE_S.setText("");
		description.setText("");
		System.out.println("disabling button: " + player.GetBody());
		switch(player.GetBody()) {
		case "Elf":
			Elves.setEnabled(false);
			break;
			
		case "Shialonian":
			Shialonians.setEnabled(false);
			break;
			
		case "Orcs":
			Orcs.setEnabled(false);
			break;
			
		case "Dwarf":
			Dwarves.setEnabled(false);
			break;
			
		case "Human":
			Humans.setEnabled(false);
			break;
		
		case "Gnome":
			Gnomes.setEnabled(false);
		
		}
		
		if(player.GetBrain()!=null) {
			Elves.setEnabled(false);
			Shialonians.setEnabled(false);
			Orcs.setEnabled(false);
			Dwarves.setEnabled(false);
			Humans.setEnabled(false);
			Gnomes.setEnabled(false);
			
			description.setText("You selected a " + player.GetBody() +  " body with a  " + player.GetBrain() + " brain. Do you want to Continue with this character?");
		}
		
		}
		
		else {player = new Character();}
		Layers.repaint();
	}
	
	private void Intro() {
		description.setText("");
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action=arg0.getActionCommand();
		//System.out.println("something happened: " + action);
		if(action.equals("New Game") ) {		System.out.println("The NewGame button has been pressed");
			GoToScreen(2);
		}
		
		if(action.equals("settings") ) {		System.out.println("The Settings button has been pressed");}
		
		if(action.startsWith("CC_")) {	String race=action.substring(3);
			System.out.println("Character race: " +race +" has been selected" );
			
			
			switch(race) {
				
			case "Elves" : 
					SubRace.setBounds(250,50,200,200);
					SubRace.removeAll();
					SubRace.setVisible(true);
					description.setVisible(false);
					RACE_S.setText("");
					select.setEnabled(false);

					JButton Red = new JButton("Red Elves");
					Red.setBounds(0,0,200,50);
					Red.addActionListener(this);
					Red.setActionCommand("CC_SELRed Elves");
					SubRace.add(Red);
					
					JButton Green = new JButton("Green Elves");
					Green.setBounds(0,50,200,50);
					Green.addActionListener(this);
					Green.setActionCommand("CC_SELGreen Elves");
					SubRace.add(Green);	
					
					JButton White = new JButton("White Elves");
					White.setBounds(0,100,200,50);
					White.addActionListener(this);
					White.setActionCommand("CC_SELWhite Elves");
					SubRace.add(White);	
					
					JButton Grey = new JButton("Grey Elves");
					Grey.setBounds(0,150,200,50);
					Grey.addActionListener(this);
					Grey.setActionCommand("CC_SELGrey Elves");
					SubRace.add(Grey);
					
					Layers.repaint();			

				break;
			
			
				
			case "Shialonians":
				SubRace.setBounds(250,100,200,100);
				SubRace.removeAll();
				SubRace.setVisible(true);
				description.setVisible(false);
				RACE_S.setText("");
				select.setEnabled(false);


				JButton SH_Green = new JButton ("Green Shialonian");
				SH_Green.setBounds(0,0,200,50);
				SH_Green.addActionListener(this);
				SH_Green.setActionCommand("CC_SELGreen Shialonian");
				SubRace.add(SH_Green);
				
				JButton SH_Red = new JButton ("Red Shialonian");
				SH_Red.setBounds(0,50,200,50);
				SH_Red.addActionListener(this);
				SH_Red.setActionCommand("CC_SELRed Shialonian");
				SubRace.add(SH_Red);
				
				Layers.repaint();
				
				
				break;
				
			case "Orcs":
				SubRace.setBounds(250,150,200,100);
				SubRace.removeAll();
				SubRace.setVisible(true);
				description.setVisible(false);
				RACE_S.setText("");
				select.setEnabled(false);


				JButton O_Black = new JButton("Black Eyed Orcs");
				O_Black.setBounds(0,0,200,50);
				O_Black.setBackground(Color.GRAY);
				O_Black.setEnabled(false);
				SubRace.add(O_Black);
				
				JButton O_Yellow = new JButton("Yellow Eyed Orcs");
				O_Yellow.setBounds(0,50,200,50);
				O_Yellow.addActionListener(this);
				O_Yellow.setActionCommand("CC_SELOrc");
				SubRace.add(O_Yellow);
				
				
				Layers.repaint();
				
				break;
				
			case "Dwarves":
				SubRace.setBounds(250,200,0,0);
				SubRace.removeAll();
				description.setText("Dwarves can be anywhere between four to five feet tall, and are incredibly broad. They often can weigh in at around three hundred pounds of fat and muscle. Their grip strength is incredibly powerful, allowing them to bend and pinch metal with ease. Their large hands are hard as rocks and highly heat resistant, allowing them to work hot metal with their bare hands. Many are often short-tempered, but there are a few that have seemingly infinite patience. They hold tradition sacred, but that doesn't stop them from toying with the incredible technologies found across the world. Dwarves can live up to 150 years.");
				description.setVisible(true);
				RACE_S.setText("Dwarf");
				select.setEnabled(true);
				//SubRace.setVisible(false);
				Layers.repaint();


				break;
				
			case "Humans":
				SubRace.setBounds(250,200,0,0);
				SubRace.removeAll();
				description.setText("Humans are just ordinary humans for the most part, though many from Terna will bear cybernetic enhancements.");
				description.setVisible(true);
				RACE_S.setText("Human");
				select.setEnabled(true);
				//SubRace.setVisible(false);
				Layers.repaint();


				break;
				
			case "Gnomes":
				SubRace.setBounds(250,200,0,0);
				SubRace.removeAll();
				description.setText("Gnomes are the scum of the earth. They will lie, steal, and cheat to gain any kind of advantage over others, even of their own kind. As a result, gnomes are often kept at arms length and kept out of any respectable buisnesses in the zones. Weirdo Caravans often threaten death to a gnome if they approach looking to do buisness. They stand anywhere between two to three feet tall and collectively have white hair. They weigh in at around eighty pounds, conveniently allowing them to easily be thrown out of any respectable establishment. Gnomes unfortunately can live to be 300 years old assuming they haven't gotten stomped yet.");
				description.setVisible(true);	
				RACE_S.setText("Gnome");
				select.setEnabled(true);
				//SubRace.setVisible(false);
				Layers.repaint();
				break;
				
			case "Select":
				player.SetRace(RACE_S.getText());
//				select.setActionCommand("CC_Select2");
//				which.setText("Select your Brain");
//				Layers.repaint();
				CharCreator();
			break;
			
			case "Select2":
				player.SetBrain(RACE_S.getText());
				CharCreator();
			break;
				
			default: 
				if(race.startsWith("SEL")) {
					race=race.substring(3);	
				switch(race) {
				
				case "Red Elves":				RACE_S.setText(race);
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Elves stand in at around human heights, depending on their sub-species. This means anywhere from 4'11 to 6'8. They can be pompous and arrogant as well as kind and detrimentally curious. Elves have four sub-species, these ones separated by hair and eye color. Reds are the biggest sub-species of elves, regularly being human sized with an inherent talent for close combat, as such they are the best at a straight up fight. All elves are biologically immortal in the sense that they do not age, and such can only be killed through violence, disease, or other nastiness.");
					break;
				case "Green Elves":				RACE_S.setText(race);
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Elves stand in at around human heights, depending on their sub-species. This means anywhere from 4'11 to 6'8. They can be pompous and arrogant as well as kind and detrimentally curious. Elves have four sub-species, these ones separated by hair and eye color.  These are Red, Green, White, and Gray. Green elves are typically small and sneaky, and as such are thieves or assassins normally. All elves are biologically immortal in the sense that they do not age, and such can only be killed through violence, disease, or other nastiness.");
					break;
					
				case "White Elves":				RACE_S.setText(race);
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Elves stand in at around human heights, depending on their sub-species. This means anywhere from 4'11 to 6'8. They can be pompous and arrogant as well as kind and detrimentally curious. Elves have four sub-species, these ones separated by hair and eye color.  These are Red, Green, White, and Gray. White elves are the most likely out of all species to receive magic powers, and as such are incredibly rare.All elves are biologically immortal in the sense that they do not age, and such can only be killed through violence, disease, or other nastiness.");
					break;
					
				case "Grey Elves":				RACE_S.setText(race);
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Elves stand in at around human heights, depending on their sub-species. This means anywhere from 4'11 to 6'8. They can be pompous and arrogant as well as kind and detrimentally curious. Elves have four sub-species, these ones separated by hair and eye color.  These are Red, Green, White, and Gray.  Gray elves are the smartest elves out of the lot, and typically lead any elvish factions that can be found. All elves are biologically immortal in the sense that they do not age, and such can only be killed through violence, disease, or other nastiness.");
					break;
					
				case "Green Shialonian":				RACE_S.setText("Shialonians");
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Shialonians are tiny pinky sized people divided into two sub races that despise one another.These are the Green Shialonians, and the Red Shialonians. Both have white hair, pointed ears, and Fey like eyes that are red or green in hue. Green Shialonians have green skin and red eyes. They hate each other for existing and looking different than one another, and wage war because of that fact. The reason being that in their religion, only one of them is the true creation of Shialon, their god. Each side depicts Shialon with their races color, which equally enrages both sides.They mainly reside in the Blood  Desert, but their burrows can be found anywhere in the wastes.");
					break;
					
				case "Red Shialonian":			RACE_S.setText("Shialonians ");
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Shialonians are tiny pinky sized people divided into two sub races that despise one another.These are the Green Shialonians, and the Red Shialonians. Both have white hair, pointed ears, and Fey like eyes that are red or green in hue.  Red Shialonians have red skin and green eyes. They hate each other for existing and looking different than one another, and wage war because of that fact. The reason being that in their religion, only one of them is the true creation of Shialon, their god. Each side depicts Shialon with their races color, which equally enrages both sides.They mainly reside in the Blood  Desert, but their burrows can be found anywhere in the wastes.");
					break;
					
				case "Orc":						RACE_S.setText("Orcs");
					select.setEnabled(true);
					description.setVisible(true);
					description.setText("Orcs are big, green, mostly stupid but with some exceptions. They can stand anywhere from 6'0 to 8'0 and can weigh between 200 to 500 pounds. There are two separate sub-races that  have one thing that sets them both apart. These are the black eyed orcs, and the yellow eyed orcs. The pupils for both sub-races are the same shade of red, but the rest of the eye is either a deep shade of yellow or pitch black. Black eyed orcs are savage wholly evil. Yellow eyed orcs are like the other races in that they actually can choose to be evil or good. Yellow-eyes are typically smarter than their black-eyed counterparts. Typically both species will form biker gangs that roam the wastes.");
					break;
					
					default: 
					break;
				}
				Layers.repaint();
				}
				
				
			}
			
			
		}
		
		//Text input interpreter
		if(action.equals("Text")     ) {		try {
			String text = field.getDocument().getText(0, field.getDocument().getLength());
			switch(text) {
			case "bruh": 	         window.repaint();
				break;
				
			case "yeet": Window.dispatchEvent(new WindowEvent(Window, WindowEvent.WINDOW_CLOSING));
				break;
				
				
				
			default: System.out.println("Unrecognized command: " + text);
			}
			field.setText("");
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	}
	
	

}
