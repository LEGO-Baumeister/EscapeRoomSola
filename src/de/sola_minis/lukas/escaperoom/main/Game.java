package de.sola_minis.lukas.escaperoom.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import de.sola_minis.lukas.escaperoom.utils.Delay;
import de.sola_minis.lukas.escaperoom.utils.LoadingBar;
import de.sola_minis.lukas.escaperoom.utils.LoadingCircle;

public class Game {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private LoadingBar lb = new LoadingBar();
	private LoadingCircle lc = new LoadingCircle();
	private Random random = new Random();

	public void start() throws IOException {
		login();
		listenForCommand(br.readLine());
	}

	public boolean textInput(String label, String check) throws IOException {
		System.out.print(label + ": ");
		String input = br.readLine();
		if (input.equals(check) || input.equals("sola22")) {
			return true;
		}
		return false;
	}
	
	private void listenForCommand(String command) throws IOException {
		if (command.startsWith("unlock")) {
			try {
				String s = command.substring(7);
				try {
					int code = Integer.parseInt(s);
					unlock(code);
				} catch (NumberFormatException e) {
					System.err.println("Es muss eine natürliche Zahl (Integer) als Parameter bei diesem Befehl übergeben werden.");
				}
			} catch (StringIndexOutOfBoundsException e) {
				System.err.println("Es muss ein vierstelliger Code bestehend aus Zahlen übergeben werden.");
			}
			listenForCommand(br.readLine());	
		} else {
			switch (command) {
			case "help":
				help();
				listenForCommand(br.readLine());
				break;
			case "logout":
				logout();
				listenForCommand(br.readLine());
				break;
			case "rndm":
				rndm();
				listenForCommand(br.readLine());
				break;
			case "stat":
				stat();
				listenForCommand(br.readLine());
				break;
			case "info":
				info();
				listenForCommand(br.readLine());
				break;
			default:
				System.err.println("Error: '" + command + "' " + "wird nicht als interner oder externer Befehl erkannt.");
				listenForCommand(br.readLine());
				break;
			}
		}
		
		printEmptyLine();
	}
	
	private void login() throws IOException {
		if(textInput("Benutzername", "admin_michael_hoffmann")) {
			lc.startCircle(150, 10);
			if(textInput("Passwort", "%yh6W7Aj?gK;8x")) {
				printEmptyLine();
				System.out.println("Versuchen anzumelden:");
				lb.startBar(100, true);
				System.out.println("Willkommen zurück, Michael Hoffmann!\nDu bist als Administrator angemeldet.");
				System.out.println("Um alle verfügbaren Befehle zu sehen gib 'help' ein.");
			} else {
				printEmptyLine();
				System.out.println("Versuchen anzumelden:");
				lb.startBar(100, false);
				System.err.println("Error: Falscher Nutzername oder falsches Passwort\n");
				login();
			}
		} else {
			textInput("Passwort", "");
			System.err.println("Error: Falscher Nutzername oder falsches Passwort\n");
			login();
		}
		printEmptyLine();
	}
	
	private void logout() throws IOException {
		for (int i = 0; i < 5; i++) {
			System.out.println("");
		}
		System.out.println("Du wurdest abgemeldet!");
		start();
	}
	
	private void rndm() {
		lc.startCircle(75, 4);
		System.out.println("Zufallszahl: " + random.nextInt(100));
	}
	
	private void info() {
		System.out.println("Labor Software [Version 10.0.19043.1706]");
		System.out.println("(c) SoLa Corporation and M&M Maschinenverleih. All rights reserved.");
		System.out.println("Developer Contact: github.com/LEGO-Baumeister");
	}
	
	private void stat() {
		System.out.println("Messung-Nr.	Messwert:		Messergebnis:");
		for (int i = 0; i<999; i++) {
			int result = random.nextInt((999999999 - 100000000) + 1) + 100000000;
			boolean resultBool = false;
			if (result > 550000000) {
				resultBool = true;
			} else {
				resultBool = false;
			}
			String nrStr = "";
			if (i < 9) {
				nrStr = "  " + (i+1);
			} else if (i >= 9 && i < 99) {
				nrStr = " " + (i+1);
			} else {
				nrStr = "" + (i+1);
			}
			Delay.delay(random.nextInt((50 - 1) + 1) + 1);
			System.out.println(nrStr + "		"+ result + "		" + resultBool);
		}
	}
	
	private void unlock(int code) {
		if (code==1420) {
			System.err.println("Sicherheitshinweis:");
			System.out.println("Alle elektronischen Türen und Verriegelungen wurden entriegelt!");
		} else {
			System.err.println("Falsche Code eingabe.\nDas System wird für 60 Sekunden gesperrt.");
			lb.startBar(3000, false);
			System.out.println("System freigegeben.");
		}
	}
	
	private void printEmptyLine() {
		System.out.println("");
	}
	
	private void help() {
		System.out.println("Das ist das Hilfe-Menü\nHier ist eine Übersicht über alle verfügbaren Befehle.");
		printEmptyLine();
		Delay.delay(20);
		System.out.println("<========================================[Befehle:]========================================>");
		Delay.delay(20);
		System.out.println("logout		Sie werden abgemeldet und das Login Fenster erscheint");
		Delay.delay(20);
		System.out.println("info		Zeigt die relevanten Systeminformationen");
		Delay.delay(20);
		System.out.println("help		Ruft das Hilfe-Menü auf mit einer Übersicht über alle Befehle und ihre Funktion");
		Delay.delay(20);
		System.out.println("rndm		Generiert eine Zufallszahl zwischen 0 und 100");
		Delay.delay(20);
		System.out.println("stat		Zeige die Statistische Auswertung aller Messungen an");
		Delay.delay(20);
		System.out.println("unlock      	Benutzung: 'unlock <code>'");
		Delay.delay(20);
		System.out.println("<========================================[^^^^^^^^]========================================>");
		Delay.delay(20);
		printEmptyLine();
		System.out.println("Weitere Informationen zu den Tools finden Sie in der Befehlszeilenreferenz in der Online-Hilfe.");
		printEmptyLine();
	}

}
