/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors;

//import Random class
import java.util.Random;
//import Scanner class
import java.util.Scanner;

/**
 *
 * @author Jonathan Mendoza and Sergei Bessonov
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Rock-Paper-Scissors Game");
        System.out.println("Enter your choice (0=rock, 1=paper, 2=scissors):");
       
        //Computer Chose = cc
        Random rnd = new Random();
        int cc = rnd.nextInt(3);
        
        //User chose = uc
        Scanner sc = new Scanner(System.in);
        int uc = sc.nextInt();
        
        //variables for out.println:
        String r = "Rock(0) \n";
        String p = "Paper(1) \n";
        String s = "Scissors(2) \n";
        String draw = " Game was a Draw. \n You and Computer have chosen ";
        String uwins = " \n\t User wins! :) \n";
        String cwins = " \n\t Computer wins :( \n";
        String cchose = " Computer chose: \t";
        String uchose = " User chose: \t\t";
        
        //condition for input of user wrong number
        while (uc>2||uc<0)
        {
            System.out.println(+uc+ " it's a wrong number, please enter 0, 1 or 2");
            uc = sc.nextInt();
        }

        //draw
        if      (cc==0&&uc==0) System.out.println(draw +r);
        else if (cc==1&&uc==1) System.out.println(draw + p);
        else if (cc==2&&uc==2) System.out.println(draw + s);
        //user wins
        else if (cc==0&&uc==1) System.out.println(cchose + r + uchose + p + uwins);
        else if (cc==1&&uc==2) System.out.println(cchose + p + uchose + s + uwins);
        else if (cc==2&&uc==0) System.out.println(cchose + s + uchose + r + uwins);
        //computer wins
        else if (cc==2&&uc==1) System.out.println(cchose + s + uchose + p + cwins);       
        else if (cc==0&&uc==2) System.out.println(cchose + r + uchose + s + cwins);
        else if (cc==1&&uc==0) System.out.println(cchose + p + uchose + r + cwins);

    }
    
}
