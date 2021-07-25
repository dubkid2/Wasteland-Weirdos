

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.TextUI;

public class Screen {
	
	private GraphicsDevice vc;
	private int height=10;
	private int width=10;
	
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
		Title(window);

		
	}
	
	public void SetWindowed(DisplayMode dm, JFrame window) {
		DisplayMode windowed= vc.getDisplayMode();
		vc.setFullScreenWindow(window);
		
		vc.setDisplayMode(windowed);
		Color BR = new Color(170, 229, 47);
		 window.getContentPane().setBackground(BR);
		//window.setUndecorated(false);
		window.setResizable(true);		
		window.setVisible(true);	 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Title(window);
	       
	   
	}
	
	private void Title(JFrame window) {
		int HsSize=400;

		window.setTitle("Wasteland Weirdos");
		 height= window.getHeight();
			width = window.getWidth();
			 System.out.println(height);
			 
			 JLabel label1 = new JLabel("Wasteland Weirdos");
			
			 label1.setBounds(width/2-200, 0, 1000,500);
			 label1.setVisible(true);
			 label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
			 window.add(label1);
			 
			 
			 
			 ImageIcon image = new ImageIcon("src/hs.jpg");
	        JLabel imageLabel = new JLabel(image); 
	        window.add(imageLabel);
	        imageLabel.setBounds(width/2-HsSize/2, height/2-HsSize/2, HsSize, HsSize);
	        imageLabel.setVisible(true);
	        
	        ImageIcon BR = new ImageIcon("src/BR.jpg");
	        JLabel BRLabel = new JLabel(BR); 
	        window.add(BRLabel);
	       BRLabel.setBounds(0, 0, width, height);
	       BRLabel.setVisible(true);
	       
	        JTextField field = new JTextField(10);
	        window.add(field);
	        field.setBounds(0,height-50, width, 50);
	        field.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	        field.setVisible(true);
	}
	
	public DisplayMode GetDM() {
		return vc.getDisplayMode();
	}

}
