package de.sola_minis.lukas.escaperoom.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.sola_minis.lukas.escaperoom.utils.LoadingBar;
import de.sola_minis.lukas.escaperoom.utils.LoadingCircle;

public class Game {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	LoadingBar lb = new LoadingBar();
	LoadingCircle lc = new LoadingCircle();

	public void start() throws IOException {
		login();
		listenForCommand(br.readLine());
	}

	public boolean textInput(String label, String check) throws IOException {
		System.out.print(label + ": ");
		String input = br.readLine();
		if (input.equals(check)) {
			return true;
		}
		return false;
	}
	
	private void listenForCommand(String command) throws IOException {
		switch (command) {
		case "help":
			help();
			listenForCommand(br.readLine());
			break;
		case "logout":
			logout();
			listenForCommand(br.readLine());
			break;
		default:
			System.err.println("Error: '" + command + "' " + "wird nicht als interner oder externer Befehl erkannt.");
			listenForCommand(br.readLine());
			break;
		}
		printEmptyLine();
	}
	
	private void login() throws IOException {
		if(textInput("Benutzername", "1")) {
			printEmptyLine();
			lc.startCircle(150, 100);
			if(textInput("Passwort", "2")) {
				printEmptyLine();
				lb.startBar(250);
				System.out.println("Willkommen zurück, Lukas!");
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
		System.out.println("rndm		Benutzung: 'rndm <a> <b>' Generiert eine Zufallszahl zwischen a und b");
		System.out.println("secret      	Benutzung: 'secret <plus>-<dreieck>-<hexagon>-<Y>-<quadrat>-<stern>-<mond>-<L>-<raute>-<kreis>'");
		System.out.println("<========================================[^^^^^^^^]========================================>");
		printEmptyLine();
		System.out.println("Weitere Informationen zu den Tools finden Sie in der Befehlszeilenreferenz in der Online-Hilfe.");
		printEmptyLine();
	}

}
