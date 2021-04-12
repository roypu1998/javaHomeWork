package Simulation;

public class Clock {
	
	private static long clock;
	
	public static long now() {
		long time = System.nanoTime();
		clock=time;
		return time;
	}
	
	public static void nextTick() {
		clock+=1;
	}

}