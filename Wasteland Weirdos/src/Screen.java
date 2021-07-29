

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
	        
	        ImageIcon image2 = new ImageIcon("src/background.jpg");
	        JLabel imageLabel2 = new JLabel(image2); 
	        imageLabel2.setBounds(0, 0, 800, 800);
	        imageLabel2.setVisible(true);
	        BR.add(imageLabel2);

//	        ImageIcon BR = new ImageIcon("src/BR.jpg");
//	        JLabel BRLabel = new JLabel(BR); 
//	        window.add(BRLabel);
//	       BRLabel.setBounds(0, 0, width, height);
//	       BRLabel.setVisible(true);
	        
	        JButton Start = new JButton ("New Game");
	        Start.setVisible(true);
	        Start.setBounds(200,650, 200, 50);
	        Start.addActionListener(this);
	        window.add(Start);

	        
	        JButton Settings = new JButton ("settings");
	        Settings.setVisible(true);
	        Settings.setBounds(400, 650, 200, 50);
	        Settings.addActionListener(this);
	        window.add(Settings);


	        field= new JTextField(25);
	        field.addActionListener(this);
	        field.setActionCommand("Text");
	        field.setBounds(50,700, 700, 50);
	        field.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	        field.setVisible(true);
	        BR.add(field);
	        

			
			
	        window.repaint();
	        
	        field.setText(" ");


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
		
		default: System.out.println("You shouldn't be here...");
		}
		
		
		
	}
	
	private void CharCreator () {
		
        JPanel Races = new JPanel(new GridLayout(1,0));
		Races.setBounds(50, 50, 200, 600);
		
		field.setText(" ");
		 
		window.add(Races, BorderLayout.WEST);

		Races.setVisible(true);
		JButton Dwarves= new JButton("Dwarf");
		Dwarves.setVisible(true);
		Dwarves.setBounds(0,0,200,50);
		Races.add(Dwarves);
		
		JButton Elves= new JButton("Elf");
		Elves.setVisible(true);
		Elves.setBounds(0,50,200,50);
		Races.add(Elves);
		
		JButton Gnomes= new JButton("Gnome");
		Gnomes.setVisible(true);
		Gnomes.setBounds(0,100,200,50);
		Races.add(Gnomes);
		
		JButton Orcs= new JButton("Orc");
		Orcs.setVisible(true);
		Orcs.setBounds(0,150,200,50);
		Races.add(Orcs);
		
		JButton Humans= new JButton("Human");
		Humans.setVisible(true);
		Humans.setBounds(0,200,200,50);
		Races.add(Humans);
		
		JButton Shialonians= new JButton("Shialonian");
		Shialonians.setVisible(true);
		Shialonians.setBounds(0,250,200,50);
		Races.add(Shialonians);
		
		

		JLabel label1= new JLabel("Choose Your Race");
		 label1.setBounds(350,50, 400,50);
		 label1.setVisible(true);
		 label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		 window.add(label1);
		
	
		Layers.repaint();

		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action=arg0.getActionCommand();
		//System.out.println("something happened: " + action);
		if(action.equals("New Game") ) {		System.out.println("The NewGame button has been pressed");
			GoToScreen(2);
		}
		
		if(action.equals("settings") ) {		System.out.println("The Settings button has been pressed");}
		
		
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
