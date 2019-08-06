/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howhighcanyougomplayers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 1896190
 */
public class HowHighCanYouGomplayers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);  
        System.out.println("Enter number of players");
        int numofplayers = sc.nextInt();
          
        System.out.println("Number of players is " +numofplayers);
        int count;
        //counter for numbers of players
        for (count = 1; count<=numofplayers; count++)
        {
         
        System.out.println("Player # " +count);   
        System.out.println("What is your name?");
        sc.nextLine();
        String name;
        name=sc.nextLine();
        
        
        int sum = 0;     
        int highScore = 0;                
        
        //Random roll
        Random rnd = new Random();
        int roll = rnd.nextInt(6)+1;
        
        //Scanner char input
        System.out.println(name +", do you want to play? If yes type \"y\". For exit enter any character");        
        char play = sc.next().charAt(0);
        System.out.println("---------------------------------------------");
        
        //verification for start the game (while)
        while (play=='y')
        {   
        //Random from 1 to 6    
            roll = rnd.nextInt(6)+1;
            System.out.println("The dice has rolled with value of " +roll);
        System.out.println("---------------------------------------------");
        
        //calc the sum
            sum = sum + roll;
        //verification for 1 condition
            if (roll==1){
                sum=0;
                System.out.println("You lost all your points. ");
        System.out.println("---------------------------------------------");

            }
        //condition for HighScore
            if (highScore<sum){
            highScore = sum;
            }
            System.out.println("Now Sum of your points is " +sum);
        System.out.println("---------------------------------------------");

            System.out.println("High Score of the game is " +highScore);
        System.out.println("---------------------------------------------");
            
            System.out.println("Do you want to play further? If yes type \"y\". For exit enter any character");
            play = sc.next().charAt(0); 
        System.out.println("---------------------------------------------");
        //end while (game)
        }
        System.out.println("Game over for " +name);   
        System.out.println("---------------------------------------------");
        
        //end for (players)
       }
        
    }
    
}
