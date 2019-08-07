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
public class Invoice {  
        
    //private String owner; 
    private int owner;
    private int periodDays;
    private static final double STUDENTPRICE = 0.8; 
    private static final double EMPLOYEPRICE = 1;
    

    public void readInputInvoice()
    {
        boolean done = false;
        while (! done)
        try
        {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Are you a student (1) or an employe (2)?");
        owner = keyboard.nextInt();        

            if ((owner != 1) && (owner != 2))
            throw new BadException(owner); // invocation
            if (owner == 1)
                
                System.out.println("You entering " + owner + ". Payment processing will be held for the student.");
            else if (owner == 2)
                System.out.println("You entering " + owner + ". Payment processing will be held for the employe.");
            done = true;
        }
        catch(BadException e)
        {
            System.out.println(e.getBadNumber() + " wrong number. It's possible to enter only 1 or 2. Try again.");
        }
    }
          
        public int getTotal()
    {
        Period totalD = new Period();
        periodDays = totalD.ParkingPeriodCalc();
        return periodDays;
    }
        public int getTotalDays() // overwrighting periodDays
    {
        periodDays = getTotal();
        return periodDays;
    }
        
        public int getAmount()
    {
        if (owner == 1)
        {            
            double invoiceS = (STUDENTPRICE * periodDays);        // Local variable invoiceS                
            return (int) invoiceS;
        }
        else if (owner == 2)
        {            
            double invoiceE = (EMPLOYEPRICE * periodDays);          // Local variable invoiceE              
            return (int) invoiceE;            
        }        
        else
        {
            System.out.println("Error");
            System.exit(0);
            return 0; 
        }
    }

   
}
