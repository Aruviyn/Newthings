/* Mode Function */
import java.util.Scanner;
class mode
{
  public static void main(String args[]) 
  { 
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the amount of numbers to input: "); 
    int n=sc.nextInt(),c;
    int [] a=new int[n];
    int [] b=new int[n];
    System.out.println("Enter "+n+" Numbers");
    double sum=0;
    for(int i=0;i<n;i++) 
    {
      a[i]=sc.nextInt();
    }
    modeCal(n,a,b);
  }
  static void modeCal(int n,int a[],int b[])
  {
    int m=0,c;	
    for(int i=0;i<n;i++) 
    {
      c=1;
      if(a[i]==-1)
        b[i]=0;
      else
      {
        for(int j=i+1;j<n;j++) 
        {
          if(a[i]==a[j])
          {
            c++;
            a[j]=-1;
          }
        }
        b[i]=c;
      }           
      if(i>=1)
      {
        if(i==1)
          m=b[0];
        if(b[i]>=m)
          m=b[i];   		 
      }		
    }     
    System.out.println("mode:"); 
    for(int i=0;i<n;i++) 
    {
      if(b[i]==m)
        System.out.println(a[i]);   
    }     	        
  }
}
