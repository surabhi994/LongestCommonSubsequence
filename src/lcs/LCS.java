
package lcs;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LCS {

    static String input, output;
    String arrayA[]= new String[1000]; //creating array to store string A
    String arrayB[]=new String[1000]; //creating array to store string B
    public static void main(String[] args)throws IOException
    {
        input="input.txt"; output="output.txt";
       FileReader f= new FileReader(input);
        Scanner sc= new Scanner(f);
        PrintWriter out= new PrintWriter(output);
       
      int arr[][];String pos[][];
            String l=sc.nextLine();//stores the first line of input file in string l
          String  arrayA[]=l.split(""); //stores the characters of the string A in an arrayA
                  
            l=sc.nextLine();//stores the next line of the input file in string l
            String arrayB[]=l.split("");// stores the characters of the string B in an arrayB
            
            int n=arrayA.length; // n stores length of string A
            int m=arrayB.length;// n stores the length of string B
            
            
                 arr= new int[n+1][m+1]; 
                 pos=new String[n+1][m+1];
            
                
            
            for(int j=0; j<=m; j++)
            {
                arr[0][j]=0; //the first row contains all 0
                
            }
            for(int i=1;i<=n;i++)
            {
                arr[i][0]=0; // the first column contains all 0
            }
            
            for(int i=1;i<=n;i++)
            {
                 
            for(int j=1;j<=m;j++)
            {
                if(arrayA[i-1].equals(arrayB[j-1])) //if an element of A is in B
                {
                    arr[i][j]=arr[i-1][j-1]+1; pos[i][j]="diagonal";
                }
                else if(arr[i][j-1]>=arr[i-1][j])
                {
                    arr[i][j]=arr[i][j-1]; pos[i][j]="left";
                }
                else
                {
                    arr[i][j]=arr[i-1][j];pos[i][j]="up";
                    
                }
                
            }
            }
           
            
        int i=n; int j=m; String s="";
        while(i>0 && j>0)
        {
            if (pos[i][j]=="diagonal") //if the pos[] contains diagonal the two array have a same element
            {
                s=arrayA[i-1]+s;// store the common element in string s
                i=i-1; //decrement i by 1
                j=j-1;// decrement j by 1
            }
            else if(pos[i][j]=="up")
            {
                i=i-1;
            }
            else
            {
                j=j-1;
            }
        }
         
          out.println(s.length()); //outputs the length of LCS to output file
          out.println(s); // outputs the longest common subsequence
            out.close(); 
        }
        
    }
    

