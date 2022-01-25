import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import acm.graphics.GImage;
@SuppressWarnings("unused")
public class Boss implements ActionListener{

  
	private int damage;
	private int health;
	private MainApplication program;
	private GImage boss;
	
	private GImage beam;
	private MainGame mg;
	private Timer timer;
	private int attack;
	
	public Boss(MainApplication ma, MainGame mg) {
		this.mg = mg;
		program = ma;
		boss = new GImage("src/Images/boss.gif", program.getWidth()/3, program.getHeight()/5);
		System.out.println("Drawing boss");

		boss.sendToFront();
	}
    
	public void attack() {

	}
    
	public void setHealth(int health){
		this.health = health;
	} 
   
	public int getHealth() {
		return health;
	} 
    
	public void dealDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void show() {
		// TODO Auto-generated method stub
		program.add(boss);
	}

	public void hide() {
		// TODO Auto-generated method stub
		program.remove(boss);
	}

}
