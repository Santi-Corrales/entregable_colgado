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
		
		int rondas;
		Scanner eleccion = new Scanner(System.in);
		Scanner nomb_jug = new Scanner(System.in);
		
		//para el caso de 2 jugadores 
		while (jugadores == 2) {
			//preguntamos los nombres de los jugadores
			System.out.println("Introduzca el nombre del jugador 1 (administrador):");
			String nombre1 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 2:");
			String nombre2 = nomb_jug.nextLine();
			System.out.println(" ");
			System.out.println(nombre1 + " será el administrador");
			System.out.println(nombre2 + " adivinará la palabra");
			
			//preguntamos las rondas
			System.out.println(" ");
			System.out.println("¿Cuántas rondas desean jugar?");
			rondas = eleccion.nextInt();
			System.out.println(" ");
			System.out.println("De acuerdo, el número de rondas serán " + rondas);
			//bucle principal que proporciona las rondas elegidas 
			for (int ronda = 1; ronda <= rondas; ronda++) {
				System.out.println("Ronda " + ronda);

				Scanner palabra = new Scanner(System.in);
				System.out.println(nombre1 + " elija una palabra: ");
				String palabraS = palabra.nextLine();

				Scanner letras = new Scanner(System.in);

				// definimos nuestras variables
				String palabraSecreta = palabraS;
				int intentosMaximos = 6;
				int intentos = 0;
				int palabraAdivinada = 0;

				// iniciamos nuestro primer Array para las letras adivinadas, seguidamente el
				// FOR representará con guión bajo las letras no adivinadas
				char[] letrasAdivinadas = new char[palabraSecreta.length()];
				for (int i = 0; i < letrasAdivinadas.length; i++) {
					letrasAdivinadas[i] = '_';
				}
				// comienza un bucle while que continuará mientras no se adivine la palabra o no se alcancen los intentos máximos
				while (palabraAdivinada == 0 && intentos < intentosMaximos) {
					System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("
							+ palabraSecreta.length() + " letras)");
					System.out.println("Introduce una letra, por favor");
					// lee la letra pasandolas a minúsculas y recogiendo solo la posición 0
					char letra = Character.toLowerCase(letras.next().charAt(0));

					int letraCorrecta = 0;
					// con este for recorremos la palabra secreta y comprueba si la letra ingresada
					// equivale a una de las letras de la palabra
					for (int i = 0; i < palabraSecreta.length(); i++) {
						if (palabraSecreta.charAt(i) == letra) {
							letrasAdivinadas[i] = letra;
							letraCorrecta = 1;
						}
					}
					// si no se encuentra la letra, se incrementa el contador de intentos.
					if (letraCorrecta == 0) {
						intentos++;
						System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
					}
					// si todas las letras han sido adivinadas, ganará el jugador 2
					if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
						palabraAdivinada = 1;
						System.out.println(
								"¡Felicidades " + nombre2 + "! Has adivinado la palabra secreta: " + palabraSecreta);
					}
				}
				// condicional para cuando no haya mas intentos
				if (palabraAdivinada == 0) {
					System.out.println("¡" + nombre2 + " te has quedado sin intentos!");
				}
			}
			System.out.println("¡Gracias por jugar! El juego ha terminado.");
			break;
		}
		//para el caso de 3 jugadores (NOTA: como el caso es el mismo pero adaptado a 3 jugadores no comentaré todo lo visto anteriormente)
		while (jugadores == 3) {

			System.out.println("Introduzca el nombre del jugador 1 (administrador):");
			String nombre1 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 2:");
			String nombre2 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 3:");
			String nombre3 = nomb_jug.nextLine();

			System.out.println(" ");
			System.out.println(nombre1 + " será el administrador");
			System.out.println(nombre2 + " " + "y" + " " + nombre3 + " adivinarán la palabra");

			System.out.println("¿Cuantas rondas desean jugar?");
			rondas = eleccion.nextInt();
			System.out.println(" ");
			System.out.println("De acuerdo, el número de rondas serán " + rondas);
			//definimos nuestra variable de tipo INT la cual más adelante nos podra mostrar quién ha ganado mas rondas
			int rondasGanadasJugador2 = 0;
			int rondasGanadasJugador3 = 0;

			for (int ronda = 1; ronda <= rondas; ronda++) {
				System.out.println("Ronda " + ronda);

				Scanner palabra = new Scanner(System.in);
				System.out.println(nombre1 + " elija una palabra: ");
				String palabraS = palabra.nextLine();

				String palabraSecreta = palabraS;
				int intentosMaximos = 6;
				int palabraAdivinada = 0;

				char[] letrasAdivinadas = new char[palabraSecreta.length()];
				for (int i = 0; i < letrasAdivinadas.length; i++) {
					letrasAdivinadas[i] = '_';
				}
				
				int intentosJugador2 = 0;
				int intentosJugador3 = 0;

				while (palabraAdivinada == 0
						&& (intentosJugador2 < intentosMaximos || intentosJugador3 < intentosMaximos)) {

					System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("
							+ palabraSecreta.length() + " letras)");
					//para el turno del jugador 2 
					if (intentosJugador2 < intentosMaximos) {
						System.out.println("Es el turno de " + nombre2 + " para adivinar.");
						Scanner letras = new Scanner(System.in);
						System.out.println("Introduce una letra, por favor:");
						char letra2 = Character.toLowerCase(letras.next().charAt(0));

						int letraCorrecta2 = 0;
						for (int i = 0; i < palabraSecreta.length(); i++) {
							if (palabraSecreta.charAt(i) == letra2) {
								letrasAdivinadas[i] = letra2;
								letraCorrecta2 = 1;
							}
						}

						if (letraCorrecta2 == 0) {
							intentosJugador2++;
							System.out.println(
									"¡Incorrecto! Te quedan " + (intentosMaximos - intentosJugador2) + " intentos.");
						}

						if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
							palabraAdivinada = 1;
							System.out.println("¡Felicidades " + nombre2 + "! Has adivinado la palabra secreta: "
									+ palabraSecreta);
							rondasGanadasJugador2++; //en este caso le subimos un contador a las rondas ganadas
						}
					}
					//para el turno del jugador 3
					if (intentosJugador3 < intentosMaximos && palabraAdivinada == 0) {
						System.out.println("Es el turno de " + nombre3 + " para adivinar.");
						Scanner letras = new Scanner(System.in);
						System.out.println("Introduce una letra, por favor:");
						char letra3 = Character.toLowerCase(letras.next().charAt(0));

						int letraCorrecta3 = 0;
						for (int i = 0; i < palabraSecreta.length(); i++) {
							if (palabraSecreta.charAt(i) == letra3) {
								letrasAdivinadas[i] = letra3;
								letraCorrecta3 = 1;
							}
						}

						if (letraCorrecta3 == 0) {
							intentosJugador3++;
							System.out.println(
									"¡Incorrecto! Te quedan " + (intentosMaximos - intentosJugador3) + " intentos.");
						}

						if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
							palabraAdivinada = 1;
							System.out.println("¡Felicidades " + nombre3 + "! Has adivinado la palabra secreta: "
									+ palabraSecreta);
							rondasGanadasJugador3++; //en este caso le subimos un contador a las rondas ganadas
						}
					}
				}

				if (palabraAdivinada == 0) {
					System.out.println(
							"¡Ninguno de los jugadores ha adivinado la palabra! La palabra era: " + palabraSecreta);
				}
			}
			//hacemos un condicional de comparación para printar nuestro resultado final
			System.out.println(" ");
			System.out.println("Conteo de rondas y ganador del juego");
			if (rondasGanadasJugador2 > rondasGanadasJugador3) {
				System.out.println(nombre2 + " ha ganado más rondas (" + rondasGanadasJugador2 + " rondas).");
			} else if (rondasGanadasJugador3 > rondasGanadasJugador2) {
				System.out.println(nombre3 + " ha ganado más rondas (" + rondasGanadasJugador3 + " rondas).");
			} else {
				System.out.println("Ambos jugadores han ganado el mismo número de rondas.");
			}

			System.out.println("¡Gracias por jugar!");	
			break;
		}
		
		while (jugadores == 4) {
			System.out.println("Introduzca el nombre del jugador 1(administrador):");
			String nombre1 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 2:");
			String nombre2 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 3:");
			String nombre3 = nomb_jug.nextLine();
			System.out.println("Introduzca el nombre del jugador 4:");
			String nombre4 = nomb_jug.nextLine();

			
			break;
		}
	
	}

}

