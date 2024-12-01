package entregable_colgadoP3;

import java.util.Scanner;

public class colgadoP3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reglas = new Scanner(System.in);

		System.out.println("¡Bienvenido al juego del colgado!");
		System.out.println(" ");
		System.out.println("¿Desea conocer las reglas del juego? (Sí/No)");
		String conocer = reglas.nextLine();
		//con esta secuencia if-else preguntamos si desean conocer las reglas, con su correspondiente prints para cada opción 
		if (conocer.equalsIgnoreCase("Sí")) {
			System.out.println("Las reglas son las siguientes:");
			System.out.println(" ");
			System.out.println(
					"1. El juego comienza pidiendo al administrador (un jugador) que elija una palabra secreta, la cual debe ser oculta durante el juego.");
			System.out.println("2. Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.");
			System.out.println("3. El número máximo de intentos por jugador es 6.");
			System.out.println(
					"4. Si un jugador adivina correctamente una letra, esta se revela en su posición en la palabra secreta.");
			System.out.println("5. Si un jugador se queda sin intentos, pierde la ronda");
			System.out.println(
					"6. El jugador que adivine toda la palabra primero o quien gane más rondas será el ganador");
			System.out.println(" ");
			System.out.println("¡Empezamos el juego!");
			System.out.println(" ");
		} else if (conocer.equalsIgnoreCase("No")) {
			System.out.println("¡De acuerdo!");
			System.out.println("¡Empezamos el juego!");
			System.out.println(" ");
		} else {
			System.out.println("Ninguna opción elegida.");
			System.out.println("¡Empezamos el juego!");
			System.out.println(" ");
		}
		//preguntamos por los jugadores y lo guardamos en nuestra variable JUGADORES, la cual será importante más adelante
		System.out.println("Ahora elija cuantos jugadores desean jugar (2-3-4):");
		System.out.println("2 jugadores");
		System.out.println("3 jugadores");
		System.out.println("4 jugadores");
		System.out.println(" ");
		int jugadores = reglas.nextInt();
		//para una opción no valida de opcion de jugadores 
		if (jugadores == 2 || jugadores == 3 || jugadores == 4) {
			System.out.println("Has elegido " + jugadores + " jugadores.");
		} else {
			System.out.println("Opción no válida. Debe elegir entre 2, 3 o 4 jugadores.");
		}
		
		
	
	}

}

