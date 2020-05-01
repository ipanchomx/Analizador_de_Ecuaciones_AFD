
import java.util.*;

public class AFD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creaci�n de la matriz de transiciones y un arreglo de strings para obtener el
		// alfabeto

		char[] alfabeto = { 'D', 'F', 'N', 'O', 'P', 'S' };
		ArrayList<Character> symbols = new ArrayList<>();
		for (int i = 0; i < alfabeto.length; i++) {
			symbols.add(alfabeto[i]);
			System.out.println(symbols.get(i));
		}

		int[] row1 = {2, 11, 3, 11, 10, 8};
		int[] row2 = {11, 11, 1, 0, 11, 0};
		int[] row3 = {11, 11, 1, 11, 11, 11};
		int[] row4 = {2, 11, 3, 0, 11, 0};
		int[] row5 = {11, 11, 7, 11, 11, 11};
		int[] row6 = {4, 9, 5, 10, 11, 10};
		int[] row7 = {4, 11, 5, 11, 11, 11};
		int[] row8 = {11, 9, 7, 10, 11, 10};
		int[] row9 = {2, 11, 3, 11, 11, 11};
		int[] row10 = {11, 11, 11, 0, 11, 0};
		int[] row11 = {4, 11, 5, 11, 11, 6};
		int[] row12 = {11, 11, 11, 11, 11, 11};
		int[][] matriz = { row1, row2, row3, row4, row5, row6,
						   row7, row8, row9, row10, row11, row12};
		short numEstados = 12;

		ArrayList<int[]> matrizTransiciones = new ArrayList<int[]>();
		for(int i = 0; i < numEstados; i++){
			matrizTransiciones.add(matriz[i]);
		}

		ArrayList<Integer> estadosFinales = new ArrayList<>();
		estadosFinales.add(1);
		estadosFinales.add(6);
		estadosFinales.add(9);

//		Aqu� se lee la cadena a revisar si es aceptado por el AFD.

		String myString = "NSNOPNONSNF";

		int estado = 0, columna = 0;
//		Movimiento por la tabla de transiciones siguiendo la lectura de la cadena a revisar.
		for (int j = 0; j < myString.length(); j++) {
			if(symbols.contains(myString.charAt(j))) {								//Condici�n para revisar que el simbolo le�do pertenezca al alfabeto.
				columna = symbols.indexOf(myString.charAt(j));
				estado = matrizTransiciones.get(estado)[columna];
				
			}else {																	
				System.out.println("Simbolo no permitido: " + myString.charAt(j) );
				break;
			}
			
		}
//		Bloque para revisar si la cadena fue admitida.			
		if (estadosFinales.contains(estado)) {										
			System.out.println("Cadena permitida");
		}else {
			System.out.println("Cadena no permitida");
		}

	// System.out.println("Si deseas salir ingresa -1:");
	return;
	}

}
