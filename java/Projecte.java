package Projecte;

import java.util.Scanner;

/**
*
* @author @oscardefez @xonitu @aaronFortuno
*/

public class Projecte {
  
  // declaració constants
  public static final int ID_MIN = 10;
  public static final int ID_MAX = 999;
  
  public static final int PLACES_MIN = 1;
  public static final int PLACES_MAX = 99;
  
  public static final String PARLA_NO = "no";
  public static final String PARLA_SI = "sí";
  
  public static final String TIPUS_0 = "habitació compartida";
  public static final String TIPUS_1 = "habitació";
  public static final String TIPUS_2 = "habitatge sencer";
  public static final String TIPUS_3 = "sala comunitària, local habilitat";
  
  public static final int TELF_MIN = 111111111;
  public static final int TELF_MAX = 999999999;
  
  public static final int INTENTS = 3;
  
  
  public static void main (String[] args) {
    
    // declaració i inicialització variables
    Scanner sc = new Scanner(System.in);
    int id, places, parla, tipus, telefon;
    boolean valid;
    String textParla, textTipus;
    
    // inicialització interfície usuari
    System.out.println("Benvingut/da al programa de gestió de famílies d'acollida.\nIntrodueix [-1] en qualsevol moment per finalitzar el programa");
    
    // INSTRUCCIONS INICIALS
    //
    
    // bucle programa
    do {
      valid = sc.hasNextInt(); // verifica si tipus correcte
      if (valid) {
        id = sc.nextInt();
        if (id > ID_MIN && id < ID_MAX) { // verifica si dins del rang de dades
          // SEGUIR PROGRAMA AQUÍ DINS
          valid=true;

          System.out.println("Introdueix ID");

          
          
        } else {
          valid = false; // torna a demanar entrada dades si valor fora del rang
          sc.nextLine(); // buida buffer
      } else { // torna a demanar entrada dada si tipus incorrecte
        sc.nextLine(); // buida buffer
      }
      
    } while (!valid);
  }
}


//for (i=0;i<quant_families;i++);
