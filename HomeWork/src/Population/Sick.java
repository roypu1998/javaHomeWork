package Population;
import Virus.IVirus;
import Country.Settlement;
import Location.Point;
import Simulation.Clock;
public class Sick extends Person{
	
	private long contagiousTime;
	
	private IVirus virus;
	
	
	
	public Sick(int age,Point p,Settlement s,long con,IVirus vir){
		
		super(age,p,s);
		
		this.contagiousTime=con;
		this.virus=vir;
	}
	
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
		Healthy h= new Healthy(this.getAge(), this.getLocation(), this.getSettlement());
		this.getSettlement().addPerson(h);
		this.getSettlement().getPeople().remove(this);
		return h;
	}
	
	public boolean tryToDie(){
		return this.virus.tryToKill(this);
		
	}

	
	public double contagionProbability() {
		return 0.001;
	}
	
	public String toString() {
		return "Sick {"+super.toString()+
				"contagiousTime= "+ this.contagiousTime+
				" virus= "+ this.virus.toString()+"}";
	}

}