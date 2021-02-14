import java.util.*;
class Test1
{
  public static int myMethod(int[][] arr,int n)
  {

   int i=0;
   int j=0;
   int score=0;
   while(i!=n-1 && j!=n-1)
   {
    if(arr[i+1][j] < arr[i][j+1])
    {
      score = (score/2) + arr[i+1][j];
      i = i+1;
    }
    else
    {
      score = (score/2) + arr[i][j+1];
      j = j+1;

    }
   }
   score = (score/2) + arr[n-1][n-1];
   return score;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
          arr[i][j] = sc.nextInt(); 
      }
    }
    int score = Test1.myMethod(arr,n);
   System.out.println(score);
  }
}