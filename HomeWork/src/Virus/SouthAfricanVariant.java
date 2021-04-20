package Virus;
import java.util.Random;

import Location.Point;
import Population.*;
import Country.*;

public class SouthAfricanVariant implements IVirus{
	
	Random rand=new Random();
	
	public double calcDistance(Point p1 , Point p2) {
		
		int x1=p1.getX(),x2=p2.getX(),y1=p1.getY(),y2=p2.getY();
		
		double d=(Math.pow((x1-x2), 2))+(Math.pow((y1-y2),2));
		
		return Math.sqrt(d);
	}
	
	public double contagionProbability(Person p) {
		
		double contagionprobability;
		
		if (p.getAge() < 18 )
		
			contagionprobability = 0.6;
		
		else 
			contagionprobability = 0.5;
		
		return contagionprobability*p.contagionProbability();
	}
		
	public boolean tryToContagion(Person p1, Person p2) {	
		
		double distance = this.calcDistance(p1.getLocation(), p2.getLocation());
		
		if(p2 instanceof Healthy) {
			
			double rnd= rand.nextDouble();			
			double percentage =this.contagionProbability(p2)*Math.min(1.0,0.14*Math.exp (2-(0.25*distance)));
						
			if( percentage < rnd ) { 
				
				return true;
			}
		}
		
		return false;
	}

	
	public boolean tryToKill(Sick s) {
		
		double probability;
		
		
		if(s.getAge()<18)
			probability=0.05;
		
		else
			probability=0.08;
		
		double die=Math.max(0, probability-0.01*probability*(Math.pow(s.getContagiousTime()-15,2)));
		
		double rnd =rand.nextDouble();
		
		if( die >= rnd) {
			
			return true;
		}
		
		return false;

	}

	public String toString() {
		return "SouthAfricanVariant";
	}


}