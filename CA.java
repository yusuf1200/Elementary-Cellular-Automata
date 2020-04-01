public class CA
{
    // instance variables - replace the example below with your own
    private static int n;
    private static int rule;
    public static int[] ruleset;

    /**
     * Constructor for objects of class CA
     */
public static void main(String[] args) { 
       n = Integer.parseInt(args[0]);
       rule = Integer.parseInt(args[1]);
     
      int CellNum = 2 * n;

      int[] cells = new int[CellNum];      // cellular automaton at time t
      int[] old   = new int[CellNum];      // cellular automaton at time t-1
      cells[CellNum/2] = 1;
  
      for (int t = 1; t < n; t++) {

         
         for (int i = 0; i < CellNum; i++) {
            if(cells[i]==1) System.out.print("*");
            else         System.out.print(" ");
         }
         System.out.println("");

         
         for (int i = 0; i < CellNum; i++)
            old[i] = cells[i];

         // update cells according to rules
         int[] newgen = new int[cells.length];
         for (int i = 1; i < cells.length-1; i++) {
         int left   = cells[i-1];
         int me     = cells[i];
         int right  = cells[i+1];
         newgen[i] = rules(left, me, right);
    }
         cells = newgen;
      }
   }


    public static int[] decimalTBina(int rule)
    {
       int[] a = new int[8];
       int i = 0;
       while (rule > 0) {
           int divisor = (int) Math.floor(rule/ 2);
           int remainder = rule % 2;
           a[i] = (int) remainder;
           rule = divisor;
           i++;
       }

       int[] ruleset = new int[8];
       for (int j = 0; j < 8; j++) 
       {
                ruleset[j] = a[7-j];
            }
         
       return ruleset;
    }
    
    private static int rules (int a, int b, int c) {
    int ruleset[]=decimalTBina(rule);
   if(a == 1 && b == 1 && c == 1)
    { return ruleset[0];}
    else if (a == 1 && b == 1 && c == 0) { return ruleset[1];}
    else if (a == 1 && b == 0 && c == 1) { return ruleset[2];}
    else if (a == 1 && b == 0 && c == 0) { return ruleset[3];}
    else if (a == 0 && b == 1 && c == 1) { return ruleset[4];}
    else if (a == 0 && b == 1 && c == 0) { return ruleset[5];}
    else if (a == 0 && b == 0 && c == 1) { return ruleset[6];}
    else if (a == 0 && b == 0 && c == 0) { return ruleset[7];}
    

    return 0;
} 
}

