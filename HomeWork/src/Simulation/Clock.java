package Simulation;

import java.time.LocalDateTime;
import java.util.Date;

public class Clock {

	
	private static long clock;
	
	private static long ticksPerDay=1L;
	
	public static long now() {
		
		long time = new Date().getTime();
		
		clock=time;
		
		return time;
	}
	
	public long calcTime(long time) {
		
		return (long) Math.ceil((this.now()-time)/this.ticksPerDay);
	}
	
	public static void nextTick() {
		clock+=1;
	}
	
	public static long getTicksPerDay() {
		return ticksPerDay;
	}

	public static void setTicksPerDay(int ticksPerDay) {
		Clock.ticksPerDay = ticksPerDay;
	}
}