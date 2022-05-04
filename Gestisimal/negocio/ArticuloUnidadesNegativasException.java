package Gestisimal.negocio;

public class ArticuloUnidadesNegativasException extends Exception {

  private static final long serialVersionUID = 1L;

  public ArticuloUnidadesNegativasException() {
  }

  public ArticuloUnidadesNegativasException(String message) {
    super(message);
  }

  public ArticuloUnidadesNegativasException(Throwable cause) {
    super(cause);
  }

  public ArticuloUnidadesNegativasException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArticuloUnidadesNegativasException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
