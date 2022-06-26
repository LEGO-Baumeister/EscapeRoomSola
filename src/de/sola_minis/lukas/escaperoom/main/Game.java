package de.sola_minis.lukas.escaperoom.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import de.sola_minis.lukas.escaperoom.utils.LoadingBar;
import de.sola_minis.lukas.escaperoom.utils.LoadingCircle;

public class Game {
	//TEST
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
			printEmptyLine();
			lc.startCircle(150, 10);
			if(textInput("Passwort", "%yh6W7Aj?gK;8x")) {
				printEmptyLine();
				lb.startBar(250);
				System.out.println("Willkommen zurück, Michael Hoffmann!\nDu bist als Administrator angemeldet.");
			} else {
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
		lc.startCircle(150, 10);
		System.out.println("Zufallszahl: " + random.nextInt(100));
	}
	
	private void info() {
		System.out.println("Labor Software [Version 10.0.19043.1706]");
		System.out.println("(c) SoLa Corporation and M&M Maschinenverleih. All rights reserved.");
		System.out.println("Developer Contact: https://bit.ly/39Axy5M");
	}
	
	private void unlock(int code) {
		if (code==1420) {
			System.err.println("Sicherheitshinweis:");
			System.out.println("Alle elektronischen Türen und Verriegelungen wurden entriegelt!");
		} else {
			System.err.println("Falsche Code eingabe.\nDas System wird für 120 Sekunden gesperrt.");
			lb.startBar(6000);
			System.out.println("System freigegeben.");
		}
	}
	
	private void printEmptyLine() {
		System.out.println("");
	}
	
	private void help() {
		System.out.println("Das ist das Hilfe-Menü\nHier ist eine Übersicht über alle verfügbaren Befehle.");
		printEmptyLine();
		System.out.println("<========================================[Befehle:]========================================>");
		System.out.println("logout		Sie werden abgemeldet und das Login Fenster erscheint");
		System.out.println("info		Zeigt die relevanten Systeminformationen");
		System.out.println("help		Ruft das Hilfe-Menü auf mit einer Übersicht über alle Befehle und ihre Funktion");
		System.out.println("rndm		Generiert eine Zufallszahl zwischen 0 und 100");
		System.out.println("unlock      	Benutzung: 'unlock <code>'");
		System.out.println("<========================================[^^^^^^^^]========================================>");
		printEmptyLine();
		System.out.println("Weitere Informationen zu den Tools finden Sie in der Befehlszeilenreferenz in der Online-Hilfe.");
		printEmptyLine();
	}

}
