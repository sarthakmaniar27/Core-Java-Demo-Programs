import java.net.*;
class URLDemo
{
	public static void main(String[] args) 
	{
		try{
			URL url = new URL("https://www.geeksforgeeks.org/data-structures/linked-list/");
			System.out.println("Protocol: "+url.getProtocol());  
			System.out.println("Host Name: "+url.getHost());  
			System.out.println("Port Number: "+url.getPort());  
			System.out.println("File Name: "+url.getFile());
			System.out.println("Default Port Number: "+url.getDefaultPort());
			System.out.println("Query String: "+url.getQuery());    
			System.out.println("Path: "+url.getPath());          	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
}