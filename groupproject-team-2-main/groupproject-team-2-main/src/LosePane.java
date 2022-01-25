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

public class LosePane extends GraphicsPane {
	 private MainApplication program;  
	 private GLabel lose;
     private GLabel score;
	 private long playerScore;
	 private GImage button;
	 private GImage loseImage;
	 Player player;
	 

	    public LosePane(MainApplication app, MainGame game) {
	    	super();
	    	player = game.getPlayer();
	    	System.out.println(player.getHealth());
	    	program = app;
	    	loseImage = new GImage("src/Images/lostImage.jpg");
	    	
	    	
	    	
	    	if (player != null && player.getHealth() > 0) {
	    		loseImage.sendToBack();
	    		lose = new GLabel("YOU HAVE LOST :(", 300, 250);
	    		lose.setColor(Color.white);
	    	}
	    	

	        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
	    }

	    @Override
	    public void showContents() {
	    	program.add(loseImage);
	   		program.add(lose);
	   		program.add(score);
	   	    program.add(button);
	        
	    }

	    @Override
	    public void hideContents() {
	    	program.remove(loseImage);
	        program.remove(lose);
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
			score = new GLabel("Score: " + playerScore, 300, 355);
			score.setColor(Color.white);
			
			
		}

		public void setScore(long score2) {
			// TODO Auto-generated method stub
			playerScore = score2;
		}

}
