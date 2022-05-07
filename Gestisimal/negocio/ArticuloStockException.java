package Gestisimal.negocio;
/**
 * Excepción lanzada para indicar error en el stock.
 * 
 * @author José Miguel Escribano Ruiz
 *
 */
public class ArticuloStockException extends Exception {

  /**
   * Implementar serialVersionUID	
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construye una clase ArticuloStockException con el mensaje detallado.
   * 
   * @param message mensaje detallado.
   */
  public ArticuloStockException(String message) {
    super(message);
  }
}
