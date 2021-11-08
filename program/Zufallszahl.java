package de.luke.naruto.program;

import java.util.Random;

public class Zufallszahl {
	
	
	public static int Zufall() {
		
		Random zufall = new Random();
		int zufallsZahl = zufall.nextInt(20);
		return zufallsZahl + 1;
		
		
	}
 
}

