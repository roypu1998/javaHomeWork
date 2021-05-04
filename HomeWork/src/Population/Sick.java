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
		int num=0;
		for(int i=0; i<this.getSettlement().getNotSickPpl().size();i++) {
			if(this.getSettlement().getNotSickPpl().get(i) instanceof Convalescent)
				num++;
		}
		System.out.println(num);
		Convalescent c= new Convalescent(this.getAge(), this.getLocation(), this.getSettlement(), this.getVirus());
		this.getSettlement().getPeople().remove(this);
		this.getSettlement().addPerson(c);
		this.getSettlement().getSickPpl().remove(this);
		return c;
	}
	
	public boolean tryToDie(){
		return this.virus.tryToKill(this);
		
	}

	
	public double contagionProbability() {
		return 0.001;
	}
	
	/*
	 * public String toString() { return
	 * "Sick {age= "+super.getAge()+" location= "+super.getLocation().toString()+
	 * " settlement= "+ super.getSettlement().toString()+ "contagiousTime= "+
	 * this.contagiousTime+ " virus= "+ this.virus.toString()+"}"; }
	 */

}