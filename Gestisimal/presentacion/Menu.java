package Gestisimal.presentacion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Clase Para crear menús.
 * 
 * @author josemi
 * 
 */

public class Menu {
	
  // creamos array de opciones
	/**
	 * array de string opciones
	 */
  String[] opciones;

  /**
   * Crea un objeto menú con las opciones.
   * 
   * @param opciones 	Le pasamos las opciones como argumentos variables.
   */
  // igual que en la lista le pasamos un vargs constructor
  public Menu(String... opciones) {
    this.opciones = new String[opciones.length];

    // recorrer cada opcion y guardarla en el array
    for (int i = 0; i < opciones.length; i++) {
      this.opciones[i] = opciones[i];
    }
  }

  /**
   * Muestra las opciones del Menú y elige una.
   * 
   * @return opcion		Devuelve una opción.
   */
  // Mostrar el menú
  public int elegir() {
    System.out.println("Mostrar el menú");
    System.out.println("---------------");
    
    for (int i = 0; i < this.opciones.length; i++) {
      System.out.println((i + 1) + ". " + this.opciones[i]);
    }
    
    System.out.println("\nIntroduce una opcion: ");
    
    // comprobar las opciones
    @SuppressWarnings("resource")
    Scanner s = new Scanner(System.in);
    int opcion = s.nextInt();
    s.nextLine();
    while (opcion <= 0 || opcion > this.opciones.length) {
      System.out.println("Opción incorrecta vuelva a introducirla: ");
      opcion = s.nextInt();
    }
    return opcion;
  }

  /**
   * Devuelve una representación en cadena del objeto.
   */
  // método toString
  @Override
  public String toString() {
    return "Menu [opciones=" + Arrays.toString(opciones) + "]";
  }
}
