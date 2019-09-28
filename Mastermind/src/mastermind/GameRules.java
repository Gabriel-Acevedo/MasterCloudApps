/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gabri
 */
public class GameRules {
   
    static int CombLength = 4;
    static int AttemptLimit=10;
    static String CharEncr="*";
    
    public enum Colors{
        r,b,y,g,o,p;
    } 
    
    static int validarColor(String colorJ,String colDisp) throws IOException{
        int control=0;
        char[] checkDup = colorJ.toCharArray();
        if(colorJ.length()> CombLength || colorJ.length()< CombLength){
            System.out.println("Wrong proposed combination length");
            control=1;
            return control;
        }
        for(int i=0;i<colorJ.length();i++){
            char car = colorJ.charAt(i);
            if(!colDisp.contains(String.valueOf(car))){
                System.out.println("Wrong colors they must be: " + colDisp);
                control=2;
                return control;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c : checkDup){
            if(map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
           if(map.get(c) > 1) {
                System.out.println("Repeated colors");
                control=3;
                return control;
            } 
        }
        return control;
    } 
}
