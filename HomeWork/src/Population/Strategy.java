package Population;

public class Strategy {
	   private Person person;

	   public Strategy(Person person){
	      this.person = person;
	   }

	   public double executeStrategy(){
	      return person.contagionProbability();
	   }
	}