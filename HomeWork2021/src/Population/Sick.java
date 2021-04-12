package Population;
import Virus.IVirus;
import Simulation.Clock;
public class Sick extends Person{
	
	private long contagiousTime;
	
	private IVirus virus;
	
	public long getContagiousTime() {
		contagiousTime=Clock.now()-this.contagiousTime;
		return contagiousTime;
	}

	public void setContagiousTime(long contagiousTime) {
		this.contagiousTime = contagiousTime;
	}

	public IVirus getVirus() {
		return virus;
	}

	public void setVirus(IVirus virus) {
		this.virus = virus;
	}

	
	public Person recover(){
	}
	
	public boolean tryToDie(){}

	@Override
	public double contagionProbability() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}