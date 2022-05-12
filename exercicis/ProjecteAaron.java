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
    
    // variables globals
    static Scanner sc = new Scanner (System.in);
    static boolean valid;
    static int confirmaSortida = 0;
    static int id, places, parla, tipus, telefon, entrades = 0;
    static String textParla, textTipus;
    
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
        
        // submètodes del programa
        if (confirmaSortida != 1) {
            id();
        }
        if (confirmaSortida != 1) {
            places();
        }
        if (confirmaSortida != 1) {
            parla();
        }
        if (confirmaSortida != 1) {
            tipus();
        }
        if (confirmaSortida != 1) {
            telefon();
        }
    }
    
    // submètode per emmagatzemar la id
    static void id() {
        do {
            System.out.println("Introdueix la ID de la família [" + ID_MIN + "-" + ID_MAX + "]");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                id = sc.nextInt();
                if (id >= ID_MIN && id <= ID_MAX) { // verifica si dins del rang de dades
                    // correcte, tanquem submètode
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
    
    // submètode per emmagatzemar les places
    static void places() {
        do {
            System.out.println("Introdueix les places que ofereixes [" + PLACES_MIN + "-" + PLACES_MAX + "]");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                places = sc.nextInt();
                if (places >= PLACES_MIN && places <= PLACES_MAX) { // verifica si dins del rang de dades
                    // correcte, tanquem submètode
                } else if (places == SORTIR) {
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
    
    // submètode per emmagatzemar si parla o no rus/ucraïnès
    static void parla() {
        do {
            System.out.println("Indica si algú a casa parla [1] o no parla [0] rus o ucraïnès a la teva família");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                parla = sc.nextInt();
                if (parla == 0 || parla == 1) { // verifica si dins del rang de dades
                    // correcte, tanquem submètode
                } else if (parla == SORTIR) {
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
    
    // submètode per emmagatzemar el tipus d'allotjament
    static void tipus() {
        do {
            System.out.println("Introdueix el tipus d'allotjament que pots oferir:\n[0]: Habitació compartida.\n[1]: Habitació.\n[2]: Habitatge sencer.\n[3]: Sala comunitària, local habilitat.");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                tipus = sc.nextInt();
                if (tipus >= 0 && tipus <= 3) { // verifica si dins del rang de dades
                    // correcte, tanquem submètode
                } else if (tipus == SORTIR) {
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
    
    // submètode per emmagatzemar el telèfon
    static void telefon() {
        do {
            System.out.println("Introdueix un número de telèfon vàlid (9 xifres)");
            valid = sc.hasNextInt(); // verifica si tipus correcte
            if (valid) {
                telefon = sc.nextInt();
                if (telefon >= TELF_MIN && telefon <= TELF_MAX) { // verifica si dins del rang de dades
                    // correcte, tanquem submètode
                } else if (telefon == SORTIR) {
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
        
        entrades++; // incrementa comptador de famílies correctament introduïdes
    }
    
    // mètode per indicar si introduir més famílies o no
    static void seguir() {
        
        int segueix;
        do {
                System.out.println("Vols introduir dades d'una nova família?:[1] sí / [0] no.");
                valid = sc.hasNextInt();
                if (valid) {
                    segueix = sc.nextInt();
                    switch (segueix) {
                        case 1:
                            families();
                            break;
                        case 0:
                            if (entrades != 1) {
                                System.out.println("Has introduït dades de " + entrades + " famílies.");
                            } else {
                                System.out.println("Has introduït dades d'" + entrades + " família.");
                            }
                            break;
                        default:
                            System.out.println("Valor incorrecte, torna-ho a intentar.");
                            sc.next();
                            valid = false;
                            break;
                    }
                } else {
                    System.out.println("Valor incorrecte, torna-ho a intentar.");
                    sc.next();
                    valid = false;
                }
            } while (!valid);
    }
    
    public static void main (String[] args) {
        // inicialització interfície usuari
        System.out.println("Benvingut/da al programa de gestió de famílies d'acollida.\nIntrodueix [-1] en qualsevol moment per finalitzar el programa.");
        
        if (confirmaSortida != 1) {
            families();
            seguir();
        }
    }
}
