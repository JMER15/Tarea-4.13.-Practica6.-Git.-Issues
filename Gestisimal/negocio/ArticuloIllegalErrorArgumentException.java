package Gestisimal.negocio;

/**
 * Lanzada para indicar si el valor de un atributo es incorrecto.
 * 
 * @author José Miguel Escribano Ruiz
 *
 */
public class ArticuloIllegalErrorArgumentException extends IllegalArgumentException {

  /**
   * Serial para la excepción.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construye una excepción ArticuloIllegalErrorArgumentException con el mensaje detallado.
   * 
   * @param message mensaje detallado.
   */
  public ArticuloIllegalErrorArgumentException(String message) {
    super(message);
  }
}
