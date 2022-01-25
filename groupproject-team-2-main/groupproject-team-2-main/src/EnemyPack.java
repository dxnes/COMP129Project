import java.util.ArrayList;

import java.util.Iterator;

import acm.graphics.GRect;
import acm.graphics.GRectangle;
@SuppressWarnings("unused")
public class EnemyPack {
	 ArrayList <Enemy> enemies;
	

	private MainApplication program;
	private MainGame game;
	 double min, max;
	 private int y = 1;
	 int spawn = 400; //default time
	 int lastSpawn = 0;
	 
	
	public EnemyPack( MainApplication app, MainGame game) {
		// TODO Auto-generated constructor stub
		enemies = new ArrayList <Enemy>();
		program = app;
		this.game = game;
		int i = 0;
		int ran = (int)(Math.random()*(2+1-1)+1);
	}
	
	public void update() {
		if(lastSpawn == 0) {
			Enemy temp = new Enemy(program);
			enemies.add(temp);
			lastSpawn = spawn;
		}
		else { 
			lastSpawn += -10;
		}
		Iterator <Enemy> iter = enemies.iterator();
		while(iter.hasNext()) {
			Enemy temp = iter.next();
			temp.update();
			if (temp.getY() > 500) {
				temp.hide();
				iter.remove();
				game.player.updateHealth(10);
			}
		}
	}
	public boolean checkCollision(GRectangle box) {
		Iterator <Enemy> iter = enemies.iterator();
		while(iter.hasNext()) {
			Enemy temp = iter.next();
			if(game.rectCollision(box, temp.getBounds())) {
				temp.hide();
				iter.remove();
				game.addScore(10);
				return true;
			}
			
		}
		return false;
	}
}
