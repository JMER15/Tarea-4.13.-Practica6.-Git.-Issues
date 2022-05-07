package Gestisimal.negocio;

/**
 * Lanzada para indicar Sí el nombre y la marca son iguales.
 * 
 * @author José Miguel Escribano Ruiz
 *
 */
public class AlmacenNombreMarcaException extends Exception {

  /**
   * Serial para la excepción.	
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construye una excepción AlmacenNombreMarcaException con el mensaje detallado.
   * 
   * @param message mensaje detallado.
   */
  public AlmacenNombreMarcaException(String message) {
    super(message);
  }
}
