package de.luke.naruto.program;


public class Boot {

	public static void main(String[] args) {
		
		if (Zufallszahl.Zufall() > 10) {
			hello("Max", Zufallszahl.Zufall());
		
		}else {hello("Tom", Zufallszahl.Zufall());}
		
		
	}
	
	public static void hello(String name, int age) {
		
		String hello = "Guten Tag! Mein Name ist " + name + " und ich bin " + age + " Jahre alt.";
		System.out.println(hello);
	}

}


