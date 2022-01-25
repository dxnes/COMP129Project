import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRectangle;
import acm.graphics.GRect;
@SuppressWarnings("unused")
public class MainGame extends GraphicsPane implements KeyListener, ActionListener{
    
    private Timer timer;
    ArrayList <Enemy> enemies;
    ArrayList <Projectile> bullets;
    GImage background;
    KeyHandler keys;
    int enemyDx;
    GImage playerSprite;
    Player player;
    private MainApplication program; 
    boolean paused = false;
    private EnemyPack enemy;
    private Boss b;
    private GLabel scoreboard;
    private int score;
    private int shotCooldown = 50;
    private int lastShot;
    private GImage tempE1;
    private GImage tempE2;
    private GRect shield1;
    private GRect shield2;
    private GRect shield3;
    private GImage endGame;
    private GImage lose;
    private GLabel health;
    private boolean gameOver; 
    private boolean endScreen;
    private boolean lost;
	private int level;
    private int difficulty = 1;
    private int FINAL_SCORE = 100;
    public MainGame(String username,MainApplication app) {
        super();
        program = app;
        bullets = new ArrayList <Projectile>();
        player = new Player(username, program, this);
        System.out.println(player.getUserName());
        background = new GImage("src/Images/bg2.gif", 0,0);
        background.sendToBack();
    	level = 1;
    	enemy = new EnemyPack(program, this);
    	score = 0;
    	scoreboard = new GLabel("Score: " + score,720,560);
    	endGame = new GImage("src/Images/win.png",0,0);
    	gameOver = false;
    	endScreen = false;
    	lastShot = 0;
    	lost = false;
    	lose = new GImage("src/Images/lose.png",0,0);
    	health = new GLabel("Health: " + player.getHealth(),720,540);
    	b = new Boss(program, this);
    }
    
    public void updatePlayer() {
    
        if(keys.keyDown(KeyEvent.VK_LEFT)) {
            playerSprite.move(0 - player.getVelocity(), 0);
        }
        else if(keys.keyDown(KeyEvent.VK_RIGHT)) {
            playerSprite.move(player.getVelocity(), 0);
        }
    }
    
    public boolean rectCollision(GRectangle gRectangle, GRectangle gRectangle2) {
    	double minX = gRectangle.getX();
    	double minY = gRectangle.getY();
    	double maxX = minX + gRectangle.getWidth();
    	double maxY = minY + gRectangle.getHeight();
    	
    	if(gRectangle2.getX() > maxX || minX > gRectangle2.getX() + gRectangle2.getWidth()) return false;
    	if(gRectangle2.getY() > maxY || minY > gRectangle2.getY() + gRectangle2.getHeight()) return false;
    	return true;
    }
    
    @Override
    public void showContents() {
        // TODO Auto-generated method stub
        program.add(background);
        program.add(scoreboard);
        program.add(health);
        player.show();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void hideContents() {
        // TODO Auto-generated method stub
        program.remove(background);
        player.hide();
        program.remove(scoreboard);
        if(endScreen) {
        	program.remove(endGame);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(paused || gameOver || lost) {
            return;
        }
        if(player.getHealth() < 10 ) {
        	lost = true;
        	program.switchToLose();
        }
        
        player.update();
        if(lastShot != 0) {
        	lastShot -= 10;
        }
        //some edits made, but eclipse wont read it for pushing
        Iterator<Projectile> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Projectile temp = iter.next();
        	temp.update();


        	if(enemy.checkCollision(temp.getImage().getBounds())) {	
        		temp.hide();
        		iter.remove();
        	}
        }
        enemy.update();
        health.setLabel("Health: " + player.getHealth());
        /*Iterator<Shots> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Projectile temp = iter.next();
        	temp.update();
        	if(EnemyPack.checkCollision(temp.getImage().getBounds()))
        	if(rectCollision(temp.getImage().getBounds(),player.getBounds())) {
        		player.takedamage();
            	temp.hide();
            	iter.remove();
            }
        	else if(temp.getY() < 0 || temp.getY() > 600) {
        		
        	}
        }*/
    }

	@Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(!paused) {
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                //player.move(-10,0);
                player.updateVelocity(-2, 0);
            }
            if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                //player.move(10,0);
            	player.updateVelocity(2, 0);
            }
            if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                player.updateVelocity(0,-2);
            }
            if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                player.updateVelocity(0,2);
            }
            if(key == KeyEvent.VK_SPACE) {
            	if (lastShot == 0) {
            		lastShot = shotCooldown;
            		bullets.add(player.shoot());
            		System.out.println(player.getPower());
            	}
                System.out.println(player.getUserName());
            }
        }
         if(key == KeyEvent.VK_ESCAPE) {
            if(paused) {
                paused = false;
            }
            else
                paused = true;
            	for(Projectile p : bullets) {
            		p.pause();
            	}
            	program.switchToSettings(this);
            	
        }
    }
	
	public void addScore(int sc) {
		score += sc;
		scoreboard.setLabel("Score: " + score);
		
		if(score >= (FINAL_SCORE * difficulty * 2)) {
			gameOver = true;
		}
		if(gameOver && !endScreen) {
			program.switchToWin();
			player.setScore(score);
			System.out.println(player.getScore());
			FINAL_SCORE = 150;
			
		}
	}
	
	public boolean isLost() {
		return gameOver && score != 100;
	}
	public void setDifficulty(int d) {
		difficulty = d;
	}

	public void changeLevel(int level) {
		// TODO Auto-generated method stub
		this.level = level;
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	
	public long getScore() {
		return score;
	}
}