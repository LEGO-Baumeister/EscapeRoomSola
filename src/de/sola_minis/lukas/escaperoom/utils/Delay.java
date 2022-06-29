package de.sola_minis.lukas.escaperoom.utils;

public class Delay {

	public static void delay(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
}
