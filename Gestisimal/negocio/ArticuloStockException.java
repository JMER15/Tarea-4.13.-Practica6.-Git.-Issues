package Gestisimal.negocio;

public class ArticuloStockException extends Exception {

  private static final long serialVersionUID = 1L;

  public ArticuloStockException() {
  }

  public ArticuloStockException(String message) {
    super(message);
  }

  public ArticuloStockException(Throwable cause) {
    super(cause);
  }

  public ArticuloStockException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArticuloStockException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
