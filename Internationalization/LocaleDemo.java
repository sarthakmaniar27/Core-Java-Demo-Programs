import java.util.*;

class LocaleDemo
{
	public static void main(String[] args) 
	{
		Locale l1 = Locale.getDefault(); //defualt locale will get configured in our system
		//System.out.println("Country = "+l1.getCountry()+" and Language = "+l1.getLanguage());
		//System.out.println("Country = "+l1.getDisplayCountry()+" and Language = "+l1.getDisplayLanguage());
		Locale l2 = new Locale("pa","IN");
		Locale.setDefault(l2); //Now this l2 Locale gets configured in our system
		//System.out.println(Locale.getDefault().getDisplayLanguage());
		//System.out.println("Country = "+l1.getDisplayCountry()+" and Language = "+l1.getDisplayLanguage());
		String[] s3 = Locale.getISOLanguages();
		for(String s4: s3)
		{
			System.out.print(s4+" ");
		} 
		System.out.println("\n");
		String[] s4 = Locale.getISOLanguages();
		for(String s5: s4)
		{
			System.out.print(s5+" ");
		} 
		System.out.println();
		Locale[] s = Locale.getAvailableLocales();
		for(Locale s1: s)
		{
			System.out.print(s1.getDisplayCountry()+" -- "+s1.getDisplayLanguage());
		} 
	}
}
