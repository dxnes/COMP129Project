import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;


public class WinPane extends GraphicsPane {

    // you will use program to get access to all of the GraphicsProgram calls
    private MainApplication program; 

    
    //private GLabel lose;
    private GLabel win;
    private GLabel score;
    private long playerScore;
    private GImage button;
    //private GImage loseImage;
    private GImage winImage;
    
    //private boolean winState = false;
    Player player;
    
    //state of whether player lost or won
    //if lost show lost image
    //if won show won image
    
    public WinPane(MainApplication app, MainGame game) {
    	super();
    	player = game.getPlayer();
    	System.out.println(player.getHealth());
    	program = app;
    	winImage = new GImage("src/Images/winImage.jpg");
    	
    	
    	if (player != null && player.getHealth() > 0) {
    		winImage.sendToBack();
    		win = new GLabel("YOU HAVE WON! :)", 400, 300);
    		//winState = true;
    		win.setColor(Color.white);
    	}
    	
    	

        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
    }

    @Override
    public void showContents() {
    	program.add(winImage);
    	program.add(win);
    	program.add(score);
   	  	program.add(button);
        
    }

    @Override
    public void hideContents() {
        program.add(winImage);
        program.remove(win);
        program.remove(score);
        program.remove(button);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == button) {
            program.switchToMenu();
        }
    }

    public void actionPerformed(ActionEvent e) {
    	

    }
    

    public void keyPressed(KeyEvent e) {
    	
               
    }

	public void setPlayer(Player player) {
		this.player = player;
		score = new GLabel("Score: " + playerScore, 400, 355);
		score.setColor(Color.white);
		
		
	}

	public void setScore(long score2) {
		// TODO Auto-generated method stub
		playerScore = score2;
	}

}
