package Simulation;

import java.time.LocalDateTime;
import java.util.Date;

public class Clock {

	
	private static long clock;
	
	private static long ticksPerDay=1;
	
	public static long now() {
		
		long time = new Date().getTime();
		clock=time;
		return time;
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