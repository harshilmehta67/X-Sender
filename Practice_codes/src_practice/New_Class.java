
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harshil Mehta
 * Section 2
 * AU1841010
 */
public class New_Class {
    static int Balance = 5000 ;

public static boolean Deposit(int amount)
{
    boolean val = true ;
    Balance += amount ; 
    return val ;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter amount to deposit");
        int amt = sc.nextInt() ;
        boolean b = Deposit(amt);
        if(b==true)
        {
            System.out.println("Balance changed to "+Balance);
        }
        
    }
    static int withdraw(int amount) 
    {
        Balance -= amount ;
        return amount ;
    }
}
