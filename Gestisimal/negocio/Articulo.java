package Gestisimal.negocio;

/**
 * Clase Artículo que representa a los artículos del almacén.
 * 
 * Su estado será: código, nombre, marca, precio de compra, precio de venta,
 * número de unidades (nunca negativas), stock de seguridad y stock máximo.
 * 
 * Como comportamiento: Consideramos que el código va a generarse de forma
 * automática en el constructor, así no puede haber dos artículos con el mismo
 * código. Esto implica que no puede modificarse el código de un artículo, sí el
 * resto de las propiedades. Podremos mostrar el artículo, por lo que necesito
 * una representación del artículo en forma de cadena (toString).
 * 
 * @author josemi
 * 
 * @version
 *
 */

public class Articulo {

	/**
	 * Variable estática ultimoCodigo
	 */
	private static int ultimoCodigo = 0;

	private int codigo;
	private String nombre;
	private String marca;
	private double precioDeCompra;
	private double precioDeVenta;
	private int numeroDeUnidades;
	private int stockDeSeguridad;
	private int stockMaximo;

	/**
	 * Crea un objeto Artículo que recibe todos los parámetros indicados.
	 * 
	 * @param nombre           Nombre del nuevo Artículo.
	 * @param marca            Marca del nuevo Artículo.
	 * @param precioDeCompra   Precio de Compra del nuevo Artículo.
	 * @param precioDeVenta    Precio de Venta del nuevo Artículo.
	 * @param numeroDeUnidades Número de Unidades del nuevo Artículo.
	 * @param stockDeSeguridad Stock de seguridad del nuevo Artículo.
	 * @param stockMaximo      Stock Máximo del nuevo Artículo.
	 */
	Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta, int numeroDeUnidades,
			int stockDeSeguridad, int stockMaximo) {
		codigo = ++ultimoCodigo;
		setNombre(nombre);
		setMarca(marca);
		setPrecioDeCompra(precioDeCompra);
		setPrecioDeVenta(precioDeVenta);
		setNumeroDeUnidades(numeroDeUnidades);
		setStockDeSeguridad(stockDeSeguridad);
		setStockMaximo(stockMaximo);
	}

	/**
	 * Crea un objeto Artículo, con todos los parámetros indicados; además el stock
	 * Máximo vale 0.
	 * 
	 * @param nombre           Nombre del nuevo Artículo.
	 * @param marca            Marca del nuevo Artículo.
	 * @param precioDeCompra   Precio de Compra del nuevo Artículo.
	 * @param precioDeVenta    Precio de Venta del nuevo Artículo.
	 * @param numeroDeUnidades Número de Unidades del nuevo Artículo.
	 * @param stockDeSeguridad Stock de seguridad del nuevo Artículo.
	 */
	Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta, int numeroDeUnidades,
			int stockDeSeguridad) { // stockmaximo vale 0
		this(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades, stockDeSeguridad, 0);
	}

	/**
	 * Crea un Objeto Artículo, con los parámetros indicados; además el stock mínimo
	 * y máximo son 0.
	 * 
	 * @param nombre           Nombre del nuevo Artículo.
	 * @param marca            Marca del nuevo Artículo.
	 * @param precioDeCompra   Precio de Compra del nuevo Artículo.
	 * @param precioDeVenta    Precio de Venta del nuevo Artículo.
	 * @param numeroDeUnidades Número de Unidades del nuevo Artículo.
	 */
	Articulo(String nombre, String marca, double precioDeCompra, double precioDeVenta, int numeroDeUnidades) { 
		// stockmaximo y mínimo vale 0
		this(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades, 0, 0);
	}

	/**
	 * Crea un objeto Artículo, con los parámetros indicados; se le pasa el código
	 * tambíen.
	 * 
	 * @param code             Código del Artículo.
	 * @param nombre           Nombre del nuevo Artículo.
	 * @param marca            Marca del nuevo Artículo.
	 * @param precioDeCompra   Precio de Compra del nuevo Artículo.
	 * @param precioDeVenta    Precio de Venta del nuevo Artículo.
	 * @param unidades 		   Número de Unidades del nuevo Artículo.
	 * @param stockMinimo 	   Stock de seguridad del nuevo Artículo.
	 * @param stockMaximo      Stock Máximo del nuevo Artículo.
	 */
	Articulo(int code, String nombre, String marca, double precioDeCompra, double precioDeVenta, int unidades,
			int stockMinimo, int stockMaximo) {
		this(nombre, marca, precioDeCompra, precioDeVenta, unidades);
	}

	/**
	 * Devuelve el código actualizado.
	 * 
	 */
	public void actualizarCodigo() {
		codigo = ++ultimoCodigo;
	}

	/**
	 * Devuelve el código del último objeto añadido a la lista
	 * 
	 * @param codigo Código del Artículo.
	 */
	public static void setLastCode(int codigo) {
		codigo = ++ultimoCodigo;
	}

	/**
	 * Obtiene el código.
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Obtiene el nombre.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la marca.
	 * 
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Obtiene el precio de compra.
	 * 
	 * @return precioDeCompra
	 */
	public double getPrecioDeCompra() {
		return precioDeCompra;
	}

	/**
	 * obtiene el precio de venta.
	 * 
	 * @return precioDeVenta
	 */
	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	/**
	 * Obtiene el numero de inidades.
	 * 
	 * @return numeroDeUnidades
	 */
	public int getNumeroDeUnidades() {
		return numeroDeUnidades;
	}

	/**
	 * obtiene el stock de seguridad.
	 * 
	 * @return stockDeSeguridad
	 */
	public int getStockDeSeguridad() {
		return stockDeSeguridad;
	}

	/**
	 * obtiene el stock maximo.
	 * 
	 * @return stockMaximo
	 */
	public int getStockMaximo() {
		return stockMaximo;
	}

	/**
	 * Asigna un nuevo nombre. Si es nulo o en blanco salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param nombre nombre a asignar.
	 * 
	 * 
	 */
	void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new ArticuloIllegalErrorArgumentException("El nombre del artículo no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	/**
	 * Asigna una nueva marca. Si es nulo o en blanco salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param marca marca a asignar.
	 * 
	 * 
	 */
	void setMarca(String marca) {
		if (marca == null || marca.isBlank()) {
			throw new ArticuloIllegalErrorArgumentException("La marca no puede estar vacío.");
		}
		this.marca = marca;
	}

	/**
	 * Asigna un nuevo precio de compra. Si es menor de 0 salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param precioDeCompra asigna el precio de compra.
	 * 
	 * 
	 */
	void setPrecioDeCompra(double precioDeCompra) {
		if (precioDeCompra < 0) {
			throw new ArticuloIllegalErrorArgumentException("El precio de compra no puede ser menor a 0.");
		}
		this.precioDeCompra = precioDeCompra;
	}

	/**
	 * Asigna un nuevo precio de venta. Si es menor de 0 salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param precioDeVenta asigna precio de venta.
	 * 
	 * 
	 */
	void setPrecioDeVenta(double precioDeVenta) {
		if (precioDeVenta < 0) {
			throw new ArticuloIllegalErrorArgumentException("El precio de venta no puede ser menor a 0.");
		}
		this.precioDeVenta = precioDeVenta;
	}

	/**
	 * Asigna un número de unidades. Si son negativas salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param numeroDeUnidades asigna número de unidades.
	 *
	 */
	void setNumeroDeUnidades(int numeroDeUnidades) {
		lanzaExcepcionSiUnidadesNegativas(numeroDeUnidades);
		this.numeroDeUnidades = numeroDeUnidades;
	}

	/**
	 * Asigna un nuevo stock de seguridad. Si es menor de 0 o el stock maximo es
	 * menor que el de seguridad salta excepción
	 * ArticuloIllegalErrorArgumentException.
	 * 
	 * @param stockDeSeguridad asigna stock de seguridad.
	 * 
	 * 
	 */
	void setStockDeSeguridad(int stockDeSeguridad) {
		if (stockDeSeguridad < 0) {
			throw new ArticuloIllegalErrorArgumentException("El stock de seguridad no puede ser menor a 0.");
		}

		if (this.stockMaximo != 0 && this.stockMaximo < stockDeSeguridad) {
			throw new ArticuloIllegalErrorArgumentException("El stock de seguridad no puede ser mayor al stockMáximo.");
		}
		this.stockDeSeguridad = stockDeSeguridad;
	}

	/**
	 * Asigna un nuevo stock Máximo. Si es menor de 0 o el stock minimo es mayor que
	 * el maximo salta excepción ArticuloIllegalErrorArgumentException.
	 * 
	 * @param stockMaximo asigna stock máximo.
	 * 
	 * 
	 */
	void setStockMaximo(int stockMaximo) {
		if (stockMaximo < 0) {
			throw new ArticuloIllegalErrorArgumentException("El stock máximo no puede ser menor a 0.");
		}

		if (this.stockDeSeguridad != 0 && this.stockDeSeguridad > stockMaximo) {
			throw new ArticuloIllegalErrorArgumentException("El stock máximo no puede ser menor al stockDeSeguridad.");
		}
		this.stockMaximo = stockMaximo;
	}

	/**
	 * Será llamado desde la clase almacén para añadir las unidades, lanza excepción
	 * si son negativas.
	 * 
	 * @param unidades Se le pasa el nº de unidades a aumentar.
	 * 
	 */
	// metodos entrada, salida de mercancias y set para modificar
	// metodo que será llamado por otro método en la clase almacén
	public void addUnidades(int unidades) {
		lanzaExcepcionSiUnidadesNegativas(unidades);
		this.numeroDeUnidades += unidades;
	}

	/**
	 * Será llamado desde la clase almacén para decrementar las unidades, lanza
	 * excepción si son negativas.
	 * 
	 * @param unidades Se le pasa el nº de unidades a decrementar.
	 * 
	 * @throws ArticuloStockException if units are negative or the result is will be negative.
	 * 
	 */
	public void eliminarUnidades(int unidades) throws ArticuloStockException {
		lanzaExcepcionSiUnidadesNegativas(unidades);
		if (this.numeroDeUnidades - unidades < 0) {
			throw new ArticuloStockException("NO hay unidades suficientes para decrementar " + unidades + " unidades.");
			// excepcion marcada
		}
		this.numeroDeUnidades -= unidades;
	}

	/**
	 * Será llamado desde almacén para modificar el artículo.
	 * 
	 * @param nombre           Nombre del nuevo Artículo.
	 * @param marca            Marca del nuevo Artículo.
	 * @param precioDeCompra   Precio de Compra del nuevo Artículo.
	 * @param precioDeVenta    Precio de Venta del nuevo Artículo.
	 * @param numeroDeUnidades Número de Unidades del nuevo Artículo.
	 * @param stockDeSeguridad Stock de seguridad del nuevo Artículo.
	 * @param stockMaximo      Stock Máximo del nuevo Artículo.
	 */
	public void set(String nombre, String marca, double precioDeCompra, double precioDeVenta, int numeroDeUnidades,
			int stockMaximo, int stockDeSeguridad) {
		setNombre(nombre);
		setMarca(marca);
		setPrecioDeCompra(precioDeCompra);
		setPrecioDeVenta(precioDeVenta);
		setNumeroDeUnidades(numeroDeUnidades);
		setStockMaximo(stockMaximo);
		setStockDeSeguridad(stockDeSeguridad);
	}

	/**
	 * Excepción propia creado para la clase Artículo
	 * 
	 * @param numeroDeUnidades número de unidades.
	 */
	private void lanzaExcepcionSiUnidadesNegativas(int numeroDeUnidades) {
		if (numeroDeUnidades < 0) {
			throw new ArticuloIllegalErrorArgumentException("Las unidades no pueden ser menores a 0.");
		}
	}

	/**
	 * Devuelve una representación en cadena del objeto.
	 * 
	 */
	@Override
	public String toString() {
		return " \nArticulo [codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", precioDeCompra="
				+ precioDeCompra + ", precioDeVenta=" + precioDeVenta + ", numeroDeUnidades=" + numeroDeUnidades
				+ ", stockDeSeguridad=" + stockDeSeguridad + ", stockMaximo=" + stockMaximo + "]";
	}
}
