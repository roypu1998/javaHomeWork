package Simulation;

import java.time.LocalDateTime;
import java.util.Date;

public class Clock {

	
	private static long clock=0;
	
	private static long ticksPerDay=1L;
	
	public static long now() {
		
		return clock;
	}
	
	public int calcTime(long time) {
		return  (int) Math.ceil((this.now()-time)/this.ticksPerDay);
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