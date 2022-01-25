import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;

public class Leaderboard extends GraphicsPane {

    private MainApplication program; 
    private GImage background;
    private GImage title;
    private GImage button;
    private GImage bButton;
    private GImage scoreImage;
    private GLabel text;
    private GLine textline;
    private String username = " ";
    private GImage leaderboard;
    private GImage leaderboardImage;
    private ArrayList <Record> records;
    private GLabel leaderboardScores;
    private GImage leaderboardUsername;
    ArrayList<GLabel> scores;
    
    public Leaderboard(MainApplication app) {
        super();

        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;
        leaderboard = new GImage("src/Images/Leaderboard.png", 220, 0);
        leaderboard.sendToFront();        
        leaderboardImage = new GImage("src/Images/leaderboardImage.png", program.getWidth()/2 - 223, program.getHeight()/5-(400));
        leaderboardImage.sendToFront();
        bButton = new GImage("src/Images/bButton.png", 265, 478);
        bButton.sendToFront();
        scores = new ArrayList <GLabel>();
        String Leaderboardstring = " ";
        leaderboardScores = new GLabel("src/Scores.txt", 200, 0);
        leaderboardScores.sendToFront();
        scoreImage = new GImage("src/Images/Score.png", 410, 30);
        scoreImage.sendToFront();
        leaderboardUsername = new GImage("src/Images/leaderboardUsername.png", 175, 30);
        leaderboardUsername.sendToFront();
        LeaderboardScores ls = new LeaderboardScores(program);
        records = ls.getScores();
        int y = 300*2/3-50;
        Iterator<Record> iter = records.iterator();
        while (iter.hasNext()) {
        	Record temp = iter.next();
        	String leaderboardstring = temp.getName() + "                                                                           " + temp.getValue() + "";
        
        	scores.add( new GLabel(leaderboardstring, 600/2-150/2, y));
        	y += 80;
        }
        
    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(bButton);
        program.add(leaderboard);
        program.add(leaderboardImage);
        program.add(scoreImage);
        program.add(leaderboardUsername);
        program.add(leaderboardScores);
        for(GLabel l: scores) {
        	program.add(l);
        	
        }
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(bButton);
        program.remove(leaderboard);
        program.remove(scoreImage);
        program.remove(leaderboardImage);        
        program.remove(leaderboardScores);
        program.remove(leaderboardUsername);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == bButton) {
        	program.switchToMenu();
        }
        if (obj == leaderboard) {
        	program.switchToLeaderboard();
        }
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    	boolean isOn = false;
        GObject obj = program.getElementAt(e.getID(), e.getID());
        if (obj == bButton) {
        	program.switchToMenu();
        }
        if (obj == leaderboard) {
        	program.switchToLeaderboard();
        }
    }
}
