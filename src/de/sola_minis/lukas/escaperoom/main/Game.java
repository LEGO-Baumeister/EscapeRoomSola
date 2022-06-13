package de.sola_minis.lukas.escaperoom.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
	
	private void listenForCommand(String command) {
		switch (command) {
		case "help":
			help();
			break;
		default:
			break;
		}
	}
	
	private void login() throws IOException {
		if(textInput("Benutzername", "1")) {
			if(textInput("Passwort", "2")) {
				System.out.println("Welcome back, Lukas!");
			} else {
				System.err.println("Falscher Nutzername oder falsches Passwort\n");
				login();
			}
		} else {
			textInput("Passwort", "");
			System.err.println("Falscher Nutzername oder falsches Passwort\n");
			login();
		}
	}
	
	private void help() {
		System.out.println("Das ist das Hilfe-Menü\nHier ist eine Übersicht über alle verfügbaren Befehle:");
		System.out.println("logout		Sie werden abgemeldet und das Login Fenster erscheint");
		System.out.println("info		Zeigt die relevanten Systeminformationen");
		System.out.println("help		Ruft das Hilfe-Menü auf mit einer Übersicht über alle Befehle und ihre Funktion");
		System.out.println("rndm		Benutzung: 'rndm <a> <b>' Generiert eine Zufallszahl zwischen a und b");
		System.out.println("secret      	Benutzung: 'secret <plus>-<dreieck>-<hexagon>-<Y>-<quadrat>-<stern>-<mond>-<L>-<raute>-<kreis>'");
		System.out.println("Weitere Informationen zu den Tools finden Sie in der Befehlszeilenreferenz in der Online-Hilfe.");
	}

}
