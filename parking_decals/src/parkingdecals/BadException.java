/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingdecals;

/**
 *
 * @author Sergei
 */
public class BadException extends Exception{
    
        private int badNumber;

    public BadException(int number)
    {
        super("BadException"); // Overriding
        badNumber = number; 
    }

    public BadException()
    {
        super("BadException"); 
    }

    public BadException(String message) //overloading 
    {
        super(message); 
    }

    public int getBadNumber()
    {
        return badNumber;
    }
    
}
