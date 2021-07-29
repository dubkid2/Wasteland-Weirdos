

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
		BR = new JPanel();
		BR.setLayout(null);
		BR.setSize(800, 800);
		DisplayMode windowed= vc.getDisplayMode();
		vc.setFullScreenWindow(windows);
		vc.setDisplayMode(windowed);
		window.setSize(800,800);
		windows.setSize(800, 800);
		Color BRC = new Color(170, 229, 47);
		 window.setBackground(BRC);
		//window.setUndecorated(false);
		windows.setResizable(false);		
		window.setVisible(true);	 
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.add(window);
        windows.add(BR);
         

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
	        BR.repaint();
	        window.repaint();

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
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action=arg0.getActionCommand();
		//System.out.println("something happened: " + action);
		if(action.equals("New Game") ) {		System.out.println("The NewGame button has been pressed");}
		
		if(action.equals("settings") ) {		System.out.println("The other button has been pressed");}
		
		
		if(action.equals("Text")     ) {		try {
			String text = field.getDocument().getText(0, field.getDocument().getLength());
			switch(text) {
			case "bruh": 	        window.removeAll(); window.repaint();
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
	
	private void GoToScreen(int sc) {
		window.removeAll();
		
		
		
	}
	
	

}
