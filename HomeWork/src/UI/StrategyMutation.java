package UI;
import Virus.IVirus;

public class StrategyMutation {
	private IVirus virus;

	public StrategyMutation(IVirus virus){
		  this.virus = virus;
	}

	public String executeStrategy(){
		  return virus.getName();
	}
}