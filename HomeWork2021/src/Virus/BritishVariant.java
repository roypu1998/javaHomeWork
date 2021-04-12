package Virus;

import Population.*;

public class BritishVariant implements IVirus{

	public double contagionProbability(Person p) {
		return 0.70*p.contagionProbability();
	}

	@Override
	public boolean tryToContagion(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryToKill(Sick s) {
		double probability;
		if(s.getAge()<18)
			probability=0.01;
		else
			probability=0.10;
		double die=Math.max(0, probability-0.01*probability*(Math.pow(s.getContagiousTime()-15,2)));

		return 

	}
	
	

}