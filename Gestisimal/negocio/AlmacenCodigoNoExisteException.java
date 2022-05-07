package Gestisimal.negocio;

/**
 * Lanzada para indicar Sí el código existe en el almacén.
 * 
 * @author José Miguel Escribano Ruiz
 *
 */
public class AlmacenCodigoNoExisteException extends Exception {
  
  /**
   * Serial para la excepción.	
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construye una excepción AlmacenCodigoNoExisteException con el mensaje detallado.
   * 
   * @param message mensaje detallado.
   */
  public AlmacenCodigoNoExisteException(String message) {
    super(message);
  }
}
