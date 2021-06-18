import java.applet.Applet;
import java.awt.Graphics;

public class AppletDemo extends Applet{

	String name;
	
	@Override
	public void init() {
		name = "1. Init method intilaized ...";
		System.out.println(name);
	}
	
	
	@Override
	public void start() {
		name = "2. Start method Called ....";
		System.out.println(name);
	}
	
	@Override
	public void stop() {
		name = "3. STOP method Called ....";
		System.out.println(name);
	}
	
	
	@Override
	public void destroy() {
		name = "4. destroy method Called ....";
		System.out.println(name);
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println(" 5. Draw String");
		g.drawString(name, 50, 50);

	}
	

}
