package Gestisimal.negocio;

/**
 * Lanzada para indicar Sí el Artículo existe en el almacén.
 * 
 * @author José Miguel Escribano Ruiz
 *
 */
public class AlmacenArticuloExisteException extends Exception {
  
  /**
   * Serial para la excepción.	
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construye una excepción AlmacenArticuloExisteException con el mensaje detallado.
   * 
   * @param message mensaje detallado.
   */
  public AlmacenArticuloExisteException(String message) {
    super(message);
    
  }
}

