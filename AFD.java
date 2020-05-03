import javax.swing.JOptionPane;
import java.util.*;

public class AFD {

	public static void main(String[] args) {
		// Alfabeto para AFD
		char[] alfabeto = { 'D', 'F', 'N', 'O', 'P', 'S' };
		//ArrayList para un manejo mejor de los simbolos del alfabeto
		ArrayList<Character> symbols = new ArrayList<>();
		
		//Llenado de la lista
		for (int i = 0; i < alfabeto.length; i++) {
			symbols.add(alfabeto[i]);
		}
		//Filas para matriz de transiciones
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
		
		//Numero de estados del AFD
		short numEstados = 12;

		//Matriz de transiciones
		ArrayList<int[]> matrizTransiciones = new ArrayList<int[]>();
		for(int i = 0; i < numEstados; i++){
			matrizTransiciones.add(matriz[i]);
		}

		//Lista para consultar si el estado al que se llegó es un estado final
		ArrayList<Integer> estadosFinales = new ArrayList<>();
		estadosFinales.add(1);
		estadosFinales.add(3);
		estadosFinales.add(9);

		//Aqui se lee la cadena a revisar si es aceptado por el AFD.
		
		//Bandera
		int banderaPalabra = 0;
		while(banderaPalabra == 0){
			//Ecuación dada por el usuario
			String myEquation = JOptionPane.showInputDialog("Ingrese la palabra:"); //5+4*(2/8+2)
			//Cadena resultante dada una ecuación
			String myString = "";
			//Temporal que recibe cada caracter de la cadena ecuación
			int temp;
			for(int i = 0; i < myEquation.length(); i++){
				temp = myEquation.charAt(i);
				if(temp == 40) myString += "P";
				else if(temp == 41) myString += "F";
				else if(temp == 42 || temp == 47 || temp == 94) myString += "O";
				else if(temp == 46) myString += "D";
				else if(temp >= 48 && temp <= 57) myString += "N";
				else if(temp == 43 || temp == 45) myString += "S";
				else {																	
					JOptionPane.showMessageDialog(null, "RECHAZADA: La palabra contiene simbolos que no pertenecen al alfabeto " + myEquation.charAt(i));
					break;
				}
			}

			//Variables necesarias para iterar a través de la matriz de transiciones
			int estado = 0, columna = 0; 
			
			//Movimiento por la tabla de transiciones siguiendo la lectura de la cadena a revisar.
			for (int j = 0; j < myString.length(); j++) {
				if(symbols.contains(myString.charAt(j))) {	//Condici�n para revisar que el simbolo le�do pertenezca al alfabeto.							//Condici�n para revisar que el simbolo le�do pertenezca al alfabeto.
					columna = symbols.indexOf(myString.charAt(j));
					estado = matrizTransiciones.get(estado)[columna];
					
				}	
			}
			//Bloque para revisar si la cadena fue admitida.			
			if (estadosFinales.contains(estado)) {										
				JOptionPane.showMessageDialog(null, "ACEPTADA: Cadena permitida");
			}else {
				JOptionPane.showMessageDialog(null, "RECHAZADA: Cadena no permitida");
			}
			//¿Continuamos revisando ecuaciones?
			banderaPalabra = JOptionPane.showConfirmDialog(null, "Confirmar", "Ingresar otra palabra", JOptionPane.DEFAULT_OPTION);
		}
	return;
	}

}