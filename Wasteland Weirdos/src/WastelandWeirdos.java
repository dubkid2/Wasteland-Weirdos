
import javax.swing.JFrame;

public class WastelandWeirdos {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		
		JFrame window = new JFrame();
		Screen screen= new Screen();
		screen.SetFullscreen(null, window);
		//screen.SetWindowed(null, window);
		
	}


}
