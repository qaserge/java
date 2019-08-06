/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook;

import java.util.Random;

/**
 *
 * @author 1896190 (Sergei Bessonov)
 */
public class GradeBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random rnd = new Random();        
        int n = 4; //number of students
        int m = 4; // number of quizzes
        int [][] gardeBook = new int [n][m]; //2D array declaration
        double [] studentAverage = new double [n]; //student Average array declaration 
        double [] quizAverage = new double [m];//quiz Average array declaration
        int [] quizNum = new int [m]; //quiz numbers array declaration
        
        //out quiz numbers array 
        System.out.print("QuizNumber \t");
        for (int col = 0; col < m; col++)
        {
            quizNum[col] = col+1;
            System.out.print("\t" + quizNum[col]);
        }
        System.out.println();
        System.out.println
        ("-------------------------------------------------------------------------");
        
        // put random numbers in the 2D array
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < m; col++)
            {
                gardeBook[row][col] = rnd.nextInt(10)+1; //random from 1 to 10
            }
        }
        // out 2D array
        double avgCol = 0;
        for (int row = 0; row < n; row++)
        {
            System.out.print("Student # " +(row+1) +"\t");
            avgCol = 0;
            for (int col = 0; col < m; col++)
            {                
                System.out.print("\t" + gardeBook[row][col] );
                // summ all cols in the one row
                avgCol = avgCol + gardeBook[row][col];
            }
            //calculation of Average by cols & put this value to the studentAverage array
            studentAverage[row] = avgCol/m;
            // out student Average
            System.out.println("\t Average is " + studentAverage[row]);
        }
        
        System.out.println
        ("-------------------------------------------------------------------------");
        
        //calculation of Average by rows 
        System.out.print("Averages \t");        
        double avgRow = 0;
        for (int col = 0; col < m; col++)
        {
            avgRow = 0;
            for (int row = 0; row < n; row++)
            {   // summ all rows in the one col
                avgRow = avgRow + gardeBook[row][col];
            }
            //calculation of Average by rows & put this value to the quizAverage array
            quizAverage[col] = avgRow/n;            
            System.out.print ("\t" +quizAverage[col]);                        
        }        
        System.out.println();
    }    
}
