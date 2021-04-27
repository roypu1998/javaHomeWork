package UI;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

import javax.swing.*;

import Location.*;

public class PaintMap extends JPanel {
	
	private List <Location> location;
	
	private List <String> name;
	
	public PaintMap(List <Location>l,List<String> n) {
		this.location=l;
		this.name=n;
	}
	public void paint(Graphics g) {	

		for (int i=0; i<this.location.size(); i++) {

			g.setColor(Color.GREEN);
			g.fillRect(location.get(i).getPosition().getX(),location.get(i).getPosition().getY(),
			    	location.get(i).getSize().getWidth(), location.get(i).getSize().getHeight());
			Graphics g2=(Graphics) g;
			g2.setColor(Color.black);
			
			g2.drawString(this.name.get(i),location.get(i).getPosition().getX()+(location.get(i).getSize().getWidth()/2)
					,location.get(i).getPosition().getY()+(location.get(i).getSize().getHeight()/2) );
			
		}
	}
	
}
