import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sergei
 */
public class MathTest {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        
        int num1=0, num2=0, math;
        int addition = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        int answer = 0;
        int id=0;
        int numOfquestions = 10;
        
                   
        
        System.out.println("What skill you want to practice? (A=Addition, S=Subtraction, M=Multiplication)");        
        char skill = sc.next().charAt(0);
        //A=Addition, S=Subtraction, M=Multiplication
        while (skill!='A'&&skill!='S'&&skill!='M')
        {
            System.out.println("Wrong character of skill.");
            System.out.println("What skill you want to practice? (A=Addition, S=Subtraction, M=Multiplication)");
            skill = sc.next().charAt(0);
        }
        if (skill == 'A')
        {
            System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");        
            char level = sc.next().charAt(0);
            //A=Addition, S=Subtraction, M=Multiplication
            while (level!='E'&&level!='M'&&level!='D')
            {
                System.out.println("Wrong character of level.");
                System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");
                level = sc.next().charAt(0);
            }
                if (level=='E')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
	                    }
                    System.out.println(num1 + " + " + num2 + " = ");
                    }
                    
                    addition = num1 + num2;                
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == addition)
                { 
                    System.out.println("Correct! " +num1+ " + " + num2 + " = " + addition);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " + " + num2 + " = " + addition);
                }
                else if (level=='M')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
	                    }
                    System.out.println(num1 + " + " + num2 + " = ");
                    }
                    
                    addition = num1 + num2;                
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == addition)
                { 
                    System.out.println("Correct! " +num1+ " + " + num2 + " = " + addition);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " + " + num2 + " = " + addition);
                }
                else if (level=='D')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
	                    }
                    System.out.println(num1 + " + " + num2 + " = ");
                    }
                    
                    addition = num1 + num2;                
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == addition)
                { 
                    System.out.println("Correct! " +num1+ " + " + num2 + " = " + addition);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " + " + num2 + " = " + addition);
                }

                
                
        }
        else if (skill == 'S')
        {
            System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");        
            char level = sc.next().charAt(0);
            //A=Addition, S=Subtraction, M=Multiplication
            while (level!='E'&&level!='M'&&level!='D')
            {
                System.out.println("Wrong character of level.");
                System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");
                level = sc.next().charAt(0);
            }
                if (level=='E')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
	                    }
                    if (num1 > num2)
                    System.out.println(num1 + " - " + num2 + " = ");
                    else
                        System.out.println(num2 + " - " + num1 + " = ");
                    }
                    if (num1 > num2)
                    subtraction = num1 - num2;
                else subtraction = num2 - num1;
                                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == subtraction)
                { 
                    if (num1 > num2)
                    {
                    System.out.println("Correct! " +num1+ " - " + num2 + " = " + subtraction);
                    id++;
                    }
                    else 
                    {
                    System.out.println("Correct! " +num2+ " - " + num1 + " = " + subtraction);
                    id++;
                    }
                }
                else
                    System.out.println("Wrong! " +num1+ " - " + num2 + " = " + subtraction);
                }
                else if (level=='M')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
	                    }
                    System.out.println(num1 + " - " + num2 + " = ");
                    }
                    if (num1 > num2)
                    subtraction = num1 - num2;
                else subtraction = num2 - num1;
                                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == subtraction)
                { 
                    if (num1 > num2)
                    {
                    System.out.println("Correct! " +num1+ " - " + num2 + " = " + subtraction);
                    id++;
                    }
                    else 
                    {
                    System.out.println("Correct! " +num2+ " - " + num1 + " = " + subtraction);
                    id++;
                    }
                }
                else
                    System.out.println("Wrong! " +num1+ " - " + num2 + " = " + subtraction);
                }    
                else if (level=='D')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
	                    }
                    System.out.println(num1 + " - " + num2 + " = ");
                    }
                    if (num1 > num2)
                    subtraction = num1 - num2;
                else subtraction = num2 - num1;
                                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == subtraction)
                { 
                    if (num1 > num2)
                    {
                    System.out.println("Correct! " +num1+ " - " + num2 + " = " + subtraction);
                    id++;
                    }
                    else 
                    {
                    System.out.println("Correct! " +num2+ " - " + num1 + " = " + subtraction);
                    id++;
                    }
                }
                else
                    System.out.println("Wrong! " +num1+ " - " + num2 + " = " + subtraction);
                }
                
        }
        else if (skill == 'M')
        {
            System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");        
            char level = sc.next().charAt(0);
            //A=Addition, S=Subtraction, M=Multiplication
            while (level!='E'&&level!='M'&&level!='D')
            {
                System.out.println("Wrong character of level.");
                System.out.println("What the level of difficulty you want to get? (E=Easy, M=Medium, D=Difficult)");
                level = sc.next().charAt(0);
            }
                if (level=='E')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(10)+1;
	                    num2 = rnd.nextInt(10)+1;
	                    }
                    System.out.println(num1 + " * " + num2 + " = ");
                    }
                    multiplication = num1 * num2;
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == multiplication)
                { 
                    System.out.println("Correct! " +num1+ " * " + num2 + " = " + multiplication);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " * " + num2 + " = " + multiplication);
                }
                else if (level=='M')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(50)+1;
	                    num2 = rnd.nextInt(50)+1;
	                    }
                    System.out.println(num1 + " * " + num2 + " = ");
                    }
                    multiplication = num1 * num2;
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == multiplication)
                { 
                    System.out.println("Correct! " +num1+ " * " + num2 + " = " + multiplication);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " * " + num2 + " = " + multiplication);
                }
                else if (level=='D')
                for (int count=0; count<numOfquestions; count++)
                {
                    {
                    	num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
                    	while(num1>num2) 
                    	{
	                    num1 = rnd.nextInt(100)+10;
	                    num2 = rnd.nextInt(100)+10;
	                    }
                    System.out.println(num1 + " * " + num2 + " = ");
                    }
                    multiplication = num1 * num2;
                
                System.out.println("What is the answer?");
                answer = sc.nextInt();
                if (answer == multiplication)
                { 
                    System.out.println("Correct! " +num1+ " * " + num2 + " = " + multiplication);
                    id++;
                }
                else
                    System.out.println("Wrong! " +num1+ " * " + num2 + " = " + multiplication);
                }            
                              
        
        }
        System.out.println("You got " + id + " out of " + numOfquestions + " correct");
        
    }
    
}
