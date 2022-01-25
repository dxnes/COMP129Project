import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
@SuppressWarnings("unused")
public class WelcomePane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
							
	private GImage background;
	private GImage title;
	private GImage button;
	
	public WelcomePane(MainApplication app) {
		super();

		String filename = "src/Images/cloud.gif";
		background = new GImage(filename, 0,0);
		program = app;
		title = new GImage("src/Images/title.png", program.getWidth()/2 - 233, program.getHeight()/5-(150/5));
		title.sendToFront();
		button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
		button.sendToFront();

	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(title);
		program.add(button);
		
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(title);
		program.remove(button);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == button) {
			program.switchToMenu();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER)
			program.switchToMenu();
	}
}
