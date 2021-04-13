package Virus;
import java.util.Random;

import Location.Point;
import Population.*;


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
		
		Sick s1= (Sick) p1;
		
		Sick s2;
		
		if(!(p2 instanceof Sick)) {
			
			double rnd= rand.nextDouble();			
			double percentage =this.contagionProbability(p2)*Math.min(1.0,0.14*Math.exp (2-(0.25*distance)));
			
			System.out.println(rnd+", "+percentage);
			
			if( percentage < rnd ) { 
				
				
				s2=new Sick(p2.getAge(),p2.getLocation(),p2.getSettlement(),0,s1.getVirus());
				
				p2.getSettlement().getPeople().add(s2);
				
				s2.getSettlement().getPeople().remove(p2);
				
				s2.getSettlement().printPeople();
				
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



}