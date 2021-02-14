import java.util.*;

class StringTokenizerDemo
{
	public static void main(String[] args) 
	{
		StringTokenizer st = new StringTokenizer("Sardar Patel Institute of Technology");
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	}
}