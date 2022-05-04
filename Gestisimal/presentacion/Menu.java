package Gestisimal.presentacion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Muestra un menú con las siguientes opciones:
 * 
 * - Introducir (por teclado) una fecha pidiendo por teclado año, mes y día en formato dd/mm/aaaa.
 * Si no se introduce correctamente se devuelve un mensaje de error. Usa una función booleana para
 * validar la fecha.
 * 
 * - Añadir días a la fecha. Pide un número de días para sumar a la fecha introducida previamente y
 * actualiza su valor. Si el número es negativo restará los días. Esta opción sólo podrá realizarse
 * si hay una fecha introducida (se ha ejecutado la opción anterior), si no la hay mostrará un
 * mensaje de error.
 * 
 * - Añadir meses a la fecha. El mismo procedimiento que la opción anterior.
 * 
 * - Añadir años a la fecha. El mismo procedimiento que la opción 2.
 * 
 * - Comparar la fecha introducida con otra. Pide una fecha al usuario en formato dd/mm/aaaa
 * (válida, si no lo es da error) y la comparará con la que tenemos guardada, posteriormente
 * mostrará si esta fecha es anterior, igual o posterior a la que tenemos almacenada y el número de
 * días comprendido entre las dos fechas.
 * 
 * - Mostrar la fecha en formato largo (ejemplo: "lunes, 1 de febrero de 2021").
 * 
 * - Terminar.
 * 
 * Consideraciones a tener en cuenta:
 * 
 * El menú lo hacemos con una clase a la que llamaremos Menú, esa clase permitirá ir añadiendo
 * opciones y escoger alguna opción. Las fechas las manejaremos con la clase LocalDate.
 * 
 * @author josemi
 *
 */

public class Menu {
  // creamos array de opciones
  String[] opciones;

  // igual que en la lista le pasamos un vargs constructor
  public Menu(String... opciones) {
    this.opciones = new String[opciones.length];

    // recorrer cada opcion y guardarla en el array
    for (int i = 0; i < opciones.length; i++) {
      this.opciones[i] = opciones[i];
    }
  }

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

  // método toString
  @Override
  public String toString() {
    return "Menu [opciones=" + Arrays.toString(opciones) + "]";
  }
}
