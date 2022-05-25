/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProjecteFinal;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class P4_e2_FortunoR {

    public static final int ID_MINIM = 10;
    public static final int ID_MAXIM = 999;
    public static final int PLACES_MINIM = 1;
    public static final int PLACES_MAXIM = 99;
    public static final int PARLARU_NO = 0;
    public static final int PARLARU_SI = 1;
    public static final int TIPUS_HCOMPARTIDA = 0;
    public static final int TIPUS_HABITACIO = 1;
    public static final int TIPUS_HSENCER = 2;
    public static final int TIPUS_SCOMPARTIDA = 3;
    public static final int TIPUS_MINIM = 0;
    public static final int TIPUS_MAXIM = 3;
    public static final int TELEFON_MINIM = 111111111;
    public static final int TELEFON_MAXIM = 999999999;
    public static final String HAB_COM = "Habitacio compartida";
    public static final String HAB_SEN = "Habitacio sencera";
    public static final String HAB = "Habitacio";
    public static final String SALA_COM = "Sala comunitària, local habilitat";
    public static final String RES_SI = "Sí";
    public static final String RES_NO = "No";
    public static final int MAXIM_INTENTS = 3;

    public static final int MAXIM_FAM = 10;
    public static final int RESPOSTA_SI = 1;
    public static final int RESPOSTA_NO = 0;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {

        // definim les dades 
        int[][] families = new int[5][MAXIM_FAM];
        
        int[] id = new int[MAXIM_FAM];
        int[] places = new int[MAXIM_FAM];
        int[] parlaRusUcrania = new int[MAXIM_FAM];
        int[] tipus = new int[MAXIM_FAM];
        int opcio = 0;
        int[] telefon = new int[MAXIM_FAM];
        int i = 0;
        int seguent = 0;
        int comptador = 0;
        int q = 0; //q es el comptador de posiciones.
        int tipusHab = 0;
        int aux; // per al reordenament de l'array
        int vols_saber = 0;//pregunta resum final
        int cuentarusos = 0;
        int cuentahabcomp = 0;
        int cuentahab = 0;
        int cuentahabsen = 0;
        int cuentalocal = 0;

        Scanner scan = new Scanner(System.in); //aquesta linea es necessaria per la lectura de dades.

        String tipus_hab = "";
        String res_ru = "";
        boolean opcioCorrecta;
        boolean introduirMes;
        do {
            introduirMes = false;
            
            do {
                introduirMes = false;//per defecte, no volem introduir més 
                //si no ens indiquem el contrari
                //llegim i mirem si es correcta
                System.out.print("Entreu l'ID:  ");
                opcioCorrecta = scan.hasNextInt();//per analitzar tipus de dada
                if (opcioCorrecta) {
                    //llegim les dades
                    families[q][0] = scan.nextInt(); //avaluem si es valid 
                    if ((families[q][0] < ID_MINIM) || (families[q][0] > ID_MAXIM)) {
                        opcioCorrecta = false;

                        System.out.println("Número d'ID erroni");
                        
                    }

                } else {
                    System.out.println("Error: ha de ser un número");
                    scan.next();
                }
                i++;

            } while ((!opcioCorrecta) && (i < MAXIM_INTENTS));

            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Número de places disponibles:  ");
                    opcioCorrecta = scan.hasNextInt();
                    if (opcioCorrecta) {

                        families[q][1] = scan.nextInt();
                        if ((families[q][1] < PLACES_MINIM) || families[q][1] > PLACES_MAXIM) {
                            //i++;
                            opcioCorrecta = false;
                            System.out.println("Número de places erroni");
                        }
                    } else {
                        System.out.println("Número de places incorrecte.");
                        scan.next();
                    }
                    i++;
                } while ((!opcioCorrecta) && (i < MAXIM_INTENTS));
            }
            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Parleu rus o ucraïnès (0:no / 1:sí)?:  ");
                    opcioCorrecta = scan.hasNextInt();
                    if (opcioCorrecta) {
                        families[q][2] = scan.nextInt(); //Llegim dades
                        switch (families[q][2]) {
                            case PARLARU_SI:
                                res_ru = RES_SI;
                                cuentarusos++;
                                break;
                            case PARLARU_NO:
                                res_ru = RES_NO;
                                break;

                        }
                        //Avaluem si és vàlida. Si és < 0 o > 1 serà incorrecta
                        if ((families[q][2] < PARLARU_NO) || (families[q][2] > PARLARU_SI)) {
                            opcioCorrecta = false;
                            System.out.println("Entrada incorrecta");

                        }
                    } else {
                        System.out.println("La informació no és correcta.");
                        scan.nextLine();
                    }
                    i++;

                } while ((!opcioCorrecta) && (i < MAXIM_INTENTS));
            }
            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Tipus d'allotjament: \n "
                            + "Habitació compartida (0) \n"
                            + "Habitació (1)  \n"
                            + "Habitació sencera (2) \n"
                            + "Sala comunitària, local habilitat (3)  ");
                    opcioCorrecta = scan.hasNextInt();

                    if (opcioCorrecta) {
                        families[q][3] = scan.nextInt();
                        switch (families[q][3]) {
                            case TIPUS_HCOMPARTIDA:
                                tipus_hab = HAB_COM;
                                cuentahabcomp++;
                                break;
                            case TIPUS_HABITACIO:
                                tipus_hab = HAB;
                                cuentahab++;
                                break;
                            case TIPUS_HSENCER:
                                tipus_hab = HAB_SEN;
                                cuentahabsen++;
                                break;
                            case TIPUS_SCOMPARTIDA:
                                tipus_hab = SALA_COM;
                                cuentalocal++;
                                break;
                        }
                        if ((families[q][3] < TIPUS_MINIM || families[q][3] > TIPUS_MAXIM)) {
                            opcioCorrecta = false;
                            System.out.println("Entrada incorrecta");

                        }

                    } else {
                        scan.nextLine();
                    }
                    i++;

                } while ((!opcioCorrecta) && (i < MAXIM_INTENTS));

                if (opcioCorrecta) {

                    i = 0;
                    do {
                        System.out.print("Telèfon de contacte:  ");
                        opcioCorrecta = scan.hasNextInt();
                        if (opcioCorrecta) {
                            families[q][4] = scan.nextInt();
                            if ((families[q][4] < TELEFON_MINIM) || families[q][4] > TELEFON_MAXIM) {
                                opcioCorrecta = false;
                                System.out.println("Número de telèfon erroni");
                                //i++;
                            }
                        } else {
                            i++;
                            scan.nextLine();
                        }

                    } while ((!opcioCorrecta) && (i < MAXIM_INTENTS));

                }
                

            }
            //mostrem el resultat
            if (opcioCorrecta) {
                System.out.println("\nID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon");
                System.out.println(families[q][0] + "    " + families[q][1] + "         " + res_ru + "       " + tipus_hab + "      " + families[q][4]);
            }
          
            comptador++;
            q++;
            
            System.out.println("Voleu afegir una altre dada? 0:No / 1:Si");
            opcioCorrecta = scan.hasNextInt();
            if (opcioCorrecta) {
                seguent = scan.nextInt();
                i=0;
                if (seguent == 1) {
                    introduirMes = true;

                } else {
                    introduirMes = false;
                }
            }

        } while (introduirMes);
        if (opcioCorrecta) {

            System.out.println("Heu introduït " + comptador + " registres familiars");
            System.out.println("\nID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon");

            for (q = 0; q < comptador; q++) {
                switch (families[q][2]) {
                    case PARLARU_SI:
                        res_ru = RES_SI;
                        break;
                    case PARLARU_NO:
                        res_ru = RES_NO;
                        break;
                }
                switch (families[q][3]) {
                    case TIPUS_HCOMPARTIDA:
                        tipus_hab = HAB_COM;
                        break;
                    case TIPUS_HABITACIO:
                        tipus_hab = HAB;
                        break;
                    case TIPUS_HSENCER:
                        tipus_hab = HAB_SEN;
                        break;
                    case TIPUS_SCOMPARTIDA:
                        tipus_hab = SALA_COM;
                        break;
                }
                System.out.println(families[q][0] + "\t" + families[q][1] + "\t" + res_ru + "\t\t\t" + tipus_hab + "\t" + families[q][4]);
            }
        }

        // PART AARÓN ampliació 1
        System.out.println("Vols consultar per número de places? (sí: 1 / no: 0");
        opcioCorrecta = scan.hasNextInt();
        if (opcioCorrecta) { // comprova si tipus de dada correcta
            seguent = scan.nextInt();
            if (seguent == RESPOSTA_SI) { // comprova si ha introduït "1"
                System.out.println("Quantes places necessites?");
                opcioCorrecta = scan.hasNextInt(); // comprova si tipus de dada correcta
                if (opcioCorrecta) {
                    seguent = scan.nextInt();
                    if (seguent >= 1) {

                        // ordenació arrays
                        for (int b = 0; b < comptador; b++) {

                            for (int c = 0; c < comptador - 1; c++) {

                                if (families[b][1] < families[c][1]) {

                                    // intercanvi array id
                                    aux = families[b][0];
                                    families[b][0] = families[c][0];
                                    families[c][0] = aux;

                                    // intercanvi array places
                                    aux = families[b][1];
                                    families[b][1] = families[c][1];
                                    families[c][1] = aux;

                                    // intercanvi array llengua
                                    aux = families[b][2];
                                    families[b][2] = families[c][2];
                                    families[c][2] = aux;

                                    // intercanvi array tipus
                                    aux = families[b][3];
                                    families[b][3] = families[c][3];
                                    families[c][3] = aux;

                                    // intercanvi array telefon
                                    aux = families[b][4];
                                    families[b][4] = families[c][4];
                                    families[c][4] = aux;
                                }
                            }
                        }

                        System.out.println("\nID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon");
                        for (q = 0; q < comptador; q++) {
                            if (families[q][2] >= seguent) {
                                switch (families[q][2]) {
                                    case PARLARU_SI:
                                        res_ru = RES_SI;
                                        break;
                                    case PARLARU_NO:
                                        res_ru = RES_NO;
                                        break;
                                }

                                switch (families[q][3]) {
                                    case TIPUS_HCOMPARTIDA:
                                        tipus_hab = HAB_COM;
                                        break;
                                    case TIPUS_HABITACIO:
                                        tipus_hab = HAB;
                                        break;
                                    case TIPUS_HSENCER:
                                        tipus_hab = HAB_SEN;
                                        break;
                                    case TIPUS_SCOMPARTIDA:
                                        tipus_hab = SALA_COM;
                                        break;
                                }

                                System.out.println(families[q][0] + "\t" + families[q][1] + "\t" + res_ru + "\t" + tipus_hab + "\t" + families[q][4]); // mostra només si el nombre és igual o superior al demanat
                            }
                        }
                    }
                } else {
                    scan.next();
                }
            }
        } else {
            scan.next();
        }
