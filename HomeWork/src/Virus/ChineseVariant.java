package Virus;
import java.util.Random;

import Location.Point;
import Population.*;
import java.math.*;



public class ChineseVariant implements IVirus {
	
	Random rand= new Random();
	public double contagionProbability(Person p) {
		
		double contagionprobability;
		
		if (p.getAge() < 18 )
			contagionprobability = 0.2;
		
		else if ( p.getAge() > 17 && p.getAge() < 55)
			contagionprobability = 0.5;
		
		else
			contagionprobability = 0.7;
		
		return contagionprobability*p.contagionProbability();
	}
	
	public double calcDistance(Point p1 , Point p2) {
		
		int x1=p1.getX(),x2=p2.getX(),y1=p1.getY(),y2=p2.getY();
		
		double d=(Math.pow((x1-x2), 2))+(Math.pow((y1-y2),2));
		
		return Math.sqrt(d);
	}
	
	public boolean tryToContagion(Person p1, Person p2) {
		double distance = this.calcDistance(p1.getLocation(), p2.getLocation());
		
		if(p2 instanceof Healthy) {
			
			double rnd= rand.nextDouble();			
			double percentage =this.contagionProbability(p2)*Math.min(1.0,0.14*Math.exp (2-(0.25*distance)));
			
			System.out.println("Random : "+rnd+"\n"+"per : "+percentage);
			
			if( percentage > rnd ) { 
				
				return true;
			}
		}
		
		return false;
	}

	
	public boolean tryToKill(Sick s) {
		double probability;
				
		if(s.getAge()<18)
			probability=0.001;
		
		else if (s.getAge()>17 &&s.getAge()<55)
			probability=0.05;
		
		else
			probability=0.10;
		
		double die=Math.max(0, probability-0.01*probability*(Math.pow(s.getContagiousTime()-15,2)));
		
		double rnd=rand.nextDouble();
		
		if( die >= rnd) {
			
			return true;
		}
		
		return false;

	}


	
}