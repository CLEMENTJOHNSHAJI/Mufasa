
public class AddressList {
	private String street;
	private String city;
	private String postalCode;
	private String country;
	public boolean setStreetName(String street)
	{
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz1234567890 ";
		boolean sampleValue = allowedCharacters(allowedCharacters,street);
		if(false==sampleValue)
			return(false);
		this.street=street;
		return true;
	};
	public String getStreetName()
	{

		return this.street;
	};
	public boolean setCityName(String city)
	{
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz ";
		boolean sampleValue = allowedCharacters(allowedCharacters,city);
		if(false==sampleValue)
			return(false);
		this.city=city;
		return true;
	};
	public String getCityName()
	{

		return this.city;
	}
	public boolean setPostalCode(String postalCode)
	{
		String allowedCharactors = "0123456789-";
		boolean sampleValue = allowedCharacters(allowedCharactors,postalCode);
		if(false==sampleValue)
			return(false);
		this.postalCode=postalCode;
		return true;
	}
	public String getPostalCode()
	{
		return this.postalCode;
	}
	public boolean setCountry(String country)
	{	
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz ";
		boolean sampleValue = allowedCharacters(allowedCharacters,country);
		if(false==sampleValue)
			return(false);
		this.country=country;
		return true;
	}
	public String getCountry()
	{
		return this.country;
		
	}
	
	private boolean allowedCharacters(String allowed, String testSample)
	{
		testSample = testSample.toLowerCase();
		for (int i = 0; i < testSample.length(); i++)
		{
			String test = testSample.substring(i,i+1);
			if(!allowed.contains(test))
			{
				return false;
			}
		}
		return(true);	
	}
}
