package yahtzee;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sergei
 */
public class Yahtzee {
    // assign var winner for using in the all methods
private static int winner;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        

        // Declarations
        final int NUM_OF_DICE = 5;
        final int SIDES_OF_DICE = 6;
        final int NUM_OF_ROUNDS = 13;               
        
        // for testing 
        // comment and uncomment 34-35 and 147-149 rows of code
        int[] diceRoll = new int[NUM_OF_DICE];      // array to score dice roll
        //int diceRoll[] = {2, 3, 3, 3, 2};
       
        int [] numfound = new int [6];              // array for formulas
        int playerNums;                             // number of players 
        char rollAgain = 'N';                       // user wants to roll again
        int reRollAvailable = 2;                    // how many rerolls available
        int diceToReRoll = 0;                       // how nany dice to rereoll
        int score = 0;                              // used to add up score for this round
        int num = 0;                                // num of elements in numfound Array
        int count = 0;
        boolean duplicate = false;                  // for looking duplicate
      
        Random rnd = new Random();
        Scanner kb = new Scanner(System.in);

        // Display game title and instructions
        println("--~~~=:>[XXXXXXXXX]>");
        println("\t--YAHTZEE-- ");
        println("--~~~=:>[XXXXXXXXX]>");        
        
        // instructions on how to play.
        println("The object of the game is to score the most points possible by rolling five dice. \n" +
            "The dice can be rolled up to three times in a turn. \n" +
            "There are thirteen possible scoring combinations. \n" +
            "A complete game consists of thirteen rounds. \n" +
            "During each round the player decides which scoring combination is best suited for that round. \n" +
            "Once a player uses a scoring combination during a game it cannot be used again by that player.");
        println("---------------------------------------------------------------------------------------------");
        println("Scoring Combinations");
        println("Each score category is the sum of the total number of dice matching the number.\n" +
            "- Ones: Get as many ones as possible.\n" +
            "- Twos: Get as many twos as possible.\n" +
            "- Threes: Get as many threes as possible.\n" +
            "- Fours: Get as many fours as possible.\n" +
            "- Fives: Get as many fives as possible.\n" +
            "- Sixes: Get as many sixes as possible.");
        println("- Three of a kind: Get three dice with the same number. Points are the sum all dice (not just the three of a kind).\n" +
            "- Four of a kind: Get four dice with the same number. Points are the sum all dice (not just the four of a kind).\n" +
            "- Full house: Get three of a kind and a pair, e.g. 1,1,3,3,3 or 3,3,3,6,6. Scores 25 points.\n" +
            "- Small straight: Get four sequential dice, 1,2,3,4 or 2,3,4,5 or 3,4,5,6. Scores 30 points.\n" +
            "- Large straight: Get five sequential dice, 1,2,3,4,5 or 2,3,4,5,6. Scores 40 points.\n" +
            "- YAHTZEE: Five of a kind. Scores 50 points. You can optionally get multiple Yahtzees, see below for details.\n" +
            "- Chance: You can put anything into chance, it's basically like a garbage can when you don't have anything else you can use the dice for. The score is simply the sum of the dice.");
        println("---------------------------------------------------------------------------------------------");
        println("Each player's total score is calculated at the end of the game by summing all thirteen score boxes.");
        println("---------------------------------------------------------------------------------------------");
        println("good luck!");
        println("---------------------------------------------------------------------------------------------");
        
        //How many players will participate in the game?
        System.out.print("How many players will be? ");        
        playerNums = kb.nextInt(); 
        //check for input from 1 to 5 players
        while (playerNums<1||playerNums>5)
        {
            println("Min number of players is 1, Max number of playaer is 5");
            playerNums = kb.nextInt();
        }
        // players array declaration
        String [] players = new String [playerNums];
        kb.nextLine();
        //Ask user to enter names of players and put them into array
        for (count=0; count<=playerNums-1; count++)            
        {
            println("Enter name for player #" + (count+1));
            players[count]=kb.nextLine();
        }
        
        // scoreFinalBoard array declaration
        int[][] scoreFinalBoard = new int [NUM_OF_ROUNDS][playerNums];
        //        assign the array values of all elements -1
        //        it is necessary to check whether the category has participated in the game or not
        for (int arrrow=0; arrrow<NUM_OF_ROUNDS; arrrow++ )
        {
            for (int arrcol=0; arrcol<playerNums; arrcol++)
            {
                scoreFinalBoard[arrrow][arrcol] = -1;
            }
        }
        
