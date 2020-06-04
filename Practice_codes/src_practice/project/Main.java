/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vivek
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String patternString = ".*MUJ.*";
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
        Pattern pat = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE) ;
        String s = sc.next();
        Matcher m = pat.matcher(s) ;
        
        boolean a = m.matches() ;
        if(a==true)
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }
   }
    
}
