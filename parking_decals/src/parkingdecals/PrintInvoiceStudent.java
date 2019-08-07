/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingdecals;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Sergei
 */
public class PrintInvoiceStudent implements InterfaceDecals{
    
    private static String in = 
       
        "Decal type=Pay/Month;" + 
        "Decal's validity period=above;" + 	 
        "Reservation number=798465132;" +
 	"Main vehicle=2009 Dodge Caliber (Red), plate X007XX";    
     
    public static void getPrint() 
    {   
        System.out.println("Below is the unconfigured invoice template, with a working StringTokenizer:");
        StringTokenizer st = new StringTokenizer(getIn(), "=;");
  	while(st.hasMoreTokens()) {
	    String key = st.nextToken();
	    String val = st.nextToken();
 	    System.out.println(key + " : " + val);
        }
    }

    /**
     * @return the in
     */
    public static String getIn() {
        return in;
    }

    /**
     * @param aIn the in to set
     */
    public static void setIn(String aIn) {
        in = aIn;
    }
    
    /**
     *
     */
    public void showInfo(){
        getPrint();
    }
        public void sortNumbersInArray() {
        
        int decalNumber [] = {5, 8, 2, 7, 1, 4};
        System.out.print("Original Decal number of main vehicle: ");
        for (int i=0; i<decalNumber.length; i++)
            System.out.print (decalNumber[i]);
        System.out.println();        
        Arrays.sort( decalNumber );
        System.out.print("But for Final project it's Sorted: ");
        for (int i=0; i<decalNumber.length; i++)
            System.out.print (decalNumber[i]);  
        System.out.println();
    }
}