        // This loop handles the number of rounds required
        for (int rcount=1; rcount <=NUM_OF_ROUNDS; rcount++ )
        {            
            // start FOR multiplayaers
            for (int pcount=0; pcount<=playerNums-1; pcount++) 
            {
                println(""); println("");
                println("********************************************************************");
                println(players[pcount] + " is playing now");            
                println("********************************************************************");
                println("");

            // Display empty scoreboard wth player's name 
            //displayScoreboard(scoreBoard, count);
            displayFinalScoreboard(scoreFinalBoard, NUM_OF_ROUNDS, playerNums, players, score);

            println("");
        
            // Display round number
            println ("--------------------------");
            println ("\tROUND " + rcount);
            println ("--------------------------");
            
            // Roll five dice and store values in array
            for (int dice=0; dice< NUM_OF_DICE; dice++)
            {
                diceRoll[dice] = rnd.nextInt(SIDES_OF_DICE) + 1;
            }
            
            // Display the roll of the dice
            println("YOU ROLLLED:");
            for (int dice=0; dice < NUM_OF_DICE; dice++)
            {
                println("\t\tDice no. #" + (dice+1) + ": " + diceRoll[dice]);
            }
            
            // Handle two rerolls of the dice selected (if required)
            reRollAvailable = 2;
            do  
            {
                // Tell user how many rerolls are available to them
                println("\nYou have " + reRollAvailable + " re-roll(s) left.");
                // Ask user if they want to reroll any dice
                System.out.print("Do you want to reroll any dice? (Y/N)? ");
                rollAgain = kb.nextLine().charAt(0);
                // verification for Wrong character                    
                while (rollAgain!='y'&& rollAgain!='Y'&& rollAgain!='n' && rollAgain!='N' && rollAgain!=' ')
                    {                        
                        println("Wrong character");
                        System.out.print("Do you want to reroll any dice? (Y/N)? ");
                        rollAgain = kb.nextLine().charAt(0);
                    }
                if (rollAgain == 'y') rollAgain = 'Y';
                if (rollAgain == 'Y' || rollAgain == 'y')
                {
                    // Ask user which dice to reroll
                    System.out.print("How many dice do you want to reroll? ");
                    diceToReRoll = kb.nextInt();
                    // Loop through the number dice to be rerolled
                    for (int dice=1; dice<=diceToReRoll; dice++)
                    {
                        // Ask user for dice number to reroll, reroll and store it
                        System.out.print("Enter dice number to reroll (e.g. 1): ");
                        int diceNumb = kb.nextInt();
                        // Reroll dice number as requested
                        diceRoll[diceNumb-1] = rnd.nextInt(SIDES_OF_DICE) + 1;   
                    }

                    // Display the roll of the dice
                    println("YOUR DICE ARE NOW:");
                    for (int dice=0; dice < NUM_OF_DICE; dice++)
                    {
                        println("\t\tDice no. #" + (dice+1) + ": " + diceRoll[dice]);
                    } 
                    // Decrement number of rolls avaible
                    reRollAvailable --;
                    // Remove crlf from input buffer  
                    kb.nextLine();
                }
                
            } while (reRollAvailable > 0 && rollAgain=='Y');
            
            // Display scoreboard
            // TO DO: If no score allocated to box, do not display 0
             displayFinalScoreboard(scoreFinalBoard, NUM_OF_ROUNDS, playerNums, players, score);
            
            // Ask user which box they want to allocate their score.
            System.out.print("Which box would you like to allocate your score? (e.g. 1 for Ones) "); 
            int boxToScore = kb.nextInt();            
            //check for input from 1 to 13
            while (boxToScore<1||boxToScore>13)
            {
                println("Wrong number. Enter from 1 to 13");
                boxToScore = kb.nextInt();                
            }
            kb.nextLine();
            
            switch(boxToScore)
            {
                case 1:
                    // Count and add only ones
                    // e.g. [6,2,1,1,1] score will be 3 
                    // e.g. [6,2,3,3,4] score will be 0
                    //break;
                case 2:
                    // Count and add only twos
                    // e.g. [1,2,2,1,1] score will be 4
                    // e.g. [6,5,1,1,4] score will be 0
                    //break;
                case 3:
                    // Count and add only threes
                    // e.g. [4,2,2,1,1] score will be 0 
                    // e.g. [3,2,3,3,3] score will be 9
                    //break;
                case 4:
                    // Count and add only fours
                    // e.g. [4,2,2,1,1] score will be 4 
                    // e.g. [3,2,3,3,3] score will be 0
                    //break;
                case 5:
                    // Count and add only fives
                    // e.g. [4,2,2,1,1] score will be 0 
                    // e.g. [5,5,5,5,3] score will be 20
                    //break;
                case 6:
                    // Count and add only sixes
                    // e.g. [4,2,5,3,3] score will be 0 
                    // e.g. [6,6,3,3,6] score will be 19
                                        
                    //reset values
                    score = 0;
                    duplicate = false; 
                    /*  THIS CODE CAN BE USED TO CALCULTE SCORE
                        FOR BOXES 1-6 INSTEAD OF YOUR OWN CALCUALTION IF YOU WISH*/
                    int numFound = 0;
                    score = 0;
                    for (int dice=0; dice<NUM_OF_DICE; dice++)
                    {
                        if (diceRoll[dice] == boxToScore)
                        {
                            numFound++;
                        }
                    }
                    score = numFound * boxToScore;    
                    break;
                case 7:
                    // Three of a kind (add total of all dice)
                    // e.g. [3,3,3,1,2] score will be 12
                    // e.g. [1,2,2,1,4] score will be 0   
                    
                    //reset values
                    score = 0;
                    duplicate = false;
                    num = 0;
                    for (count=0; count<6; count++)
                    {
                        numfound[count] = 0;
                    }
                    // do a check if num = diceRoll [count] then add to the numfound count of repetitions of diceRoll [count] values
                    for (count=0; count<NUM_OF_DICE; count++)
                    {
                        num = diceRoll[count];
                        numfound[num-1]++;                                
                    }
                    // go through the values of the numfound table to check if there are values in it (repetitions) greater than 3
                    for (count=0; count<6; count++)  
                    {            
                        if (numfound[count] >= 3)
                            duplicate = true;
                    }           
                    // if the number of duplicates satisfies the condition we start the calculation of the total amount
                    if (duplicate == true)
                    {
                        // sum of all elements of the array
                        for (count=0; count<NUM_OF_DICE; count++)
                        {    
                            score += diceRoll[count];
                        }
                    }
                    // if not found the required number of duplicates
                    else score = 0;
                        
                    break;
                case 8:
                    // Four of a kind (add total of all dice)
                    // e.g. [1,1,1,1,6] score will be 10
                    // e.g. [4,2,2,4,4] score will be 0
                    
                    //reset values
                    score = 0;
                    duplicate = false;
                    num = 0;
                    for (count=0; count<6; count++)
                    {
                        numfound[count] = 0;
                    }
                    // do a check if num = diceRoll [count] then add to the numfound count of repetitions of diceRoll [count] values
                    for (count=0; count<NUM_OF_DICE; count++)
                    {
                        num = diceRoll[count];
                        numfound[num-1]++;                                
                    }
                    // go through the values of the numfound table to check if there are values in it (repetitions) greater than 4
                    for (count=0; count<6; count++)  
                    {            
                        if (numfound[count] >= 4)
                            duplicate = true;
                    }           
                    // if the number of duplicates satisfies the condition we start the calculation of the total amount
                    if (duplicate == true)
                    {
                        // sum of all elements of the array
                        for (count=0; count<NUM_OF_DICE; count++)
                        {    
                            score += diceRoll[count];
                        }
                    }
                    // if not found the required number of duplicates
                    else score = 0;
                    
                    break;
                case 9:
                    // Full house (score 25)
                    // Three of one number and two of another
                    // e.g. [4,4,4,6,6] score will be 25
                    // e.g. [1,2,2,3,4] score will be 0
                    
                    //reset values
                    score = 0;
                    duplicate = false;
                    num = 0;
                    for (count=0; count<6; count++)
                    {
                        numfound[count] = 0;
                    }
                    // do a check if num = diceRoll [count] then add to the numfound count of repetitions of diceRoll [count] values
                    for (count=0; count<NUM_OF_DICE; count++)
                    {
                        num = diceRoll[count];
                        numfound[num-1]++;                                
                    }
                    // go through the values of the numfound table to check if there are values in it (repetitions) greater than 3 or 2
                    for (count=0; count<6; count++)  
                    {            
                        if (numfound[count] == 3)
                            // if there are values (repetitions) greater than 3 then we start the check for 2 
                            for (count=0; count<6; count++)
                            { if (2 == numfound[count])
                                        duplicate = true;
                            }
                    }           
                    // if the number of duplicates satisfies the condition we start the calculation of the total amount
                    if (duplicate == true)
                    {
                        // Full house (score 25)
                        score = 25;
                    }
                    // if not found the required number of duplicates
                    else score = 0;
                    
                    break;
                case 10:
                    // Small straight (sequence of 4) (score 30)
                    // e.g. [1,2,3,4,2] score will be 30
                    // e.g. [4,3,4,5,6] score will be 30
                    // e.g. [1,2,4,6,6] score will be 0
                    
                    //reset values
                    score = 0;
                    duplicate = false;
                    // sort the array ascending 
                    Arrays.sort(diceRoll);
                    //set the condition for comparing a sequence of numbers
                    if 	(
                            (  
                            diceRoll[0]+1==diceRoll[1]&&
                            diceRoll[1]+1==diceRoll[2]&&
                            diceRoll[2]+1==diceRoll[3]                    
                            )
                        ||
                            (   
                            diceRoll[1]+1==diceRoll[2]&&
                            diceRoll[2]+1==diceRoll[3]&&
                            diceRoll[3]+1==diceRoll[4]                    
                            )
                        )
                        duplicate = true;
                    if (duplicate == true)
                    {
                        // Small straight (sequence of 4) (score 30)
                        score = 30;
                    }
                    // if not found the required number
                    else score = 0;
                    
                    break;
                case 11:
                    // Large straight (sequence of 5) (score 40)
                    // e.g. [1,2,3,4,5] score will be 40
                    // e.g. [2,3,4,5,6] score will be 40
                    // e.g. [1,2,3,4,6] score will be 0
                    
                    //reset values
                    score = 0;
                    duplicate = false;
                    // sort the array ascending
                    Arrays.sort(diceRoll);
                    //set the condition for comparing a sequence of numbers
                    if 	(
                            (  
                            diceRoll[0]+1==diceRoll[1]&&
                            diceRoll[1]+1==diceRoll[2]&&
                            diceRoll[2]+1==diceRoll[3]&&
                            diceRoll[3]+1==diceRoll[4]
                            )
                        ||
                            (   
                            diceRoll[1]+1==diceRoll[2]&&
                            diceRoll[2]+1==diceRoll[3]&&
                            diceRoll[3]+1==diceRoll[4]&&
                            diceRoll[4]+1==diceRoll[5]
                            )
                        )
                        duplicate = true;
                    if (duplicate == true)
                    {
                        // Large straight (sequence of 5) (score 40)
                        score = 40;
                    }
                    // if not found the required number
                    else score = 0;
                    
                    break;
                case 12:
                    // Yahtzee (six dice the same) (score 50)
                    // e.g. [4,4,4,4,4] score will be 50
                    // e.g. [3,3,3,6,1] score will be 0
                    
                    //reset values
                    score = 0;
                    duplicate = false;     
                    num = 0;
                    for (count=0; count<6; count++)
                    {
                        numfound[count] = 0;
                    }
                // do a check if num = diceRoll [count] then add to the numfound count of repetitions of diceRoll [count] values
                for (count=0; count<diceRoll.length; count++)
                    {
                        num = diceRoll[count];
                        numfound[num-1]++;                                
                    }
                // go through the values of the numfound table to check if there are values in it (repetitions) 5 times
                for (count=0; count<6; count++)  
                    {            
                        if (5 ==  numfound[count]) duplicate = true;                   
                    }
                // if the number of duplicates satisfies the condition we start the calculation of the total amount
                if (duplicate == true)
                    {       
                        // Yahtzee (six dice the same) (score 50)
                            score = 50;                
                    }
                // if not found the required number
                else score = 0;
                    
                    break;
                case 13:
                    // Chance (add the total of all the dice)
                    // e.g. [1,6,6,3,4] score will be 20
                    // e.g. [5,5,1,1,6] score will be 18
                    
                    //reset values
                    score = 0;
                    duplicate = false;  
                    // sum of all elements of the array
                        for (count=0; count<diceRoll.length; count++)
                        {    
                            // Chance (add the total of all the dice)                            
                            score += diceRoll[count];
                        }
                    
                    break;
            }
            
            // Calculate score by counting number of dice matching the box

            // Allocate score to box on scoreboard chosen
            // TO DO: Check that this box hasn't been used yet
            
            //checked if the category has not yet been used (-1) then the value is assigned
            if (scoreFinalBoard[boxToScore-1][pcount] == -1)
            scoreFinalBoard[boxToScore-1][pcount] = score;
            
            
            // Display scoreboard
            // TO DO: If no score allocated to box, do not display 0
             displayFinalScoreboard(scoreFinalBoard, NUM_OF_ROUNDS, playerNums, players, score);
         
        //end FOR multiplayers
        }

        }
        //displaying the final table with the winner
        println("***************FINAL SCORE***************");
        // At the end of the game display the final scoreboard
        //displayScoreboard(scoreBoard, count);       
        displayFinalScoreboard(scoreFinalBoard, NUM_OF_ROUNDS, playerNums, players, score);
        println("*****************************************");
        //Winner out
        println("°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸");
        println("\t" + players[winner] + " won!");
        println("°º¤ø,¸¸,ø¤º°`°º¤ø,¸,ø¤°º¤ø,¸¸,ø¤º°`°º¤ø,¸");
        
    
    }

    /**
     * This method displays the scoreboard
     * @param scoreFinalBoard Integer array that holds the scoreboard
     * @param NUM_OF_ROUNDS Integer that holds the number of rounds
     * @param playerNums Integer that holds the number of players
     * @param players String array that holds player names
     * @param score Integer that holds the score
     */
    public static void displayFinalScoreboard(int[][] scoreFinalBoard, int NUM_OF_ROUNDS, int playerNums, String players[], int score)
    {   
        // int variables daclaration for 2D array 
        int row = NUM_OF_ROUNDS;        
        int col = playerNums;
        // String array of Categories declaration
        String [] Categories = {"|1| Aces\t", "|2| Twos\t", "|3| Threes\t", "|4| Fours\t", "|5| Fives\t", "|6| Sixes\t", "|7| 3 Of A Kind\t", 
            "|8| 4 Of A Kind\t", "|9| Full House\t", "|10| Small Straight", "|11| Large Straight", "|12| Yahtzee\t", "|13| Chance\t"};
                
        // array for calculation of total score
        int[] scoreTotal = new int[playerNums];        
        
        //out array of players
        System.out.print("\t\t");
        for (col=0; col<players.length; col++)
            {
                System.out.print("\t\t" + players[col]); 
            }
        System.out.print("\n");        

        //out 2D score array 
        for (row=0; row<13; row++) 
        {
            // before 2D array there is out categories array
            System.out.print(Categories[row]+"\t");
            
            for (col=0; col<players.length; col++)
            {
//                //if the values of the array = -1 change their display in the array to 0 
//                if (scoreFinalBoard[row][col] == -1)
//                System.out.print("\t" +(scoreFinalBoard[row][col]+1)+"\t"); 
//                //if not, then output as they are
//                else 
                    System.out.print("\t" +scoreFinalBoard[row][col]+"\t");
            } 
            // transfer row to the new line
            System.out.print("\n");
        }      
        
        
        // out total score
        println("");
        System.out.print("Total\t\t"); 
        // out and calculation of total score
        for (col=0; col<players.length; col++)
            {   
                scoreTotal[col]=0;
                for (row=0; row<13; row++)
                {
                    // here we do a reverse check, if the value is -1, then it should not participate in the summation
                    if (scoreFinalBoard[row][col]!= -1)
                    scoreTotal[col]+=scoreFinalBoard[row][col];
                }
                System.out.print("\t\t" + scoreTotal[col]); 
            }        
        println("");
        
        int winScore = 0;
        //determination of the winner
        for (col=0; col<players.length; col++)
        {            
            //looking for the maximum number of points
            if (scoreTotal[col]>winScore)
            {
                winScore = scoreTotal[col];
                //when the maximum points are found, ID of this column is assigned to the winner
                winner = col;            
            }
        }        
        System.out.print("\n");
    }

    /**
     * This method replases System.out.println println
     * @param s string variable for out
     */
    public static void println(String s)
    {
        System.out.println(s);
    }
    
    
}
