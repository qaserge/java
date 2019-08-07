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
public class Decals extends HiDecals{

    /**
     * @param args the command line arguments
     */
    Decals get(){        
        System.out.println("Welcome to the Omnivox Parking Decal Reservation Module."); //Covariant return type
        System.out.println();
        return this;
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        HiDecals covariant = new HiDecals();
        covariant.get();        
        Decals derived = new Decals(); 
        derived.get();         
    
        Invoice check = new Invoice();
        check.readInputInvoice();      
        System.out.println("There are " +check.getTotalDays() + " days in the selected date range.");        
        System.out.println("Total amount due: " + check.getAmount() + ".99 CAD");
        System.out.println();
        
        //PrintInvoiceStudent.getPrint(); //static 
        
        PrintInvoiceStudent info = new PrintInvoiceStudent();                 
        info.showInfo(); // interface method
        info.sortNumbersInArray();
    }    
}
