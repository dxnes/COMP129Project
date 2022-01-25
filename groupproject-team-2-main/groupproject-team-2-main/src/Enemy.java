import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Enemy {
	double dx, dy;
	private int health;
	private MainApplication program;
	private GImage enemy;
	
	public Enemy(MainApplication ma){ 
	    program = ma;
	    health = 20;
	    Random ran = new Random(); //random starting position
	    double randx = ran.nextDouble();
	    if(randx < 0) {
	    	randx = randx* -1;
	    }
	    randx = (randx % 750)+1;
	    dx = ran.nextDouble();
	    dx = (dx % 5)+1;
	    int type = ran.nextInt();
	    type = (type % 2);
	    if(type < 0 ) {
	    	type = type * -1;
	    }
	    if(type == 1) {
	    	enemy = new GImage("src/Images/power_apple.png",randx,0);
	    }
	    else {
	    	enemy = new GImage("src/Images/shot_apple.png",randx, 0);
	    }
	    program.add(enemy);
	}
	
	
	public void draw(int x, int y) {
		enemy = new GImage("", x, y);
		program.add(enemy);
	}
	
	public void attack() {
		
	}
	
	public int getHealth() {
		return health;
	}

	public void dealDamage(int d) {
		health -= d;
	}
	
	public double getX() {
		return enemy.getX();
	}
	
	public double getY() {
		return enemy.getY();
	}
	
	public void update() {//if enemy goes out of bounds
		if(enemy.getX() + dx < 0) {
			enemy.setLocation(0, enemy.getY());
			dx = dx * -1;
			dy = 50; //moves down
		}
		else if(enemy.getX() + enemy.getWidth() + dx > 800) {
			enemy.setLocation(800 - enemy.getWidth(), enemy.getY());
			dy = 50;
			dx = dx * -1;
		}
		int sign = 1;
		if(dx < 0) {
			sign = -1;
		}
		if(enemy.getY() > 200 ) {
			dx = 5 * sign;
		}
		else if(enemy.getY()> 400) {
			dx = 7 * sign;
		}
		enemy.move(dx, dy);
		dy = 0;
	}


	public void hide() {
		// TODO Auto-generated method stub
		program.remove(enemy);
	}
	
	public void show() {
		program.add(enemy);
	}


	public GRectangle getBounds() {
		// TODO Auto-generated method stub
		return enemy.getBounds();
	}
}