/*
        // PART OSCAR ampliació 3
        System.out.println("Vols consultar per tipus d'allotjament(si: 1/no:0)");
        opcioCorrecta = scan.hasNextInt();
        if (opcioCorrecta) {
            seguent = scan.nextInt();

            if (seguent == RESPOSTA_SI) {
                System.out.println("Tipus d'allotjament?: \n "
                        + "Habitació compartida (0) \n"
                        + "Habitació (1)  \n"
                        + "Habitació sencera (2) \n"
                        + "Sala comunitària, local habilitat (3)");
                opcioCorrecta = scan.hasNextInt(); //comprovem que el valor introduit es correcte

                if (opcioCorrecta) {
                    tipusHab = scan.nextInt();

                    switch (tipusHab) {
                        case TIPUS_HCOMPARTIDA:
                            tipus_hab = HAB_COM;
                            break;
                        case TIPUS_HABITACIO:
                            tipus_hab = HAB;
                            break;
                        case TIPUS_HSENCER:
                            tipus_hab = HAB_SEN;
                            break;
                        case TIPUS_SCOMPARTIDA:
                            tipus_hab = SALA_COM;
                            break;

                    }

                    for (q = 0; q < comptador; q++) {
                        switch (parlaRusUcrania[q]) {
                            case PARLARU_SI:
                                res_ru = RES_SI;
                                break;
                            case PARLARU_NO:
                                res_ru = RES_NO;
                                break;

                        }
                        switch (tipus[q]) {
                            case TIPUS_HCOMPARTIDA:
                                tipus_hab = HAB_COM;
                                break;
                            case TIPUS_HABITACIO:
                                tipus_hab = HAB;
                                break;
                            case TIPUS_HSENCER:
                                tipus_hab = HAB_SEN;
                                break;
                            case TIPUS_SCOMPARTIDA:
                                tipus_hab = SALA_COM;
                                break;
                        }

                        if (tipus[q] == tipusHab) {
                            System.out.println("\nID\tPlaces\tRus/Ucraïnès\tTipus\t\t\t\tTelèfon");
                            System.out.println(id[q] + "\t" + places[q] + "\t" + res_ru + "\t" + tipus_hab + "\t" + telefon[q]);
                        }
                    }
                } else {
                    scan.nextLine();
                }
            }
        } else {
            scan.nextLine();
        }
        boolean avkpacha;// Part 3 Toni; Resum estadistic
        int suma = 0;
        System.out.println("Vols un resum? 0=NO 1=SI");

        for (int j = 0; j < places.length; j++) {
            suma = suma + places[j];
        }
        if (avkpacha = scan.hasNextInt()) {
            vols_saber = scan.nextInt();
        }
        if (vols_saber == RESPOSTA_SI) {
            System.out.println("Número de famílies que acullen = " + comptador);
            System.out.println("Número total de places = " + suma);
            System.out.println("Parla Rus o Ucraïnès = " + cuentarusos);
            System.out.println("Total Habitacions Compartides = " + cuentahabcomp);
            System.out.println("Total Habitacions Normals = " + cuentahab);
            System.out.println("Total Habitacions Senceres = " + cuentahabsen);
            System.out.println("Total Locals Habilitats = " + cuentalocal);
        } else {

            scan.next();
            System.out.println("Adeu!");

        }*/

    }

}
