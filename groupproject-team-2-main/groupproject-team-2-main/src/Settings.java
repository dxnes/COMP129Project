import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextField;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import java.awt.Graphics2D;



@SuppressWarnings("unused")
public class Settings extends GraphicsPane {
	
	private MusicPlayer mp;
	private boolean isOn = false;
    private MainApplication program; 
    private GImage background;
    private GImage settings;
    private GImage settingsTitle;
    private GImage difficultyLevelBox;
    private GImage musicBox;
    private GImage controlText;
    private GImage keyControls;
    private GImage spaceBar;
    private GImage mText;
    private GImage sText;
    private GImage bButton;
    private GRect temp;
    private GRect temp1;
    private GRect temp2;
    private GRect temp3;
    private GRect temp4;
    private GImage sBox1;
    private GImage sBox2;
    private GImage sBox3;
    private GImage sBox4;
    private GImage sBox5;
    private GImage eText;
    private GImage nText;
    private GImage hText;
    private GImage offText;
    private GImage onText;
	public GraphicsPane last;
	private SimpleAudioPlayer ap;
	
	

    public Settings(MainApplication app) {
        super();
        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;  
        
        settingsTitle = new GImage("src/Images/settings Title.png", -50, 0);
        settingsTitle.sendToFront();
        difficultyLevelBox = new GImage("src/Images/difficultyLevelBox.png", -73, 80);
        difficultyLevelBox.sendToFront();
        musicBox = new GImage("src/Images/music.png", -115, 160);
        musicBox.sendToFront();
        controlText = new GImage("src/Images/controlText.png", 35, 240);
        controlText.sendToFront();
        sText = new GImage("src/Images/shootingText.png", 360, 310);
        sText.sendToFront();
        mText = new GImage("src/Images/movementText.png", 41, 310);
        mText.sendToFront();
        keyControls = new GImage("src/Images/keyControls.png", 100, 410);
        keyControls.sendToFront();
        spaceBar = new GImage("src/Images/spacebar.png", 450, 420);
        spaceBar.sendToFront();
        settings = new GImage("src/Images/settings gears.png", program.getWidth()/2 - 223, program.getHeight()/5-(400));
        settings.sendToFront();
        bButton = new GImage("src/Images/bButton.png", 265, 478);
        bButton.sendToFront();
        sBox1 = new GImage("src/Images/selectionBox.png", 340, 135);
        temp = new GRect(370, 143, 30, 30);
        temp.setFillColor(Color.RED);
        temp.setFilled(true);
        temp.sendToFront();
        temp1 = new GRect(480, 143, 30, 30);
        temp1.setFillColor(Color.RED);
        temp1.sendToFront();
        temp2 = new GRect(590, 143, 30, 30);
        temp2.setFillColor(Color.RED);
        temp2.sendToFront();
        temp3 = new GRect(369, 229, 30, 30);
        temp3.setFillColor(Color.RED);
        temp3.sendToFront();
        temp4 = new GRect(479, 229, 30, 30);
        temp4.setFillColor(Color.RED);
        temp4.sendToFront();
        temp3.setFilled(true);
        sBox2 = new GImage("src/Images/selectionBox.png", 450, 135);
        sBox3 = new GImage("src/Images/selectionBox.png", 560, 135);
        sBox4 = new GImage("src/Images/selectionBox.png", 340, 220);
        sBox5 = new GImage("src/Images/selectionBox.png", 450, 220);       
        eText = new GImage("src/Images/easytext.png", 235, 50);
        eText.sendToFront();
        nText = new GImage("src/Images/normalText.png", 345, 50);
        nText.sendToFront();
        hText = new GImage("src/Images/hardText.png", 455, 50);
        hText.sendToFront();
        onText = new GImage("src/Images/onText.png", 235, 135);
        onText.sendToFront();
        offText = new GImage("src/Images/offText.png", 345, 135);
        offText.sendToFront();
  
        try {
            ap = new SimpleAudioPlayer();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(settings);
        program.add(settingsTitle);
        program.add(difficultyLevelBox);
        program.add(musicBox);
        program.add(controlText);
        program.add(keyControls);
        program.add(spaceBar);
        program.add(sText);
        program.add(mText);
        program.add(bButton);
        program.add(sBox1);
        program.add(sBox2);
        program.add(sBox3);
        program.add(sBox4);
        program.add(sBox5);
        program.add(eText);
        program.add(nText);
        program.add(hText);
        program.add(onText);
        program.add(offText);
        program.add(temp);
        program.add(temp1);
        program.add(temp2);
        program.add(temp3);
        program.add(temp4);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(settings);
        program.remove(settingsTitle);
        program.remove(difficultyLevelBox);
        program.remove(musicBox);
        program.remove(controlText);
        program.remove(keyControls);
        program.remove(spaceBar);
        program.remove(sText);
        program.remove(mText);
        program.remove(bButton);
        program.remove(sBox1);
        program.remove(sBox2);
        program.remove(sBox3);
        program.remove(sBox4);
        program.remove(sBox5);
        program.remove(eText);
        program.remove(nText);
        program.remove(hText);
        program.remove(onText);
        program.remove(offText);
        program.remove(temp);
        program.remove(temp1);
        program.remove(temp2);
        program.remove(temp3);
        program.remove(temp4);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
  
        if (obj == bButton) {
        	program.switchToMenu();
        }
        if (obj == settings) {
        	program.switchToSettings(last);
        }
        if(obj == temp) {
        	temp.setFilled(true);
        	temp1.setFilled(false);
        	temp2.setFilled(false);
        	program.setDifficulty(1);
        }
    	if (obj == temp1) {
    		temp.setFilled(false);
        	temp1.setFilled(true);
        	temp2.setFilled(false);
        	program.setDifficulty(2);
            }
    	if (obj == temp2) {
    		temp.setFilled(false);
        	temp1.setFilled(false);
        	temp2.setFilled(true);
        	program.setDifficulty(3);
            } 
    	if (obj == temp3) {
    		temp3.setFilled(true);
        	temp4.setFilled(false);
        	ap.play();
    	}
    	if (obj == temp4) {
    		temp4.setFilled(true);
        	temp3.setFilled(false);
        	ap.pause();
    	}
    }

    public void actionPerformed(ActionEvent e) {

    }


    public void keyPressed(KeyEvent e) {
    	if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
    		if(last instanceof MainGame) {
    			program.switchToGame();
    		} else if(last instanceof MenuPane) {
    			program.switchToMenu();
    		} else {
    			program.switchToMenu();
    		}
    	}
	}
}
