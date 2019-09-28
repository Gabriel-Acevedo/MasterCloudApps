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

public class Game {
    
    public static GameRules rules = new GameRules();
    static int combLength = rules.CombLength;
    
    public  static char[] GenColorCombination (String colores){             
		int limit=combLength+1, i=0, j=0, combination[] = new int[combLength];
		char[] Colors = new char[combLength];
		combination[i]=(int)(Math.random()*limit);
		for(i=1;i<combination.length;i++){
                    combination[i]=(int)(Math.random()*limit);
                    for (j=0;j<i;j++){
			if (combination[i]==combination[j]){	
                            i--;
			}		
                    }
		}
		for(int x=0;x<combination.length;x++){
                    Colors[x] = colores.charAt(combination[x]);
		}		
		return Colors;	
    }
     
    public void Play() throws IOException{
        Scanner sc = new Scanner(System.in);
        String colorDisp="", colorJ, BoardRecord="";
        int control, attempts=1;      
        int [] muertos_heridos;      
        for(GameRules.Colors col: GameRules.Colors.values()){	
            colorDisp += col.toString();
        }
        char[] CombAdivinar=GenColorCombination(colorDisp);
        String ColorsEncr = String.format("%0" + combLength + "d", 0).replace("0", rules.CharEncr);
        do{
            do{
                System.out.print("Propose a combination: ");
                colorJ=sc.next(); 
                control = rules.validarColor(colorJ,colorDisp);
            }while(control !=0);
            System.out.println(attempts+" attempt(s):");
            System.out.println(ColorsEncr);
            attempts++;
            muertos_heridos=muertos_heridos(String.valueOf(CombAdivinar),colorJ);
            BoardRecord += colorJ+" --> "+muertos_heridos[0]+" blacks and "+muertos_heridos[1]+" whites \n";
            System.out.println(BoardRecord);

        }while(attempts<=rules.AttemptLimit && muertos_heridos[0] != combLength); 
        
        if(attempts<=rules.AttemptLimit){
            System.out.println("You´ve won!!!");
        }else{
            if(muertos_heridos[0] != combLength){
                System.out.println("You´ve lost!!!");
            }          
        }
      }
    
    static int [] muertos_heridos(String ColorAdiv, String ColorJ){
        int [] moh = new int[2];
        int cont_muertos=0,cont_heridos=0;
        for(int i=0;i<ColorJ.length();i++){
            if(ColorJ.charAt(i)==ColorAdiv.charAt(i)){
                cont_muertos++;
            }else{
                if(ColorAdiv.contains(String.valueOf(ColorJ.charAt(i)))){
                    cont_heridos++;
                }
            }
        }
        moh[0] = cont_muertos;
        moh[1] = cont_heridos;
        return moh;
    }   
}