package Projecte3;

import java.util.Scanner;
/**
 *
 * @author @oscardefez @xonitu @aaronFortuno
 */
public class P3_FortunoR {
    
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
    public static final int SORTIR = -1;
    
    static Scanner sc = new Scanner (System.in);
    static boolean valid;
    static int confirmaSortida;
            
    static void sortir() {
        System.out.println("Estàs segur de voler sortir? [1] Sí / [0] No"); // rutina confirmació sortida
          do {
            valid = sc.hasNextInt();
            if (valid) {
              confirmaSortida = sc.nextInt();
              if (confirmaSortida == 1) { // sortir
                System.out.println("Gràcies per utilitzar el programa d'introducció de famílies");
              } else if (confirmaSortida == 0) { // no sortir, torna a l'inici
                System.out.println("Has triat seguir utilitzant el programa");
                families();
              } else { // no valor 0 o 1
                System.out.println("No has introduït un valor vàlid (1 o 0), torneu-ho a intentar");
                valid = false; // torna a demanar
              }
            } else { // no valor int
              System.out.println("No has introduït un número, torna-ho a intentar");
              sc.nextLine(); // neteja buffer
              valid = false; // torna a demanar
            }
          } while (!valid);
    }
    
    static void families() {
        // declaració i inicialització variables
        int id, places, parla, tipus, telefon;
        String textParla, textTipus;
        
        // inicialització interfície usuari
        System.out.println("Benvingut/da al programa de gestió de famílies d'acollida.\nIntrodueix [-1] en qualsevol moment per finalitzar el programa.");
        
        // INSTRUCCIONS INICIALS
        //
        
        // bucle programa
        do {
            System.out.println("Introdueix la ID de la família [" + ID_MIN + "-" + ID_MAX + "]");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                id = sc.nextInt();
                if (id >= ID_MIN && id <= ID_MAX) { // verifica si dins del rang de dades
                    System.out.println("Id: " + id);
                } else if (id == SORTIR) {
                    sortir();
                } else {
                    System.out.println("No has introduït un valor dins del rang, torna-ho a intentar");
                    valid = false;
                    sc.nextLine();
                }
            } else {
                System.out.println("No has introduït un nombre enter, torna-ho a intentar");
                sc.nextLine();
            }
        } while (!valid);
    }
    public static void main (String[] args) {
        
        families();
    }
}
