/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projecte3;

import java.util.Scanner;

/**
 *
 * @author estemon
 */

// programa per a la gestió de famílies d'acollida
public class P3_FortunoR {
    
  // definició de constants
  public static final int ID_MIN = 10;
  public static final int ID_MAX = 999;
  public static final int PLACES_MIN = 1;
  public static final int PLACES_MAX = 99;
  public static final String PARLA_0 = "no";
  public static final String PARLA_1 = "sí";
  public static final String TIPUS_0 = "habitació compartida\t";
  public static final String TIPUS_1 = "habitació\t\t";
  public static final String TIPUS_2 = "habitatge sencer\t";
  public static final String TIPUS_3 = "sala comunit., local habilitat";
  public static final int TELF_MIN = 111111111;
  public static final int TELF_MAX = 999999999;
  public static final int INTENTS = 3;
  public static final int MAX_DADES = 10;
    
  public static void main (String[] args) {
      
    // inicialització lector d'entrada de dades
    Scanner sc = new Scanner(System.in);
    int[] id = new int[MAX_DADES];
    int[] places = new int[MAX_DADES];
    int[] parla = new int[MAX_DADES];
    int[] tipus = new int[MAX_DADES];
    int[] telefon = new int[MAX_DADES];;
    int intent = 1, segueix = 1, entrades = 0;
    int c = 0;
    boolean validaEntrada, sortir = false;
    String textParla, textTipus;

    // inicialització interfície
    System.out.println("Benvingut/da al programa de gestió de famílies d'acollida.");
    System.out.println("Escriu el nombre [-1] en qualsevol moment per finalitzar el programa.");
    System.out.println("Podeu emmagatzemar dades d'un màxim de " + MAX_DADES + " famílies.");

    // inici bloc introducció famílies, executa com a mínim una primera vegada
    do {
            
      // introducció identificador
      do {
        System.out.println("Si us plau, indiqueu el vostre número identificador [10-999]\t(Intent " + intent + "/" + INTENTS + ")");
        validaEntrada = sc.hasNextInt();
        if (validaEntrada) {
          id[c] = sc.nextInt();
          if (id[c] == -1) {
              sortir = true;
          }
          if (id[c] < ID_MIN || id[c] > ID_MAX) {
            System.out.println("No heu introduït un nombre identificador vàlid dins del rang [10-999]. Torneu a intentar-ho.");
            intent++;
            validaEntrada = false;
          } else {

            // reset intents;
            intent = 1;
            // SI TOT ÉS CORRECTE, verificació de places correcte
            do {
              System.out.println("Si us plau, indiqueu el nombre de places d'allotjament que oferiu [1-99]:\t(Intent " + intent + "/" + INTENTS + ")");
              validaEntrada = sc.hasNextInt();
              if (validaEntrada) {
                places[c] = sc.nextInt();
                if (places[c] == -1) {
                  sortir = true;
                }
                if (places[c] < PLACES_MIN || places[c] > PLACES_MAX) {
                  System.out.println("No heu introduït un nombre vàlid de places dins del rang [1-99]. Torneu a intentar-ho.");
                  intent++;
                  validaEntrada = false;
                } else {

                  // reset intents;
                  intent = 1;
                  // SI TOT ÉS CORRECTE, verificació si parla rus o ucraïnès
                  do {
                    System.out.println("Si us plau, indiqueu si a la vostra família algú parla rus o ucraïnès. Escriviu [1] si algú en parla o [0] si no és el cas.\t(Intent " + intent + "/" + INTENTS + ")");
                    validaEntrada = sc.hasNextInt();
                    if (validaEntrada) {
                      parla[c] = sc.nextInt();
                      if (parla[c] == -1) {
                        sortir = true;
                      }
                      if (parla[c] != 0 && parla[c] != 1) {
                        System.out.println("No heu indicat amb [0] o [1] si algú parla o no rus o ucraïnès a la vostra família. Torneu a intentar-ho.");
                        intent++;
                        validaEntrada = false;
                      } else {

                        // reset intents;
                        intent = 1;
                        // SI TOT ÉS CORRECTE, verificació tipus d'allotjament
                        do {
                          System.out.println("Si us plau, indiqueu el tipus d'allotjament que podeu oferir:\n[0]: Habitació compartida.\n[1]: Habitació.\n[2]: Habitatge sencer.\n[3]: Sala comunitària, local habilitat.\t(Intent " + intent + "/" + INTENTS + ")");
                          validaEntrada = sc.hasNextInt();
                          if (validaEntrada) {
                            tipus[c] = sc.nextInt();
                            if (tipus[c] == -1) {
                              sortir = true;
                            }
                            if (tipus[c] < 0 || tipus[c] > 3) {
                              System.out.println("Heu indicat un tipus d'allotjament fora del rang vàlid de dades [0-3]. Torneu a intentar-ho.");
                              intent++;
                              validaEntrada = false;
                            } else {

                              // reset intents;
                              intent = 1;
                              // SI TOT ÉS CORRECTE, verificació telèfon
                              do {
                                System.out.println("Si us plau, indiqueu un número de telèfon vàlid\t(Intent " + intent + "/" + INTENTS + ")");
                                validaEntrada = sc.hasNextInt();
                                if (validaEntrada) {
                                  telefon[c] = sc.nextInt();
                                  if (telefon[c] == -1) {
                                    sortir = true;
                                  }
                                  if (telefon[c] < TELF_MIN || telefon[c] > TELF_MAX) {
                                    System.out.println("Heu indicat un número de telèfon no vàlid. Torneu a intentar-ho.");
                                    intent++;
                                    validaEntrada = false;
                                  } else {

                                    // SI TOT ÉS CORRECTE FINS AQUÍ:
                                    // preparació text parla rus o ucraïnès
                                    switch (parla[c]) {
                                      case 0:
                                        textParla = PARLA_0;
                                        break;
                                      case 1:
                                        textParla = PARLA_1;
                                        break;
                                      default:
                                        textParla = " "; // s'ha de definir un cas default per compilar
                                    }

                                    // preparació text tipus d'allotjament
                                    switch (tipus[c]) {
                                      case 0:
                                        textTipus = TIPUS_0;
                                        break;
                                      case 1:
                                        textTipus = TIPUS_1;
                                        break;
                                      case 2:
                                        textTipus = TIPUS_2;
                                        break;
                                      case 3:
                                        textTipus = TIPUS_3;
                                        break;
                                      default:
                                        textTipus = " "; // s'ha de definir un cas default per compilar
                                    }

                                    // mostrar resum de les dades emmagatzemades
                                    System.out.println("Mostrem a continuació un resum de les vostres dades:");
                                    System.out.println("ID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon");
                                    System.out.println(id[c] + "\t" + places[c] + "\t" + textParla + "\t\t" + textTipus + "\t" + telefon[c]);
                                    intent = 1;
                                    c++;
                                    entrades++; // incrementa comptador famílies introduïdes
                                    System.out.println("\nPodeu introduir dades de " + (MAX_DADES - entrades) + " famílies més.");

                                  }
                                } else {
                                  System.out.println("Heu introduït una dada invàlida (telèfon). Si us plau, torneu a intentar-ho.");
                                  intent++;
                                  sc.next();
                                }

                              } while (!validaEntrada && intent <= INTENTS && !sortir);
                            }
                          } else {
                            System.out.println("Heu introduït una dada invàlida (tipus). Si us plau, torneu a intentar-ho.");
                            intent++;
                            sc.next();
                          }

                        } while (!validaEntrada && intent <= INTENTS && !sortir);
                      }
                    } else { 
                      System.out.println("Heu introduït una dada invàlida (llengua). Si us plau, torneu a intentar-ho.");
                      intent++;
                      sc.next();
                    }
                  } while (!validaEntrada && intent <= INTENTS && !sortir);
                }
              } else {
                System.out.println("Heu introduït una dada invàlida (places). Si us plau, torneu a intentar-ho.");
                intent++;
                sc.next();
              }
            } while (!validaEntrada && intent <= INTENTS && !sortir);
          }
        } else {
          System.out.println("Heu introduït una dada invàlida (id). Si us plau, torneu a intentar-ho.");
          intent++;
          sc.next();
        }
      } while (!validaEntrada && intent <= INTENTS && !sortir);
            

      // un cop finalitzada l'entrada de dades, tornem a demanar si volem introduir més dades
      intent = 1;
      do {
        System.out.println("Vols introduir dades d'una nova família?:[1] sí / [0] no.");
        validaEntrada = sc.hasNextInt();
        if (validaEntrada) {
          segueix = sc.nextInt();
          switch (segueix) {
            case 1:
              break;
            case 0:
              if (entrades != 1) {
                System.out.println("Has introduït dades de " + entrades + " famílies.");
              } else {
                System.out.println("Has introduït dades d'" + entrades + " família.");
              }
              sortir = true;
              break;
            default:
              System.out.println("Valor incorrecte, torna-ho a intentar.");
              sc.next();
              validaEntrada = false;
              break;
          }
        } else {
          System.out.println("Valor incorrecte, torna-ho a intentar.");
          sc.next();
          validaEntrada = false;
        }
      } while (!validaEntrada && !sortir);
    } while (segueix != 0 || !sortir); // finalitza introducció famílies
        
    if (sortir) {
      System.out.println("Has indicat que vols finalitzar anticipadament el programa.");
    }
    
    System.out.println("A continuació un resum de totes les dades emmagatzemades en aquesta sessió:");
    System.out.println("item\tID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon\n");
    
    for (int i = 0; i < c; i++) {
      System.out.print(i + "\t");
      System.out.print(id[i] + "\t");
      System.out.print(places[i] + "\t");
      
      switch (parla[i]) { // determinació text a mostrar
        case 0:
          textParla = PARLA_0;
          break;
        case 1:
          textParla = PARLA_1;
          break;
        default:
          textParla = " "; // s'ha de definir un cas default per compilar
      }
      System.out.print(textParla + "\t\t");
      
      switch (tipus[i]) {
        case 0:
          textTipus = TIPUS_0;
          break;
        case 1:
          textTipus = TIPUS_1;
          break;
        case 2:
          textTipus = TIPUS_2;
          break;
        case 3:
          textTipus = TIPUS_3;
          break;
        default:
          textTipus = " "; // s'ha de definir un cas default per compilar
      }
      System.out.print(textTipus + "\t");
      System.out.print(telefon[i] + "\n");
    }
    // Tancament de la interfície
    System.out.println("Gràcies per haver utilitzat el nostre programa!");
        
  } 
}
