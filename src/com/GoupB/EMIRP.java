import java.util.Scanner;  

public class EMIRP {
	 public static void main (String[] args)  
     {  
		 //the program will find the emirp up to 100
          int[] p = new int[100];  
          int count =0;  
                   for (int i =2;count<100;i++)  
             {  
               if (isEmirp(i))  
               {  
                    p[count] = i;  
                    count++;  
               }   
          }
          for(int i =0;i<100;i++)  
          {  
               if ((i+1) % 10 == 0) 
                    System.out.println(p[i]);  
               else 
                    System.out.print(p[i] + "\t");  
          }
     }//end main    
	 public static int reverse (int num)  
      {  
          String s0 = Integer.toString(num);  
          String s1 = "";  
          {  
               for(int i =s0.length()-1;i>=0;i--)  
               {  
                    s1+= s0.charAt(i);  
               }  
          }  
          return Integer.parseInt(s1);  
     }// end reverse
     public static int reverse1(int num)  
     {  
          String str = Integer.toString(num);
          String s1 = "";  
          
        
          for(int i =str.length()-1;i>=0;i--)  
          {  
              s1+= str.charAt(i);  
          }  
          
          return Integer.parseInt(s1);  
	}  //end reverse1
     public static boolean PalPrime(int num)  
	{  
    	 //The functions will choose whether the primes 
    	 //meet the requirements of the function
          String s2 = Integer.toString(num);  
          if (isPrime(num))  
          {  
            
               if(s2.equalsIgnoreCase(""+reverse1(num)))
                   return true;
          }  
          else
               return false;
		return false;  
     }// end PalPrime
     public static boolean isEmirp(int num)  
     {  
          String s2 = Integer.toString(num);
 
          if (isPrime(num) && isPrime(reverse(num)) && (PalPrime(num) == false))  
               return true;  
          else  
               return false;  
     }  //end isEmirp
     public static boolean isPrime(int num)  
	 {  
          
          for(int i =2;i<=Math.sqrt(num);i++)   
          {  
               if(num%i==0)   
               {  
                    return false;  
               }  
          }  
          return true;  
     }  //end isPrime
}//end class
