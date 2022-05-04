package Gestisimal.negocio;

public class ArticuloIllegalErrorArgument extends IllegalArgumentException {

  private static final long serialVersionUID = 1L;

  public ArticuloIllegalErrorArgument() {
  }

  public ArticuloIllegalErrorArgument(String s) {
    super(s);
  }

  public ArticuloIllegalErrorArgument(Throwable cause) {
    super(cause);
  }

  public ArticuloIllegalErrorArgument(String message, Throwable cause) {
    super(message, cause);
  }

}
