package Virus;

import Population.*;
import java.math.*;



public class ChineseVariant implements IVirus {
	

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

	public boolean tryToContagion(Person p1, Person p2) {
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
		
		return 

	}


	
}