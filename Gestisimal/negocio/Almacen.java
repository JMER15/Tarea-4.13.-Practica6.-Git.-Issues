package Gestisimal.negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Clase Almacén que realice el alta, baja, modificación, entrada de mercancía (incrementa
 * unidades), salida de mercancía (decrementa unidades). El estado será un ArrayList de artículos
 * (pero la clase no será un ArrayList) Su comportamiento será: añadir artículos (no puede haber dos
 * artículos con el mismo nombre y marca), eliminar artículos, incrementar las existencias de un
 * artículo (se delega en la clase Artículo), decrementar las existencias de un artículo (nunca por
 * debajo de cero, se delega en la clase Artículo), devolver un artículo (para mostrarlo). Para
 * listar el almacén podría devolverse una cadena con todos los artículos del almacén (toString).
 * 
 * @author josemi
 *
 */

public class Almacen {

  private List<Articulo> almacen = new ArrayList<>();

  public void add(String nombre, String marca, double precioDeCompra, double precioDeVenta,
      int numeroDeUnidades, int stockDeSeguridad, int stockMaximo)
      throws AlmacenNombreMarcaException {
    lanzaExcepcionSiNombreYMarca2ProductosSonIguales(nombre, marca);
    almacen.add(new Articulo(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades,
        stockDeSeguridad, stockMaximo));
  }

  private void lanzaExcepcionSiNombreYMarca2ProductosSonIguales(String nombre, String marca)
      throws AlmacenNombreMarcaException {
    for (Articulo art : almacen) {
      if (nombre.equals(art.getNombre()) && marca.equals(art.getMarca())) {
        throw new AlmacenNombreMarcaException("El nombre y la marca no pueden ser iguales.");
      }
    }
  }

  // podemos usar un metodo contains o implementar el método equals en Articulo.
  // la excepcion debe ir al principio

  public void delete(int codigo) throws AlmacenCodigoNoExisteException {
    // remove if más rápido articles removeIf(art -> art.getCode() == code);
    if (!containsCod(codigo)) {
      throw new AlmacenCodigoNoExisteException("El código " + codigo + " no existe en el almacén");
    }
    almacen.removeIf(art -> art.getCodigo() == codigo);
  }
  // TODO poner nombre apropiado hecho

  private boolean containsCod(int codigo) {
    for (Articulo art : almacen) {
      if (art.getCodigo() == codigo) {
        return true;
      }
    }
    return false;
  }

  // incrementar unidades
  public void addUnidades(int codigo, int unidades) throws AlmacenCodigoNoExisteException {
    for (Articulo art : almacen) {
      if (codigo == art.getCodigo()) {
        art.addUnidades(unidades);
        return;
      }
    }
    throw new AlmacenCodigoNoExisteException("El código " + codigo + " no existe en el almacén");
  }

  // decrementar unidades
  public void removeUnidades(int codigo, int unidades)
      throws AlmacenCodigoNoExisteException, ArticuloStockException {
    for (Articulo art : almacen) {
      if (codigo == art.getCodigo()) {
        art.eliminarUnidades(unidades);
        return;
      }
    }
    throw new AlmacenCodigoNoExisteException("El código " + codigo + " no existe en el almacén");
  }
  // TODO corregir igual que añadir hecho

  // modificar articulo
  public void modificarArticulo(int codigo, String nombre, String marca, double precioDeCompra,
      double precioDeVenta, int numeroDeUnidades, int stockMaximo, int stockDeSeguridad)
      throws AlmacenCodigoNoExisteException, AlmacenNombreMarcaException {

    for (Articulo art : almacen) {
      if (art.getNombre().equals(nombre) && art.getMarca().equals(marca) && !containsCod(codigo)) {
        throw new AlmacenNombreMarcaException("Ya existe un articulo con ese nombre y marca");
      }
      if (codigo == art.getCodigo()) {
        art.set(nombre, marca, precioDeCompra, precioDeVenta, numeroDeUnidades, stockMaximo,
            stockDeSeguridad);
        return;
      }
    }
    throw new AlmacenCodigoNoExisteException("El código " + codigo + " no existe en el almacén");
  }


  // Exportar a formato json clase almacén
  public void exportarJson(String fichero) {
    try (var file = Files.newBufferedWriter(Paths.get(fichero), Charset.defaultCharset(),
        StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING,
        StandardOpenOption.CREATE)) {

      // paso arraylist a Json
      String json = new Gson().toJson(almacen);

      // guardo JSON en un archivo
      file.write(json);
      file.close();

      System.out.println("\nFichero JSON creado correctamente.\n");
      System.out.println(almacen);

    } catch (IOException e) {
      System.err.println("Error al crear JSON: " + e.getMessage());
      e.printStackTrace();
    }
  }

