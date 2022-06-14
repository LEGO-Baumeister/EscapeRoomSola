package de.sola_minis.lukas.escaperoom.utils;

public class LoadingCircle {

	private String[] frames = { "|", "/", "-", "\\" };

	public void startCircle(long timePerStep, int steps) {
		for (int i = 0; i < steps; i++) {
			System.out.print(frames[i%4] + "\r");
			try {
				Thread.sleep(timePerStep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
