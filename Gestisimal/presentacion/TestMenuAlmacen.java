package Gestisimal.presentacion;

import java.util.Scanner;
import Gestisimal.negocio.Almacen;
import Gestisimal.negocio.AlmacenCodigoNoExisteException;
import Gestisimal.negocio.AlmacenNombreMarcaException;
import Gestisimal.negocio.ArticuloIllegalErrorArgumentException;
import Gestisimal.negocio.ArticuloStockException;
import static Gestisimal.util.Util.*;

/**
 * Probamos la clase Menu.
 * 
 * @author José Miguel
 *
 */

public class TestMenuAlmacen {

  private static final int TERMINAR = 11;

  private static Almacen almacen1 = new Almacen();
 
  public static void main(String[] args) {

    // creamos el método menú
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

  public static Menu crearMenu() {
    return new Menu("Añadir Artículo.", "Borrar artículo.", "Incrementar unidades almacén.",
        "Decrementar unidades almacén", "Impresión del almacén", "Modificar Artículo",
        "Exportar A JSON", "Importar JSON", "Exportar A XML", "Importar XML", "Finalizar");
  }

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
  
  private static void pedirFicheroJson() {
    String fichero = readStr("Dime el nombre del fichero json");
    almacen1.exportarJson(fichero);
  }
  
  private static void pedirFicheroXML() {
    String fichero = readStr("Dime el nombre del fichero xml");
    almacen1.exportarXML(fichero);
  }

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
