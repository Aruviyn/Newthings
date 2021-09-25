/* Mean Function */
import java.util.Scanner;
class Mean 
{
   public static void main(String args[]) 
    { 
	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter the amount of number you wish to input: "); 
	int n=sc.nextInt();
	double[] input=new double[n];
	System.out.println("Please Enter the numbers: ");
	double sum=0;
	for(int i=0;i<n;i++) 
	{
		input[i]=sc.nextDouble();
		sum=sum+input[i];
	}
       System.out.println("Mean :"+sum/n);  
   }
}
