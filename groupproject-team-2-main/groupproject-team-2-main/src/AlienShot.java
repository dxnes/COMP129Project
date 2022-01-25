import acm.graphics.GImage;

public class AlienShot extends Projectile {
	//fields
	private GImage ps;
	private MainApplication program;
	public AlienShot( double d, double e, MainApplication ma) {
		super(d, e);
		program = ma;
		// TODO Auto-generated constructor stub
		ps = new GImage("src/Bullets/Rotated Alien.png", d-48, e-48);
		ps.setSize(64,64);
		program.add(ps);
		ps.sendToFront();

	}
	
	public void shoot() {
		for(int i = 0; i < 100; i++) {
			ps.setLocation(xPos, yPos++);
		}
	}
}
