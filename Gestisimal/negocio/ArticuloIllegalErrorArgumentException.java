package Gestisimal.negocio;

public class ArticuloIllegalErrorArgumentException extends IllegalArgumentException {

  private static final long serialVersionUID = 1L;

  public ArticuloIllegalErrorArgumentException() {
  }

  public ArticuloIllegalErrorArgumentException(String s) {
    super(s);
  }

  public ArticuloIllegalErrorArgumentException(Throwable cause) {
    super(cause);
  }

  public ArticuloIllegalErrorArgumentException(String message, Throwable cause) {
    super(message, cause);
  }

}
