/* Median Function */
import java.util.Scanner;
class Median 
{
  public static void main(String args[]) 
  { 
    Scanner sc=new Scanner(System.in);
    System.out.println("enter a number"); 
    int n=sc.nextInt();
    double[] input=new double[n];
    System.out.println("enter "+n+" elements");
    double m=0;
    for(int i=0;i<n;i++) 
    {
      input[i]=sc.nextDouble();
    }
    if(n%2==1)
    {
      m=input[(n+1)/2-1];
    }
    else
    {
      m=(input[n/2-1]+input[n/2])/2;
    }
    System.out.println("Median :"+m);  
  }
}
