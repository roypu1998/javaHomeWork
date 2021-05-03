package Virus;
import java.util.Random;
import Location.Point;
import Population.*;
import Simulation.Clock;

public class BritishVariant implements IVirus{
	
	Random rand = new Random();

	public double contagionProbability(Person p) {
		Clock c= new Clock();
		long time=c.calcTime( ((Sick) p).getContagiousTime());
		if (time<5)
			return 0;
		return 0.70*p.contagionProbability();
	}

	
	public double calcDistance(Point p1 , Point p2) {
		
		int x1=p1.getX(),x2=p2.getX(),y1=p1.getY(),y2=p2.getY();
		
		double d=(Math.pow((x1-x2), 2))+(Math.pow((y1-y2),2));
		
		return Math.sqrt(d);
	}
	@Override
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

	@Override
	public boolean tryToKill(Sick s) {
		
		int t=new Clock().calcTime(s.getContagiousTime());

		double probability;
		
		if(s.getAge()<18)
			probability=0.01;
		
		else
			probability=0.10;
		
		double die=Math.max(0, probability-0.01*probability*(Math.pow(t-15,2)));
		
		double rnd=rand.nextDouble();
		
		if( die >= rnd) {
			return true;
		}
		
		return false;

	}
	
	/*
	 * public String toString() { return "BritishVariant"; }
	 */
}