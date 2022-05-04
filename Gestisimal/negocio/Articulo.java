package Gestisimal.negocio;

/**
 * Clase Artículo que representa a los artículos del almacén.
 * 
 * Su estado será: código, nombre, marca, precio de compra, precio de venta, número de unidades
 * (nunca negativas), stock de seguridad y stock máximo.
 * 
 * Como comportamiento: Consideramos que el código va a generarse de forma automática en el
 * constructor, así no puede haber dos artículos con el mismo código. Esto implica que no puede
 * modificarse el código de un artículo, sí el resto de las propiedades. Podremos mostrar el
 * artículo, por lo que necesito una representación del artículo en forma de cadena (toString).
 * 
 * @author josemi
 *
 */

public class Articulo {

  private static int ultimoCodigo = 0;

  private int codigo;
  private String nombre;
  private String marca;
  private double precioDeCompra;
  private double precioDeVenta;
  private int numeroDeUnidades;
  private int stockDeSeguridad;
  private int stockMaximo;

  
  Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta,
      int numeroDeUnidades, int stockDeSeguridad, int stockMaximo) {
    codigo = ++ultimoCodigo;
    setNombre(nombre);
    setMarca(marca);
    setPrecioDeCompra(precioDeCompra);
    setPrecioDeVenta(precioDeVenta);
    setNumeroDeUnidades(numeroDeUnidades);
    setStockDeSeguridad(stockDeSeguridad);
    setStockMaximo(stockMaximo);
  }

  Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta,
      int numeroDeUnidades, int stockDeSeguridad) { // stockmaximo vale 0
    this(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades, stockDeSeguridad, 0);
  }

  Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta,
      int numeroDeUnidades) { // stockmaximo y mínimo vale 0
    this(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades, 0, 0);
  }


  Articulo(int code, String nombre, String marca, double precioDeCompra,
      double precioDeVenta, int units, int stockMinimo, int stockMaximo) {
    this(nombre, marca, precioDeCompra, precioDeVenta, units);
  }

  public void actualizarCodigo() {
    codigo = ++ultimoCodigo;
  }
  
  public static void setLastCode(int codigo) {
    codigo = ++ultimoCodigo;
  }
  
  public int getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public String getMarca() {
    return marca;
  }

  public double getPrecioDeCompra() {
    return precioDeCompra;
  }

  public double getPrecioDeVenta() {
    return precioDeVenta;
  }

  public int getNumeroDeUnidades() {
    return numeroDeUnidades;
  }

  public int getStockDeSeguridad() {
    return stockDeSeguridad;
  }

  public int getStockMaximo() {
    return stockMaximo;
  }

  void setNombre(String nombre) {
    if (nombre == null || nombre.isBlank()) {
      throw new ArticuloIllegalErrorArgumentException("El nombre del artículo no puede estar vacío.");
    }
    this.nombre = nombre;
  }

  void setMarca(String marca) {
    if (marca == null || marca.isBlank()) {
      throw new ArticuloIllegalErrorArgumentException("La marca no puede estar vacío.");
    } 
    this.marca = marca;
  }

  void setPrecioDeCompra(double precioDeCompra) {
    if (precioDeCompra < 0) {
      throw new ArticuloIllegalErrorArgumentException("El precio de compra no puede ser menor a 0.");
    }
    this.precioDeCompra = precioDeCompra;
  }

  void setPrecioDeVenta(double precioDeVenta) {
    if (precioDeVenta < 0) {
      throw new ArticuloIllegalErrorArgumentException("El precio de venta no puede ser menor a 0.");
    }
    this.precioDeVenta = precioDeVenta;
  }

  void setNumeroDeUnidades(int numeroDeUnidades) {
    lanzaExcepcionSiUnidadesNegativas(numeroDeUnidades);
    this.numeroDeUnidades = numeroDeUnidades;
  }

  void setStockDeSeguridad(int stockDeSeguridad) {
    if (stockDeSeguridad < 0) {
      throw new ArticuloIllegalErrorArgumentException("El stock de seguridad no puede ser menor a 0.");
    }

    if (this.stockMaximo != 0 && this.stockMaximo < stockDeSeguridad) {
      throw new ArticuloIllegalErrorArgumentException(
          "El stock de seguridad no puede ser mayor al stockMáximo.");
    }
    this.stockDeSeguridad = stockDeSeguridad;
  }

  void setStockMaximo(int stockMaximo) {
    if (stockMaximo < 0) {
      throw new ArticuloIllegalErrorArgumentException("El stock máximo no puede ser menor a 0.");
    }

    if (this.stockDeSeguridad != 0 && this.stockDeSeguridad > stockMaximo) {
      throw new ArticuloIllegalErrorArgumentException(
          "El stock máximo no puede ser menor al stockDeSeguridad.");
    }
    this.stockMaximo = stockMaximo;
  }

  // metodos entrada, salida de mercancias y set para modificar
  // metodo que será llamado por otro método en la clase almacén
  public void addUnidades(int unidades) {
    lanzaExcepcionSiUnidadesNegativas(unidades);
    this.numeroDeUnidades += unidades;
  }

  public void eliminarUnidades(int unidades) throws ArticuloStockException {
    lanzaExcepcionSiUnidadesNegativas(unidades);
    if (this.numeroDeUnidades - unidades < 0) {
      throw new ArticuloStockException( 
          "NO hay unidades suficientes para decrementar " + unidades + " unidades."); //excepcion marcada
    }
    this.numeroDeUnidades -= unidades;
  }
  
  public void set(String nombre, String marca, double precioDeCompra, double precioDeVenta,
      int numeroDeUnidades, int stockMaximo, int stockDeSeguridad) {
    setNombre(nombre);
    setMarca(marca);
    setPrecioDeCompra(precioDeCompra);
    setPrecioDeVenta(precioDeVenta);
    setNumeroDeUnidades(numeroDeUnidades);
    setStockMaximo(stockMaximo); 
    setStockDeSeguridad(stockDeSeguridad);
  }

  private void lanzaExcepcionSiUnidadesNegativas(int numeroDeUnidades) {
    if (numeroDeUnidades < 0) {
      throw new ArticuloIllegalErrorArgumentException("Las unidades no pueden ser menores a 0.");
    }
  }

  @Override
  public String toString() {
    return " \nArticulo [codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca
        + ", precioDeCompra=" + precioDeCompra + ", precioDeVenta=" + precioDeVenta
        + ", numeroDeUnidades=" + numeroDeUnidades + ", stockDeSeguridad=" + stockDeSeguridad
        + ", stockMaximo=" + stockMaximo + "]";
  }
}