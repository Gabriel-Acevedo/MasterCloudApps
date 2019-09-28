/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gabri
 */
public class Mastermind {
    
    public static Game juego = new Game();
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        do{
            System.out.println("----Mastermind----");
            juego.Play();
            System.out.println("¿Do you want to continue (s/n)?");
            respuesta = sc.next();
        }while(respuesta.toUpperCase().equals("S"));
    }        
}



