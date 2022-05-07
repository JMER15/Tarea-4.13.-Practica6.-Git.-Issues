package Gestisimal.presentacion;

import java.util.Scanner;
import Gestisimal.negocio.Almacen;
import Gestisimal.negocio.AlmacenCodigoNoExisteException;
import Gestisimal.negocio.AlmacenNombreMarcaException;
import Gestisimal.negocio.ArticuloIllegalErrorArgumentException;
import Gestisimal.negocio.ArticuloStockException;
import static Gestisimal.util.Util.*;

/**
 * Queremos modelar un test para nuestro almacén de ariculos en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>1. Añadir Artículo.</li>
 * <li>2. Borrar Artículo.</li>
 * <li>3. Añadir unidades al Artículo.</li>
 * <li>4. Decrementar unidades al Artículo.</li>
 * <li>5. Impresión ALmacén.</li>
 * <li>6. Modificar Artículo.</li>
 * <li>7. Exportar Artículo a JSON.</li>
 * <li>8. Importar JSON.</li>
 * <li>9. Exportar Artículo a XML.</li>
 * <li>10. Importar XML.</li>
 * <li>11. Finalizar.</li>
 * </ol>
 * 
 * @author José Miguel
 * 
 */

public class TestMenuAlmacen {

	/**
	 * Constante
	 */
  private static final int TERMINAR = 11;

  /**
   * Objeto creado de la clase Almacen
   */
  private static Almacen almacen1 = new Almacen();
 
 
  /**
   * 
   * @param args  Devuelve los argumentos del main.
   */
  public static void main(String[] args) {

    // creamos el método menú
	/**
	 * Inicio del programa.
	 */
    Menu menu = crearMenu();

    int opcion;
    do {
      opcion = menu.elegir();
      switch (opcion) {
        case 1:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          pedirDatos();
          System.out.println();
          break;
        case 2:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          borrarArticulo();
          break;
        case 3:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          aumentoUnidades();
          break;
        case 4:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          decrementoUnidades();
          break;
        case 5:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          System.out.println(almacen1.toString() + "\n");
          break;
        case 6:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          modificarArticulo();
          break;
        case 7:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          pedirFicheroJson();
          System.out.println();
          break;
        case 8:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          almacen1.importarJson();
          break;
        case 9:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          pedirFicheroXML();;
          break;
        case 10:
          System.out.println("\nHe escogido la opción " + opcion + ".\n");
          almacen1.importarXML();
          break;
      }
    } while (opcion != TERMINAR);
    System.out.println("hasta luego :))))");
  }

  /**
   * Menú para nuestra aplicación.
   * 
   * @return menu	Devuelve un objeto menú.
   */
  public static Menu crearMenu() {
    return new Menu("Añadir Artículo.", "Borrar artículo.", "Incrementar unidades almacén.",
        "Decrementar unidades almacén", "Impresión del almacén", "Modificar Artículo",
        "Exportar A JSON", "Importar JSON", "Exportar A XML", "Importar XML", "Finalizar");
  }

  /**
   * Pide datos al usuario
   */
  private static void pedirDatos() {
    try {

      almacen1.add(readStr("Nombre artículo a dar de alta"), readStr("Marca"),
          readDouble("Precio de Compra"), readDouble("Precio de Venta"),
          readInt("Número de Unidades"), readInt("Stock Minimo"), readInt("Stock Máximo"));

      System.out.println("\nArtículo insertado correctamente.");

    } catch (AlmacenNombreMarcaException e) {
      System.err.println("Error el artículo que desea añadir ya esta en el almacén.");
    } catch (ArticuloIllegalErrorArgumentException e) {
      System.err.println("\nError: " + e.getMessage() + "\n");
    }

  }
  
  /**
   * Pide un fichero Json.
   */
  private static void pedirFicheroJson() {
    String fichero = readStr("Dime el nombre del fichero json");
    almacen1.exportarJson(fichero);
  }
  
  /**
   * Pide un fichero XML.
   */
  private static void pedirFicheroXML() {
    String fichero = readStr("Dime el nombre del fichero xml");
    almacen1.exportarXML(fichero);
  }

  /**
   * Borra Artículo pidiendo el código
   */
  @SuppressWarnings("resource")
  private static void borrarArticulo() {
    try {

      Scanner sc = new Scanner(System.in);
      System.out.println("Dime el código de artículo a borrar: ");
      int codigo = sc.nextInt();sc.nextLine();
      almacen1.delete(codigo);sc.nextLine();

      System.out.println("Se ha borrado el código del artículo: " + codigo + "\n");

    } catch (AlmacenCodigoNoExisteException e) {
      System.err.println("\nEl código no existe.\n");
      e.printStackTrace();
    }

  }

  /**
   * Aumenta Unidades del almacén. Pide las Unidades.
   * 
   */
  private static void aumentoUnidades() {
    try {
      
      almacen1.addUnidades(readInt("Dime el código del artículo: "),
          readInt("Dime la cantidad de unidades para aumentar: "));

      System.out.println("Unidades aumentadas con éxito.");

    } catch (AlmacenCodigoNoExisteException e) {
      e.getMessage();
      e.printStackTrace();
    } catch (ArticuloIllegalErrorArgumentException e) {
      System.err.println("Error: " + e.getMessage());
    }

  }

  /**
   * Decrementa unidades del almacén. Pide las unidades.
   */
  private static void decrementoUnidades() {

    try {

      almacen1.removeUnidades(readInt("Dime el código del artículo: "),
          readInt("Dime la cantidad de unidades para decrementar: "));

      System.out.println("Unidades decrementadas correctamente.");

    } catch (AlmacenCodigoNoExisteException e) {
      System.err.println("\nError el código no existe en almacén.\n");
    } catch (ArticuloStockException e) {
      System.err.println("\nERROR: " + e.getMessage() + "\n");
    } catch (ArticuloIllegalErrorArgumentException e) {
      System.err.println("ERROR: " + e.getMessage());
    }

  }

  /**
   * Modifica Artículo. Pide el código para modificar.
   */
  private static void modificarArticulo() {

    try {

      almacen1.modificarArticulo(readInt("Dime el número del código del producto a modificar: "),
          readStr("Dime el nombre: "), readStr("Dime la marca: "),
          readDouble("Dime el precio de compra: "), readDouble("Dime le precio de venta al público: "),
          readInt("Número de unidades: "), readInt("Stock Máximo: "), readInt("Stock Mínimo: "));

      System.out.println("\nÁrticulo modificado correctamente.\n");

    } catch (AlmacenCodigoNoExisteException e) {
      System.err.println("\nError el código no existe en almacén.\n");
    } catch (AlmacenNombreMarcaException e) {
      System.err.println("\nERROR: " + e.getMessage() + "\n");
    } catch (ArticuloIllegalErrorArgumentException e) {
      System.err.println("ERROR: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("El formato numérico introducido no es correcto.");
    }
  }
}
