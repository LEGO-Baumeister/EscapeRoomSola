package de.sola_minis.lukas.escaperoom.utils;

public class LoadingBar {

	private String[] frames = { "Fortschritt: |                    |   0% \r", "Fortschritt: |#                   |   5% \r",
			"Fortschritt: |##                  |  10% \r", "Fortschritt: |###                 |  15% \r",
			"Fortschritt: |####                |  20% \r", "Fortschritt: |#####               |  25% \r",
			"Fortschritt: |######              |  30% \r", "Fortschritt: |#######             |  35% \r",
			"Fortschritt: |########            |  40% \r", "Fortschritt: |#########           |  45% \r",
			"Fortschritt: |##########          |  50% \r", "Fortschritt: |###########         |  55% \r",
			"Fortschritt: |############        |  60% \r", "Fortschritt: |#############       |  65% \r",
			"Fortschritt: |##############      |  70% \r", "Fortschritt: |###############     |  75% \r",
			"Fortschritt: |################    |  80% \r", "Fortschritt: |#################   |  85% \r",
			"Fortschritt: |##################  |  90% \r", "Fortschritt: |################### |  95% \r",
			"Fortschritt: |####################| 100% \n"};

	public void startBar(long timePerStep) {
		for (int i = 0; i < 20; i++) {
			System.out.print(frames[i]);
			try {
				Thread.sleep(timePerStep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print(frames[20]);
		System.out.println("Laden erfolgreich!");
	}

}