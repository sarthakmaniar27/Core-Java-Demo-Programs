import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.lang.*;

 class Download implements Runnable
{
	String link;  
	File out;

	//contructor
	 Download(String link,File out)
	{
		this.link = link;
		this.out = out;
	}

	public void run()
	{
		try
		{
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			/*
				The openConnection() method of URL class opens the connection to specified URL and 
				URLConnection instance that represents a connection to the remote object referred by 
				the URL.
			*/
			double fileSize = (double)http.getContentLengthLong(); //this method returns the no. of bytes of the file and uses a long, so casted it into double.
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
			byte[] buffer = new byte[1024];
			double downloaded = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;

			while((read = in.read(buffer,0,1024)) >= 0)
			{
				bout.write(buffer,0,read);
				downloaded += read;
				percentDownloaded = (downloaded*100)/fileSize;
				String percent = String.format("%.4f",percentDownloaded);
				System.out.println("Downloaded "+percent+" of a file.");


			}
			bout.close();
			in.close();
			System.out.println("Download completed!");

		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
class Downloader
{
	public static void main(String[] args) 
	{
		String link = "http://www.rjspm.com/PDF/JavaTheCompleteReference.pdf";
		File out = new File("/Users/sarthakmaniar/Desktop/Java The Complete Reference.pdf");
		new Thread(new Download(link,out)).start();
	}
} 