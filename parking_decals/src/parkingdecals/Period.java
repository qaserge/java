/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingdecals;

import java.util.Scanner;

/**
 *
 * @author Sergei
 */
public class Period {
    
    private int month; 
    private int day;
    private int year; 
    private String nDayinYear = "360"; // for Wrapper class
    private String nDayinMonth = "30"; // for Wrapper class
    

    public void readInputStart()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter start day, month and year.");
        System.out.println(" Do not use a comma. Ex.: 25 12 2018");        
        day = keyboard.nextInt();
        month = keyboard.nextInt();
        year = keyboard.nextInt();  
    }
    public void readInputEnd()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter end day, month and year.");
        System.out.println(" Do not use a comma. Ex.: 2 2 2019");        
        day = keyboard.nextInt();
        month = keyboard.nextInt();
        year = keyboard.nextInt();        
    }

    public int getDay()
    {
        return day;
    }
    public int getYear()
    {
        return year;
    }    
    public int getMonth()
    {
        return month;
    }
    
    
    public int ParkingPeriodCalc() {
        
        Period startDate = new Period();
        startDate.readInputStart();
        
        Period endDates = new Period();
        endDates.readInputEnd();      
        
        
        while   ((startDate.year > endDates.year)||
                ((Integer.toString(startDate.year).equals(Integer.toString(endDates.year)))&&(startDate.month > endDates.month))|| /* equals  */
                ((startDate.year == endDates.year)&&(startDate.month == endDates.month)&&(startDate.day > endDates.day))||
                (startDate.month > 12)||(endDates.month > 12)||(startDate.day > 31)||(endDates.day > 31))
        {
            System.out.println("Error. Wrong date. End date must be higher than start date. Format dd mm yyyy");
            startDate.readInputStart();
            endDates.readInputEnd();
        }            

        // calculate the number days of parking                

        int numOfyears = (endDates.getYear()*Integer.parseInt(nDayinYear)) - (startDate.getYear()*Integer.parseInt(nDayinYear)); // wrapper Integer.parseInt
        int numOfmonth = (endDates.getMonth()*Integer.parseInt(nDayinMonth)) - (startDate.getMonth()*Integer.parseInt(nDayinMonth)); // wrapper Integer.parseInt             
        int numOfdays = endDates.getDay() - startDate.getDay();        
        
        // add difference for long months
        int sumDays = numOfyears + numOfmonth + numOfdays;   
        int num = sumDays / Integer.parseInt(nDayinMonth); // wrapper Integer.parseInt //Invocation
        for (int i = 0; i < (num/2); i++) numOfdays++;  
        sumDays = numOfyears + numOfmonth + numOfdays;        
        return sumDays;
    }
    
        public String toString( )
    {
        return (nDayinYear.toString( ));
    }
        


}
