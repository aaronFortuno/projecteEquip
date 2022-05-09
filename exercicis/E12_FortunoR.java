/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unitat3.EACs;

import java.util.Scanner;

/**
 *
 * @author aaronFortuno
 */
public class E12_FortunoR {
    
    // programa per a emmagatzemar dades d'usuaris a una col·lecció
    public static void main (String[] args) {
        
        // inicialització scanner
        Scanner sc = new Scanner(System.in);
        
        
        int nombreEntrades = 0, codi = 0, aux;
        boolean validaEntrada;
        
        System.out.print("Quants usuaris vols introduir?: ");
        do {
            validaEntrada = sc.hasNextInt(); // validació tipus
            if (validaEntrada) {
                nombreEntrades = sc.nextInt();
                if (nombreEntrades < 1) { // validació rang
                    System.out.println("No has introduït un nombre vàlid d'usuaris, torna-ho a intentar.");
                    validaEntrada = false;
                    sc.nextLine();
                } else {
                    if (nombreEntrades == 1) { // singular/plural
                        System.out.println("Has indicat que vols introduir dades d'1 usuari.");
                    } else {
                        System.out.println("Has indicat que vols introduir " + nombreEntrades + " usuaris.");
                    }
                    
                    
                }
            } else {
                System.out.println("No has introduït un nombre, torna-ho a intentar.");
                validaEntrada = false;
                sc.nextLine();
            }
        } while (!validaEntrada);
        
        // declaració i inicialització de l'array amb la longitud ja coneguda
        // donava un error de compilació declarar-la a l'inici i inicialitzar-la després
        int[] usuaris = new int[nombreEntrades];
        System.out.println("La llista d'usuaris té una longitud de " + usuaris.length + " posicions.");
        
        for (int i = 0; i < usuaris.length; i++) { // omple la llista de nombres
            do {
                System.out.print("Introdueix un codi [0-1000] per desar a la posició " + (i + 1) + ": ");
                validaEntrada = sc.hasNextInt(); // valida tipus
                if (validaEntrada) {
                    codi = sc.nextInt();
                    if (codi < 0 || codi > 1000) {
                        System.out.println("No és dins del rang vàlid [0-1000], torna-ho a intentar.");
                        validaEntrada = false;
                    } else {
                        usuaris[i] = codi;
                        System.out.println("Codi " + codi + " emmagatzemat correctament a la posició " + (i + 1));
                    }
                } else {
                    System.out.println("No has introduït un nombre, torna-ho a intentar.");
                    validaEntrada = false;
                    sc.nextLine();
                }
            } while (!validaEntrada);
        }
        
        // publica llista sense endreçar
        System.out.println("Llistat de tots els codis entrats:");
        for (int i = 0; i < usuaris.length; i++) {
            System.out.print(usuaris[i] + " ");
        }
        
        System.out.println("\nEndreçant llista, espereu...");
        // ordenació dels elements de la llista
        for (int i = 1; i < usuaris.length; i++) {
            for (int j = 0; j < usuaris.length - 1; j++) {
                if (usuaris[i] < usuaris[j]) {
                    aux = usuaris[i];
                    usuaris[i] = usuaris[j];
                    usuaris[j] = aux;
                }
            }
        }
        
        // publica la llista endreçada
        System.out.println("Lista endreçada: ");
        for (int i = 0; i < usuaris.length; i++) {
            System.out.print(usuaris[i] + " ");
        }
    }
}
