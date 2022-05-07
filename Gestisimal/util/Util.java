package Gestisimal.util;

import java.util.Scanner;

/**
   * Conjunto de funciones genéricas que me serán de utilidad para simplificar procesos.
   * 
   * @author Rafael del Castillo Gomariz
   *
   */

  public class Util {
    
	  /**
	   * Abrir Scanner
	   * 
	   */
    private static Scanner in = new Scanner(System.in);

    /**
     * Lee un String desde el prompt
     * 
     * @param prompt String  Recibe un string.
     * @return in.nextLine(); Devuelve un salto de línea.
     */
    public static String readStr(String prompt) {
      System.out.print(prompt + ": ");
      return in.nextLine();
    }
    
    /**
     * Lee un string desde el prompt y termina.
     * 
     * @param prompt String 	Recibe un string.
     * @param end String  		Recibe un string.
     * @return str 				Devuelve el string leído con el scanner.
     */
    public static String readStr(String prompt, String end) {
      String str = readStr(prompt);
      System.out.print(end);
      return str;
    }

    /**
     * Lee un entero
     * 
     * @param prompt String 	Recibe un string.
     * @return n 				Devuelve un entero.
     */
    public static int readInt(String prompt) {
      System.out.print(prompt + ": ");
      int n = in.nextInt();
      in.nextLine();  // sacamos \n del buffer de teclado
      return n;
    }
    
    /**
     * Lee un entero
     * 
     * @param prompt String  Recibe un string.
     * @param end String	 Recibe un string.
     * @return n			 Devuelve un entero.
     */
    public static int readInt(String prompt, String end) {
      int n = readInt(prompt);
      System.out.print(end);
      return n;
    }
    
    /**
     * Lee un Double
     * 
     * @param prompt String		Recibe un string.
     * @return n				Devuelve un double.
     */
    public static double readDouble(String prompt) {
      System.out.print(prompt + ": ");
      double n = in.nextDouble();
      in.nextLine();  // sacamos \n del buffer de teclado
      return n;
    }
    
    /**
     * Lee un nombre
     * 
     * @param prompt String		Recibe un string.
     * @param end String		Recibe un string.
     * @return n				Devuelve un double.
     */
    public static double readDouble(String prompt, String end) {
      double n = readDouble(prompt);
      System.out.print(end);
      return n;
    }
    
    /**
     * Confirmación
     * 
     * @param prompt 	Recibe un string.
     * @return resp		Devuelve un boolean (true or false).
     */
    public static boolean confirm(String prompt) {
      String resp;
      for (;;) {
        resp = Util.readStr(prompt).toUpperCase();
        if (resp.equals("S") || resp.equals("N")) {
          break;
        }
        System.out.println("Respuesta incorrecta, pulse S o N y después Intro");
      }
      return resp.equals("S");
    }
    
    /**
     * Confirma S/N
     * 
     * @return boolean	Devuelve un boolean (true or false).	
     */
    public static boolean confirm() {
      return confirm("¿Está seguro/a? (S/N)");
    }

    /**
     * Devuelve un Entero random
     * 
     * @param min int 		Recibe un entero min.
     * @param max int		Recibe un entero max.
     * @return int random	Devuelve un entero random entre esos 2 valores.
     */
    public static int randomInt(int min, int max) {
      return min + (int) (Math.random() * (max-min+1));
    }
  }