  // importar en formato json clase almacén
  public void importarJson() {
    try {

      // extraigo json del fichero
      String json = Files.readString(Paths.get("almacen.json"));

      // convertimos json en un arraylist
      Gson gson = new Gson();
      Type ArticuloListType = new TypeToken<ArrayList<Articulo>>() {}.getType();
      List<Articulo> articulos = gson.fromJson(json, ArticuloListType);
      almacen.removeAll(articulos);
      for (Articulo art : articulos) {
        almacen.add(art); // añadir a la lista almacen los articulos
        art.actualizarCodigo();
      }
      System.out.println(almacen);
      System.out.println("\nImportado Correctamente\n");

    } catch (IOException e) {
      System.err.println("Error de lectura del fichero json." + e.getMessage());
      e.printStackTrace();
    }

  }

  // exportar en xml
  public void exportarXML(String fichero) {

    try {

      // Creación del documento XML
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument(); // este objeto hará todo el trabajo

      // nodo raiz
      Element root = document.createElement("Almacén");
      document.appendChild(root);

      // Recorremos lista de artículos
      for (Articulo art : almacen) {
        // Nodo Artículo (contiene los elementos)
        Element elementArt = document.createElement("Artículo");
        root.appendChild(elementArt);

        // El código es un atributo del nodo Artículo
        Attr attrCod = document.createAttribute("código");
        attrCod.setValue(Integer.toString(art.getCodigo()));
        elementArt.setAttributeNode(attrCod);

        // Nodo Nombre
        Element elementNombre = document.createElement("Nombre");
        elementNombre.appendChild(document.createTextNode(art.getNombre()));
        elementArt.appendChild(elementNombre);

        // Nodo Marca
        Element elementMarca = document.createElement("Marca");
        elementMarca.appendChild(document.createTextNode((art.getMarca())));
        elementArt.appendChild(elementMarca);

        // Nodo PrecioCompra
        Element elementPrecio = document.createElement("PrecioDeCompra");
        elementPrecio
            .appendChild(document.createTextNode(Double.toString(art.getPrecioDeCompra())));
        elementArt.appendChild(elementPrecio);

        // Nodo PrecioCompra
        Element elementVenta = document.createElement("PrecioDeVenta");
        elementVenta.appendChild(document.createTextNode(Double.toString(art.getPrecioDeCompra())));
        elementArt.appendChild(elementVenta);


        // Nodo Número de unidades
        Element elementUnidades = document.createElement("Unidades");
        elementUnidades
            .appendChild(document.createTextNode(Integer.toString(art.getNumeroDeUnidades())));
        elementArt.appendChild(elementUnidades);

        // Nodo Stock Mínimo
        Element elementStockMinimo = document.createElement("StockMínimo");
        elementStockMinimo
            .appendChild(document.createTextNode(Integer.toString(art.getStockDeSeguridad())));
        elementArt.appendChild(elementStockMinimo);

        // Nodo Stock Máximo
        Element elementStockMaximo = document.createElement("StockMáximo");
        elementStockMaximo
            .appendChild(document.createTextNode(Integer.toString(art.getStockMaximo())));
        elementArt.appendChild(elementStockMaximo);
      }

      // Guardar XML en fichero
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new FileWriter(fichero));
      transformer.transform(source, result);
      System.out.println("\nCreado almacen.xml\n");

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

  // importar en xml
  public void importarXML() {

    try {

      // List<Articulo> almacen = new ArrayList<>();
      // Creamos documento XML
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new File("almacen.xml")); // este objeto hará todo el
                                                                  // trabajo

      document.getDocumentElement().normalize();
      // Accede al nodo raíz del documento Elimina nodos vacíos y combina adyacentes en caso de que
      // los hubiera

      // Accedemos a la lista de nodos Artículo
      NodeList nodes = document.getElementsByTagName("Artículo");

      // Recorremos los nodos Artículo
      for (int i = 0; i < nodes.getLength(); i++) {

        // Nodo Artículo
        Node node = nodes.item(i);
        Element articulo = (Element) node;

        // Campos del artículo (teniendo en cuenta que conocemos la estructura y etiquetas
        // utilizadas)
        int code = Integer.parseInt(articulo.getAttribute("código"));
        String nombre = articulo.getElementsByTagName("Nombre").item(0).getTextContent();
        String marca = articulo.getElementsByTagName("Marca").item(0).getTextContent();
        double precioDeCompra = Double
            .parseDouble(articulo.getElementsByTagName("PrecioDeCompra").item(0).getTextContent());
        double precioDeVenta = Double
            .parseDouble(articulo.getElementsByTagName("PrecioDeVenta").item(0).getTextContent());
        int units =
            Integer.parseInt(articulo.getElementsByTagName("Unidades").item(0).getTextContent());
        int stockMinimo =
            Integer.parseInt(articulo.getElementsByTagName("StockMínimo").item(0).getTextContent());
        int stockMaximo =
            Integer.parseInt(articulo.getElementsByTagName("StockMáximo").item(0).getTextContent());

        // Añadimos a la lista
        
        almacen.add(new Articulo(code, nombre, marca, precioDeCompra, precioDeVenta, units,
            stockMinimo, stockMaximo));
      }

      System.out.println("\nImportado correctamente");

      System.out.println(almacen);
      System.out.println();

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "Almacen [almacen=" + almacen + "]";
  }
}
