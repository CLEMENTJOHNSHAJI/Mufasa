import org.easymock.EasyMock;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
/*
 * Basic data collection for a person
 * 
 */
public class PersonsList {
	private String userFullName ;
	private String userName ;
	private String pw;
	private String email;
	private String phoneNo;
	private CountriesList country;

	public String getEmail()
	{
		return this.email;
	}
	public String getPhone()
	{
		return this.phoneNo;
	}
	public CountriesList getCountry()
	{
		return this.country;
	}
	public boolean setMail(String email,String email2)
	{
		if(email!= email2)
			return false;
		int count = email.length() - email.replace("@", "").length();
		if(count ==0 || count != 1)
			return false;
		this.email=email;
		return true;
	}
	public boolean setPhone(String phoneNo)
	{
		String allowedChars = "0123456789";
		if(!(allowedCharacters(allowedChars, phoneNo)))
			return false;
		this.phoneNo=phoneNo;
		return true;
	}
	public boolean BDCheck(String bdate)
	{
		String nameCopy = bdate;
		nameCopy = bdate.replace("/", "");

		String allowedChars = "0123456789 ";
		if(!(allowedCharacters(allowedChars, nameCopy)))
			return false;
		String[] parts = bdate.split("/");
		if(parts.length != 3)
			return false;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int i=0; i<3; i++)
		{
			int val = Integer.valueOf(parts[i]);
			if(i==0)
			{
				//Day
				if(!(val>0 && val<32))
					return false;
			}
			else if(i==1)
			{
				//Month
				if(!(val>0 && val<13))
					return false;
			}
			else if(i==2)
			{
				//Year
				if(!(val>(currentYear-150) && val<currentYear))		//Hardcoded value for life expectancy 150 years.
					return false;
			}
		}
		LocalDate today = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate birthday = LocalDate.parse(bdate, dateFormat);
		Period p = Period.between(birthday, today);
		if(p.getYears()<18)
			return false;
		return(true);
	}
	public boolean setCountry(String count)
	{
		//Fake implementation. the Country is not checked against a list.
		//Also a mock implementation
		CountriesList countr = EasyMock.createMock(CountriesList.class);
		EasyMock.expect(countr.setCountry(count)).andReturn(true);
		EasyMock.replay(countr);		
		country = countr;
		return(true);
	}

	public boolean setPassword(String pw1, String pw2)
	{
		if(pw1 != pw2)
			return(false);
		if(pw1.length() < 8)
			return(false);
		this.pw=pw1;
		return(true);
	}
	public String getPassword()
	{
		return(this.pw);
	}
	public boolean setNameOfUser(String name)
	{
		boolean success = verifyName(name);
		
		if(success)
		{
			this.userFullName =name;
			return(true);
		}
		else
			return(false);
	}
	public boolean setUserName(String name)
	{
		boolean success = verifyUserName(name);
		if(success)
		{
			this.userName =name;
			return(true);
		}
		else
			return(false);
	}
	public String getName()
	{
		return(this.userFullName );
	}
	public String getUserName()
	{
		return(this.userName );
	}

	private boolean verifyName(String name)
	{
		String allowedChars = "abcdefghijklmnopqrstuvwxyz ";
		return(allowedCharacters(allowedChars, name));
	}
	private boolean verifyUserName(String name)
	{
		if (!(name.length() >0 && name.length() <= 15))	//name between 1 and 15 charcters
			return false;
		
		String nameCopy = name;
		int count = nameCopy.length() - nameCopy.replace("_", "").length();
		if(count>1)
			return false;

		String allowedChars = "abcdefghijklmnopqrstuvwxyz_";
		return(allowedCharacters(allowedChars, name));
	}
	//Method used to verify strings in both Mufasa class and Person class
	private boolean allowedCharacters(String allowed, String test_these)
	{
		test_these = test_these.toLowerCase();
		for (int i = 0; i < test_these.length(); i++)
		{
			String to_test = test_these.substring(i,i+1);
			if(!allowed.contains(to_test))
			{
				return false;
			}
		}
		return(true);	
	}
}
