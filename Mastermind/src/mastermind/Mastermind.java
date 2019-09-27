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
 * @author AcevedoApps011
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        String a, b, c, color1, color2, reiniciar;
        Scanner sc = new Scanner(System.in);
        Mastermind mm = new Mastermind();
        int resvalidar, turnos=0;
        int [] muertos_heridos;
        
        System.out.println("Bienvenido al juego MASTERMIND.");
        System.out.println("-------------------------------");
        
        do{
            System.out.println("Jugador1: Introduzca una combinacion de 4 colores entre los siguientes disponibles VARNBMPC:");
            a=sc.next();
            color1=a.toUpperCase();
            resvalidar=mm.validarColor(color1);
            
            if (resvalidar == 1){
                System.out.println("La longitud de la combinacion debe ser de 4 colores.");
            }else{
                if(resvalidar == 2){
                    System.out.println("En la combinacion: " + color1 + " hay colores que no estan disponibles dentro de VARNBMPC.");
                }else{
                    if(resvalidar == 3){
                        System.out.println("No se pueden repetir los colores. Combinacion utilizada: " + color1);
                    }
                }
            }
 
        System.out.println("");
            
        }while(resvalidar != 0);
        
        do{
            turnos++;
            do{
                System.out.println("***TURNO: " + turnos + "***");
                System.out.println("Jugador2: Intente adivinar los colores del Jugador 1 introduciendo tambien una combinacion de 4 colores entre los siguientes disponibles VARNBMPC:");
                b=sc.next();
                color2=b.toUpperCase();
                resvalidar=mm.validarColor(color2);

                if (resvalidar == 1){
                    System.out.println("La longitud de la combinacion debe ser de 4 colores.");
                }else{
                    if(resvalidar == 2){
                        System.out.println("En la combinacion: " + color1 + " hay colores que no estan disponibles dentro de VARNBMPC.");
                    }else{
                        if(resvalidar == 3){
                            System.out.println("No se pueden repetir los colores. Combinacion utilizada: " + color1);
                        }
                    }
                }

            }while(resvalidar != 0);

            muertos_heridos=mm.muertos_heridos(color1,color2);
            System.out.println("Turno:" + turnos + " . Ha habido --> " + muertos_heridos[0] + " muertos y " + muertos_heridos[1] + " heridos.");            
            System.out.println("");            
            
        }while(turnos != 10 && muertos_heridos[0] != 4);
        
        if (turnos==10){
            System.out.println("");
            System.out.println("*****************************************************");
            System.out.println("Se han pasado los turnos. El ganador es el JUGADOR 1");
            System.out.println("*****************************************************");
        }
        
        if (muertos_heridos[0] == 4){
            System.out.println("");
            System.out.println("**********************************************");
            System.out.println("Ha ganado el JUGADOR 2 en el turno: " + turnos);
            System.out.println("**********************************************");
        }
        
        System.out.println("¿Desea volver a jugar (s/n)?");
        c = sc.next();
        reiniciar = c.toUpperCase();
        if (reiniciar=="S"){
            System.out.println("Reiniciando el juego...");
            Mastermind.main(null);
        }
    }
    
    static int validarColor(String color) throws IOException{
        int control;
        char letra1,letra2,letra3,letra4; 
        String cvalidos="VARNBMPC";
        
        letra1=color.charAt(0);
        letra2=color.charAt(1);
        letra3=color.charAt(2);
        letra4=color.charAt(3);
        
        if (color.length() == 4){
            control=0;
        }else{
            control=1;
            return control;
        }
       
        if( (cvalidos.contains(String.valueOf(letra1))) && (cvalidos.contains(String.valueOf(letra2))) && (cvalidos.contains(String.valueOf(letra3))) && (cvalidos.contains(String.valueOf(letra4))) ){
            control=0;
        }else{
            control=2;
            return control;
        }
        
        int[] count = new int[255];
        int length = color.length();
        for (int i = 0; i < length; i++) {
            count[color.charAt(i)]++;	
        }
        
        char[] ch = new char[color.length()];
	for (int i = 0; i < length; i++) {
            ch[i] = color.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (color.charAt(i) == ch[j])
                find++;
            }
            if (find == 1) {
                if (count[color.charAt(i)] <= 1){
                    control = 0;
                }else{
                    control = 3;
                    break;
                }
            }
                        
	}
   
        return control;
    }
    
    
    static int [] muertos_heridos(String colorJ1, String colorJ2){
        int [] moh = new int[2];
          
        char letra1J1,letra2J1,letra3J1,letra4J1;
        char letra1J2,letra2J2,letra3J2,letra4J2;
        int cont_muertos=0,cont_heridos=0;
        
        letra1J1=colorJ1.charAt(0);
        letra2J1=colorJ1.charAt(1);
        letra3J1=colorJ1.charAt(2);
        letra4J1=colorJ1.charAt(3);
        
        letra1J2=colorJ2.charAt(0);
        letra2J2=colorJ2.charAt(1);
        letra3J2=colorJ2.charAt(2);
        letra4J2=colorJ2.charAt(3);
        
        if(letra1J1==letra1J2){
            cont_muertos ++;
        }else{
            if(colorJ1.contains(String.valueOf(letra1J2))){
              cont_heridos++;  
            }
        }
        
        if(letra2J1==letra2J2){
            cont_muertos ++;
        }else{
            if(colorJ1.contains(String.valueOf(letra2J2))){
              cont_heridos++;  
            }
        }
        
        if(letra3J1==letra3J2){
            cont_muertos ++;
        }else{
            if(colorJ1.contains(String.valueOf(letra3J2))){
              cont_heridos++;  
            }
        }
        
        if(letra4J1==letra4J2){
            cont_muertos ++;
        }else{
            if(colorJ1.contains(String.valueOf(letra4J2))){
              cont_heridos++;  
            }
        }
        
        moh[0] = cont_muertos;
        moh[1] = cont_heridos;
        
        return moh;
    }
    
}
