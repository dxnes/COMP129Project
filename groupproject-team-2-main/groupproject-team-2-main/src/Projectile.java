import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GObject;
@SuppressWarnings("unused")
public class Projectile implements ActionListener {
    double xPos;
    double yPos;
    int velocity;
    GImage ship;
    protected MainApplication program;
    protected Timer timer;
	protected boolean paused;
	protected boolean up;
	private boolean travelling;

    public Projectile(MainApplication app, double d, double e) {
    	program = app;
        xPos = d;
        yPos = e;
        ship = new GImage("src/Bullets/Rotated Shot.png", d, e);
        timer = new Timer(1, this);
        timer.start();

        travelling = true;
    }


    //Setters for the class
    public void setXPos(int xPos) {
      this.xPos = xPos;
    }
    public void setYPos(int yPos) {
      this.yPos = yPos;
    }
    public void setVelocity(int velocity) {
      this.velocity = velocity;
    }
    //getters for the class

    public double getXPos() {
      return this.xPos;
    }
    public double getYPos() {
      return this.yPos;
    }
    public Integer getVelocity() {
      return this.velocity;
    }

    public void update() {

    }

    public void remove() {
    	program.remove(ship);
    	travelling = false;
    	
    }

    public void hide() {
        // TODO Auto-generated method stub
    	ship.setVisible(false);
    }


    public GObject getImage() {
        // TODO Auto-generated method stub
        return ship;
    }

    public double getY() {
        // TODO Auto-generated method stub
        return ship.getY();
    }


	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("Projectile paused");
		timer.stop();
		paused = true;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(yPos < 0 || !travelling) {
            timer.stop();
           
        } else if(!paused) {
            ship.setLocation(xPos, yPos--);
            
        }
	}
}