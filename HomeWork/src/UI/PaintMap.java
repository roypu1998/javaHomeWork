package UI;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

import javax.swing.*;

import Country.RamzorColor;
import Country.Settlement;
import Location.*;
import Location.Point;

public class PaintMap extends JPanel {
	
	private List <Settlement> settlement;
	
	public PaintMap(List <Settlement> settlement) {
		
		this.settlement=settlement;
	}
	
	public Point middlePoint(Location l) {
		int x,y;
		x=l.getPosition().getX()+(l.getSize().getWidth()/2);
		y=l.getPosition().getY()+(l.getSize().getHeight()/2);
		return new Point(x,y);
	}
	
	
	public int colorName(Color c1, Color c2) {
		return (c1.getRGB()+c2.getRGB())/2;
	}

	public void paint(Graphics g) {	
		Point p1,p2; 

		Graphics g2=(Graphics) g;
		
		for (int i=0; i<this.settlement.size();i++) {
			for (int j=0;j<this.settlement.get(i).getConnectedAreas().size();j++) {
					p1=this.middlePoint(this.settlement.get(i).getLocation());
					p2=this.middlePoint(this.settlement.get(i).getConnectedAreas().get(j).getLocation());
					Color c1=this.settlement.get(i).getRamzorColor().getColor();
					Color c2=this.settlement.get(i).getConnectedAreas().get(j).getRamzorColor().getColor();
					Color color= new Color(colorName(c1, c2));
					g2.setColor(color);
					g2.drawLine(p1.getX(),p1.getY(),p2.getX(),p2.getY());
				}
			}
		
		for (int i=0; i<this.settlement.size(); i++) {
			g.setColor(this.settlement.get(i).getRamzorColor().getColor());
			g.fillRect(this.settlement.get(i).getLocation().getPosition().getX(),this.settlement.get(i).getLocation().getPosition().getY(),
					this.settlement.get(i).getLocation().getSize().getWidth(),this.settlement.get(i).getLocation().getSize().getHeight());
			g2.setColor(Color.black);
			g2.drawString(this.settlement.get(i).getName(),this.settlement.get(i).getLocation().getPosition().getX()
					+(this.settlement.get(i).getLocation().getSize().getWidth()/2)
					,this.settlement.get(i).getLocation().getPosition().getY()
					+(this.settlement.get(i).getLocation().getSize().getHeight()/2) );
			
		}
		

	}
	
	
}
