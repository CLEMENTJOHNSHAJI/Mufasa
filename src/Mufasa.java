import java.util.ArrayList;
/*
Mufasa Account Holder Banking Details 
*/
public class Mufasa {
	private PersonsList owner;
	private AddressList address;
	private String pw;
	private String cardHolder;
	private String cardType;

	public AddressList getAddress()
	{
		return this.address;
	}
	public String getCardType()
	{
		return this.cardType;
	}

	public String getCardHolder()
	{
		return this.cardHolder;
	}
	
	public Mufasa(PersonsList owner)
	{
		this.owner=owner;
	}

	public boolean refund(BankingFunctionalities usersBank)
	{
		boolean response = usersBank.refund();
		return(response);
	}
	public boolean bankAttachment(String cvc, BankingFunctionalities usersBank)
	{
		if(cvc.length() != 3)
			return(false);
		boolean response = usersBank.deduct(0.01, cvc);
		return(response);
	}
	public boolean setCardType(String cardtype)
	{
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz";
		if(!(allowedCharacters(allowedCharacters, cardtype)))
			return false;
		ArrayList <String> cardTypes = new ArrayList<String>();
		cardTypes.add("VISA");
		cardTypes.add("Mastercard");
		cardTypes.add("Discover");
		boolean found = false;
		for (String temp : cardTypes)
		{
			if(cardtype == temp)
			{
				found=true;
				break;
			}
		}
		if(found==false)
			return(false);
		this.cardType=cardtype;
		return(true);
	}
	public boolean setAccountHolderName(String accHolder)
	{
		String allowedChars = "abcdefghijklmnopqrstuvwxyz ";
		if(!(allowedCharacters(allowedChars, accHolder)))
			return false;
		this.cardHolder=accHolder;
		return(true);
	}
	private boolean allowedCharacters(String allowed, String testSample)
	{
		testSample = testSample.toLowerCase();
		for (int i = 0; i < testSample.length(); i++)
		{
			String testSamp = testSample.substring(i,i+1);
			if(!allowed.contains(testSamp))
			{
				return false;
			}
		}
		return(true);	
	}
	public boolean setPassword(String pw1, String pw2)
	{
		if(pw1 != pw2)
			return(false);
		if(pw1.length() < 8)
			return(false);
		if(pw1 == owner.getPassword())	//Cannot be the same password as before
			return(false);
		this.pw=pw1;
		return(true);
	}
	
	public boolean setAddress(AddressList address)
	{
		this.address = address;
		return true;
	}
}
