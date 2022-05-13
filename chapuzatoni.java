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
public class mostraplaces {

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
		int q = 0; // q es el comptador de posiciones.
		int tipusHab = 0;
		// TONI
		int[] id_plus = new int[MAXIM_FAM];
		int[] places_plus = new int[MAXIM_FAM];
		int[] parlaRusUcrania_plus = new int[MAXIM_FAM];
		int[] tipus_plus = new int[MAXIM_FAM];
		int opcio_plus = 0;
		int[] telefon_plus = new int[MAXIM_FAM];
		int tipusHab_plus = 0;
		int a = 0;
		int vols_saber = 0;
		// TONI

		Scanner scan = new Scanner(System.in); // aquesta linea es necessaria per la lectura de dades.

		String tipus_hab = "";
		String res_ru = "";
		boolean opcioCorrecta;
		boolean introduirMes;
		do {
			introduirMes = false;

			do {
				introduirMes = false;// per defecte, no volem introduir més
				// si no ens indiquem el contrari
				// llegim i mirem si es correcta
				System.out.print("Entreu el ID:  ");
				opcioCorrecta = scan.hasNextInt();// per analitzar tipus de dada
				if (opcioCorrecta) {
					// llegim les dades
					id[q] = scan.nextInt();

					// avaluem si es valid
					if ((id[q] < ID_MINIM) || (id[q] > ID_MAXIM)) {
						opcioCorrecta = false;
						i++;
						System.out.println("Número de id erroni");
					} else {
						i = MAXIM_INTENTS;
						// TONI
						for (int x = 0; x < id.length; x++)
							id_plus[a] = id[q];
						// TONI
					}

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
							// TONI
							for (int y = 0; y < places.length; y++)
								places_plus[a] = places[q];
							// TONI
						}
					}

				} while (i < MAXIM_INTENTS);
			}
			if (opcioCorrecta) {
				i = 0;
				do {
					System.out.print("Parleu rus o ucraïnes (0:no / 1:si)?: ");
					opcioCorrecta = scan.hasNextInt();
					if (opcioCorrecta) {
						parlaRusUcrania[q] = scan.nextInt(); // Llegim dades
						switch (parlaRusUcrania[q]) {
						case PARLARU_SI:
							res_ru = RES_SI;
							break;
						case PARLARU_NO:
							res_ru = RES_NO;
							break;

						}
						// Avaluem si és vàlida. Si és < 0 o > 1 serà incorrecta
						if ((parlaRusUcrania[q] < PARLARU_NO) || (parlaRusUcrania[q] > PARLARU_SI)) {
							opcioCorrecta = false;
							System.out.println("Entrada incorrecta");
							i++;
						} else {
							i = MAXIM_INTENTS;
							// TONI
							for (int z = 0; z < parlaRusUcrania.length; z++)
								parlaRusUcrania_plus[a] = parlaRusUcrania[q];
							// TONI

						}
					}

				} while (i < MAXIM_INTENTS);
			}
			if (opcioCorrecta) {
				i = 0;
				do {
					System.out.print("Tipus d'allotjament?: \n " + "Habitació compartida (0) \n" + "Habitació (1)  \n"
							+ "Habitació sencer (2) \n" + "Sala comunitaria, local habilitat (3)");
					opcioCorrecta = scan.hasNextInt();

					if (opcioCorrecta) {
						tipus[q] = scan.nextInt();
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
						if ((tipus[q] < TIPUS_MINIM || tipus[q] > TIPUS_MAXIM)) {
							opcioCorrecta = false;
							System.out.println("Entrada incorrecta");
							i++;
						} else {
							i = MAXIM_INTENTS;
							// TONI
							for (int w = 0; w < tipus.length; w++)
								tipus_plus[a] = tipus[q];
							// TONI
						}

					}

				} while (i < MAXIM_INTENTS);

				if (opcioCorrecta) {

					i = 0;
					do {
						System.out.print("telèfon de contacte?");
						opcioCorrecta = scan.hasNextInt();
						if (opcioCorrecta) {
							telefon[q] = scan.nextInt();
							if ((telefon[q] < TELEFON_MINIM) || telefon[q] > TELEFON_MAXIM) {
								opcioCorrecta = false;
								System.out.println("Numero de telefon erroni");
								i++;
							} else {
								i = MAXIM_INTENTS;

								// TONI
								for (int v = 0; v < telefon.length; v++)
									telefon_plus[a] = telefon[q];
								// TONI

							}
						}

					} while (i < MAXIM_INTENTS);

				}

			}
			// mostrem el resultat
			System.out.println("\nID    places   rus/ucraines   \t\ttipus       \ttelèfon");
			System.out.println(
					id + "    " + places + "         " + res_ru + "       " + tipus_hab + "      " + telefon + "   ");
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
		System.out.println("s´ha introduit " + comptador + " registre familiars");
		System.out.println("\nID    places   rus/ucraines   \t\ttipus       \ttelèfon");
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

			// System.out.println("Vols consultar per tipus d'allotjament(si: 1/no:0)");
			// opcioCorrecta = scan.hasNextInt();
			// if (opcioCorrecta) {
			// seguent = scan.nextInt();
			// si es vol afegir mes families.
			// if (seguent == RESPOSTA_SI) {
			// System.out.print("Tipus d'allotjament?: \n "
			// + "Habitació compartida (0) \n"
			// + "Habitació (1) \n"
			// + "Habitació sencer (2) \n"
			// + "Sala comunitaria, local habilitat (3)");
			// opcioCorrecta = scan.hasNextInt(); //comprovem que el valor introduit es
			// correcte

			// if (opcioCorrecta) {
			// tipusHab = scan.nextInt();

			// switch (tipusHab) {
			// case TIPUS_HCOMPARTIDA:
			// tipus_hab = HAB_COM;
			// break;
			// case TIPUS_HABITACIO:
			// tipus_hab = HAB;
			// break;
			// case TIPUS_HSENCER:
			// tipus_hab = HAB_SEN;
			// break;
			// case TIPUS_SCOMPARTIDA:
			// tipus_hab = SALA_COM;
			// break;

			// }
			// }

			// }

			}

			// TONI
			// System.out.println(id[q] + "\t" + places[q] + "\t" + res_ru + "\t\t\t" +
			// tipus_hab + "\t" + telefon[q]);

			System.out.println("Vols saber quants usuaris ofereixen varies places? 0=NO, 1=SI");

		}
		opcioCorrecta = scan.hasNextInt();
		vols_saber = scan.nextInt();
		if (vols_saber == RESPOSTA_SI) {
			System.out.println("Usuaris que ofereixen varies places");
			for (int x = 0; x < places.length; x++) {
				if (places[a] > 2) {
					System.out.println(
							id[a] + "\t" + places[a] + "\t" + res_ru + "\t\t\t" + tipus_hab + "\t" + telefon[a]);
				}
			}

			if (vols_saber == RESPOSTA_NO) {
				System.out.println("Bye");
				// TONI
			}

		}
	}
}
