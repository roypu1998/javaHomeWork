package UI;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

import javax.swing.*;

import Country.RamzorColor;
import Location.*;
import Location.Point;

public class PaintMap extends JPanel {
	
	
	private List <Location> location;
	
	private List <String> name;
	
	private List <RamzorColor> rc;
	
	public PaintMap(List <Location>l,List<String> n, List<RamzorColor> rc) {
		this.location=l;
		this.name=n;
		this.rc=rc;
	}
	public void paint(Graphics g) {	
				Point[] loc =new Point[this.location.size()]; 
		int x,y;
		for (int i=0; i<this.location.size();i++) {
			x=this.location.get(i).getPosition().getX()+(this.location.get(i).getSize().getWidth()/2);
			y=this.location.get(i).getPosition().getY()+(this.location.get(i).getSize().getHeight()/2);
			loc[i]=new Point(x,y);
		}
		
		Graphics g2=(Graphics) g;
		
					
		for (int i=0; i<this.location.size();i++) {
			for (int j=0;j<this.location.size();j++) {
				if (i!=j)
					g2.drawLine(loc[i].getX(), loc[i].getY(), loc[j].getX(), loc[j].getY());
				}
			}
		
		for (int i=0; i<this.location.size(); i++) {
			g.setColor(this.rc.get(i).getColor());
			g.fillRect(location.get(i).getPosition().getX(),location.get(i).getPosition().getY(),
			    	location.get(i).getSize().getWidth(), location.get(i).getSize().getHeight());
			g2.setColor(Color.black);
			
			g2.drawString(this.name.get(i),location.get(i).getPosition().getX()+(location.get(i).getSize().getWidth()/2)
					,location.get(i).getPosition().getY()+(location.get(i).getSize().getHeight()/2) );
			
		}
		

	}
	
}
