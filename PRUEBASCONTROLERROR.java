/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mostraplaces;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class p03_compis {

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
    public static final String HAB_SEN = "Habitacio sencer";
    public static final String HAB = "Habitacio";
    public static final String SALA_COM = "Sala comunitaria, local habilitat";
    public static final String RES_SI = "Si";
    public static final String RES_NO = "No";
    public static final int MAXIM_INTENTS = 3;

    public static final int MAXIM_FAM = 10;
    public static final int RESPOSTA_SI = 1;
    public static final int RESPOSTA_NO = 0;

    public static void main(String[] args) {

        // definim les dades 
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
                introduirMes = false;//per defecte, no volem introduir m??s 
                //si no ens indiquem el contrari
                //llegim i mirem si es correcta
                System.out.print("Entreu el ID:  ");
                opcioCorrecta = scan.hasNextInt();//per analitzar tipus de dada
                if (opcioCorrecta) {
                    //llegim les dades
                    id[q] = scan.nextInt(); //avaluem si es valid 
                    if ((id[q] < ID_MINIM) || (id[q] > ID_MAXIM)) {
                        opcioCorrecta = false;
                        i++;
                        System.out.println("N??mero de id erroni");
                    } else {
                        i = MAXIM_INTENTS;
                    }

                } else {
                    scan.nextLine();
                }

            } while (i < MAXIM_INTENTS);

            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Numero de places disponibles?");
                    opcioCorrecta = scan.hasNextInt();
                    if (opcioCorrecta) {

                        places[q] = scan.nextInt();
                        if ((places[q] < PLACES_MINIM) || places[q] > PLACES_MAXIM) {
                            i++;
                            opcioCorrecta = false;
                            System.out.println("Numero de places erroni");
                        } else {
                            i = MAXIM_INTENTS;
                        }
                    } else {
                        scan.nextLine();
                    }

                } while (i < MAXIM_INTENTS);
            }
            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Parleu rus o ucra??nes (0:no / 1:si)?: ");
                    opcioCorrecta = scan.hasNextInt();
                    if (opcioCorrecta) {
                        parlaRusUcrania[q] = scan.nextInt(); //Llegim dades
                        switch (parlaRusUcrania[q]) {
                            case PARLARU_SI:
                                res_ru = RES_SI;
                                cuentarusos++;
                                break;
                            case PARLARU_NO:
                                res_ru = RES_NO;
                                break;

                        }
                        //Avaluem si ??s v??lida. Si ??s < 0 o > 1 ser?? incorrecta
                        if ((parlaRusUcrania[q] < PARLARU_NO) || (parlaRusUcrania[q] > PARLARU_SI)) {
                            opcioCorrecta = false;
                            System.out.println("Entrada incorrecta");
                            i++;
                        } else {
                            i = MAXIM_INTENTS;

                        }
                    } else {
                        scan.nextLine();
                    }

                } while (i < MAXIM_INTENTS);
            }
            if (opcioCorrecta) {
                i = 0;
                do {
                    System.out.print("Tipus d'allotjament?: \n "
                            + "Habitaci?? compartida (0) \n"
                            + "Habitaci?? (1)  \n"
                            + "Habitaci?? sencer (2) \n"
                            + "Sala comunitaria, local habilitat (3)");
                    opcioCorrecta = scan.hasNextInt();

                    if (opcioCorrecta) {
                        tipus[q] = scan.nextInt();
                        switch (tipus[q]) {
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
                        if ((tipus[q] < TIPUS_MINIM || tipus[q] > TIPUS_MAXIM)) {
                            opcioCorrecta = false;
                            System.out.println("Entrada incorrecta");
                            i++;
                        } else {
                            i = MAXIM_INTENTS;
                        }

                    } else {
                        scan.nextLine();
                    }

                } while (i < MAXIM_INTENTS);

                if (opcioCorrecta) {

                    i = 0;
                    do {
                        System.out.print("tel??fon de contacte?");
                        opcioCorrecta = scan.hasNextInt();
                        if (opcioCorrecta) {
                            telefon[q] = scan.nextInt();
                            if ((telefon[q] < TELEFON_MINIM) || telefon[q] > TELEFON_MAXIM) {
                                opcioCorrecta = false;
                                System.out.println("Numero de telefon erroni");
                                i++;
                            } else {
                                i = MAXIM_INTENTS;
                            }
                        } else {
                            scan.nextLine();
                        }

                    } while (i < MAXIM_INTENTS);

                }

            }
            //mostrem el resultat
            System.out.println("\nID    places   rus/ucraines   \t\ttipus       \ttel??fon");
            System.out.println(id[q] + "    " + places[q] + "         " + res_ru + "       " + tipus_hab + "      " + telefon[q]);
            System.out.println("Volem afegir una altre dada 0:No / 1:Si");
            comptador++;
            q++;
            opcioCorrecta = scan.hasNextInt();
            if (opcioCorrecta) {
                seguent = scan.nextInt();
                if (seguent == 1) {
                    introduirMes = true;

                } else {
                    introduirMes = false;
                }
            }

        } while (introduirMes);
        System.out.println("s??ha introduit " + comptador + " registre familiars");
        System.out.println("\nID    places   rus/ucraines   \t\ttipus       \ttel??fon");

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
            System.out.println(id[q] + "\t" + places[q] + "\t" + res_ru + "\t" + tipus_hab + "\t" + telefon[q]);
        }

        // PART AAR??N ampliaci?? 1
        System.out.println("Vols consultar per n??mero de places? (s??: 1 / no: 0");
        opcioCorrecta = scan.hasNextInt();
        if (opcioCorrecta) { // comprova si tipus de dada correcta
            seguent = scan.nextInt();
            if (seguent == RESPOSTA_SI) { // comprova si ha introdu??t "1"
                System.out.println("Quantes places necessites?");
                opcioCorrecta = scan.hasNextInt(); // comprova si tipus de dada correcta
                if (opcioCorrecta) {
                    seguent = scan.nextInt();
                    if (seguent >= 1) {

                        // ordenaci?? arrays
                        for (int b = 0; b < comptador; b++) {

                            for (int c = b; c < comptador - 1; c++) {

                                if (places[b] >= places[c]) {

                                    // intercanvi array id
                                    aux = id[b];
                                    id[b] = id[c];
                                    id[c] = aux;

                                    // intercanvi array places
                                    aux = places[b];
                                    places[b] = places[c];
                                    places[c] = aux;

                                    // intercanvi array llengua
                                    aux = parlaRusUcrania[b];
                                    parlaRusUcrania[b] = parlaRusUcrania[c];
                                    parlaRusUcrania[c] = aux;

                                    // intercanvi array tipus
                                    aux = tipus[b];
                                    tipus[b] = tipus[c];
                                    tipus[c] = aux;

                                    // intercanvi array telefon
                                    aux = telefon[b];
                                    telefon[b] = telefon[c];
                                    telefon[c] = aux;
                                }
                            }
                        }

                        System.out.println("\nID    places   rus/ucraines   \t\ttipus       \ttel??fon");
                        for (q = 0; q < comptador; q++) {
                            if (places[q] >= seguent) {
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

                                System.out.println(id[q] + "\t" + places[q] + "\t" + res_ru + "\t" + tipus_hab + "\t" + telefon[q]); // mostra nom??s si el nombre ??s igual o superior al demanat
                            }
                        }
                    }
                } else {
                    scan.nextLine();
                }
            }
        } else {
            scan.nextLine();
        }

      
        // PART OSCAR ampliaci?? 3
        System.out.println("Vols consultar per tipus d'allotjament(si: 1/no:0)");
        opcioCorrecta = scan.hasNextInt();
        if (opcioCorrecta) {
            seguent = scan.nextInt();

            if (seguent == RESPOSTA_SI) {
                System.out.println("Tipus d'allotjament?: \n "
                        + "Habitaci?? compartida (0) \n"
                        + "Habitaci?? (1)  \n"
                        + "Habitaci?? sencer (2) \n"
                        + "Sala comunitaria, local habilitat (3)");
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

			System.out.println("Numero total de places = " + suma);
			System.out.println("Parla Rus o Ucrania = " + cuentarusos);
			System.out.println("Total Habitacions Compartides = " + cuentahabcomp);
			System.out.println("Total Habitacions Normals = " + cuentahab);
			System.out.println("Total Habitacions Senceres = " + cuentahabsen);
			System.out.println("Total Locals Habilitats = " + cuentalocal);
		} else {

			scan.nextLine();
			System.out.println("Bye's");

		}
	}
}
