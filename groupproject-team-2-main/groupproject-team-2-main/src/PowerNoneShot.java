import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage; 
@SuppressWarnings("unused")
public class PowerNoneShot extends Projectile implements ActionListener {
    //fields
    private PowerType pt;
    // Constructor
    public PowerNoneShot(PowerType pt, double d, double e, MainApplication ma) {
        super(ma, d+48, e);
        this.pt = pt;
        // TODO Auto-generated constructor stub
        if(pt == PowerType.POWERSHOT) {
            ship = new GImage("src/Bullets/Rotated Power.png", d-48, e-48);
            ship.sendToFront();
        } else if(pt == PowerType.NONE || pt == null){
            ship = new GImage("src/Bullets/Rotated SHOT.png", d-48, e-48);
            ship.sendToFront();

        }
        System.out.println("PS Coords: " + xPos);
        System.out.println("Bullet creation:" + ship.getX() + " " + ship.getY());
        ship.setSize(64,64);
        System.out.println("Bullet creation:" + ship.getX() + " " + ship.getY());
        ma.add(ship);


        ship.sendToFront();
        up = true;

    }

    public void actionPerformed(ActionEvent e) {
        if(yPos < 0) {
            timer.stop();
            
        }
            ship.setLocation(xPos, yPos--);
            
    }


    public PowerType shoot() {
        return pt;
    }

    //removed some prints for less lag
}