package Virus;
import Population.*;


public class SouthAfricanVariant implements IVirus{
	
	public double contagionProbability(Person p) {
		
		double contagionprobability;
		
		if (p.getAge() < 18 )
		
			contagionprobability = 0.6;
		
		else 
			contagionprobability = 0.5;
		
		return contagionprobability*p.contagionProbability());
		
	public boolean tryToContagion(Person p1, Person p2) {		
			
			
			
	}

	
	public boolean tryToKill(Sick s) {
		double probability;
		if(s.getAge()<18)
			probability=0.05;
		else
			probability=0.08;
		double die=Math.max(0, probability-0.01*probability*(Math.pow(s.getContagiousTime()-15,2)));
		
		return
	}



}