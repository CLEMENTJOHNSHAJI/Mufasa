import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Test;

public class MufsaTestCases {
	
//	First and Last Name – where names contain only the Standard English letters
	@Test
	public void veriyWithValidFirstAndLastName()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setNameOfUser("Clement John");
		assertTrue(value);
	}
	@Test
	public void veriyWithInvalidFirstAndLastName()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setNameOfUser("1a!2aaa*");
		assertFalse(value);
	}
	
//	User name-contain digits along with the Standard English letters & can also use underscore (_) only once.	
	@Test
	public void veriyWithValidUserameContainingSingleUnderScore()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setUserName("abc_xyz");
		assertTrue(value);
	}
	
	@Test
	public void veriyWithUserameContainingMoreThanOneUnderScores()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setUserName("aaa_bbb_ccc");
		assertFalse(value);
	}
	
//	The maximum length of username is 15 characters
	@Test
	public void verify004_longUserName()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setUserName("qqqqqqqqqqqqqqqqqqqqqqqqqqq");
		assertFalse(value);
	}
	
//	Password – it should be 8 characters minimum and case-sensitive.
	@Test
	public void verifyWithValidPassword()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPassword("correctPassword","correctPassword");
		assertTrue(value);
	}
	@Test
	public void verifyingCaseSensitivityOfPasswords()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPassword("correctPassword","correctpassword");
		assertFalse(value);
	}
	@Test
	public void verifyingLenthOfPasswordIsGreterThanOrEqualTo8()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPassword("mypw","mypw");
		assertFalse(value);
	}

//	We also require them to re-enter their password as a mean to crosscheck their previously chosen password
	@Test
	public void verifyingReenteredPWMatchingOrNot()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPassword("correctPassword","correctPasswordS");
		assertFalse(value);
	}
	
	
//	User is able to select his country from the already provided list of countries	
	@Test
	public void verifyingCountryList()
	{
		//Mock eg1 - Countries Class should be working
		CountriesList count = EasyMock.createMock(CountriesList.class);		
		EasyMock.expect(count.getCountry()).andReturn("Finland");
		EasyMock.replay(count);
		assertEquals("Finland", count.getCountry());
	} 
	@Test
	public void verifyingPreSetCountry()
	{
		//Mock eg2 - Countries Class should be working
		CountriesList count = EasyMock.createMock(CountriesList.class);
		EasyMock.expect(count.setCountry("Finland")).andReturn(true);
		EasyMock.replay(count);
		assertTrue( count.setCountry("Finland"));
	}
	@Test
	public void verifyingCountry()
	{
		//Fake double eg1.setCountry function has fake implementation currently in the PersonList class.
		PersonsList user1 = new PersonsList();
		boolean value = user1.setCountry("Finland");
		assertTrue(value);
	}
	
//	User’s birthdate information is required in a format of dd/mm/yyyy.
	@Test
	public void verifyDateOfBirth()
	{
		//Fake double eg1.setCountry function has fake implementation currently in the PersonsList class.
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("11/11/1998");
		assertTrue(value);
	}
	@Test
	public void verifyDateOfBirthFormat()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("11-11-1998");
		assertFalse(value);
	}
	@Test
	public void verifyOrderOfDMYInDateOfBirthFormat()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("dd/mm/yyyy");
		assertFalse(value);
	}
	@Test
	public void verifyOrderOfDateInDateOfBirthFormat()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("77/02/1995");
		assertFalse(value);
	}
	@Test
	public void verifyOrderOfMonthInDateOfBirthFormat()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("11/22/1995");
		assertFalse(value);
	}
	@Test
	public void verifyOrderOfYearInDateOfBirthFormat()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("11/02/8888");
		assertFalse(value);
	}
	
//	check that users are at least 18 years old 
	@Test
	public void verifyUserIsGreaterThanOrEqualTo18Years()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.BDCheck("11/04/2018");
		assertFalse(value);
	}

//	We need user’s Phone Number but only in digits.
	@Test
	public void verifyWithValidPhoneNO()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPhone("1234567890");
		assertTrue(value);
	}
	@Test
	public void verifyWithInvalidPhoneNO()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setPhone("123aa45678");
		assertFalse(value);
	}

//	email address of the user should be provided twice. The second entry is to confirm and check the already entered one.
	@Test
	public void verifyWithValidEmailID()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setMail("abc@xyz.com","abc@xyz.com");
		assertTrue(value);
	}
	@Test
	public void verifingWithInvalidFormatOfEmailID()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setMail("abc@@xyz.com","abc@@xyz.com");
		assertFalse(value);
	}
	@Test
	public void verifyingReenteredEmailMatchingOrNot()
	{
		PersonsList user1 = new PersonsList();
		boolean value = user1.setMail("abc@xyz.com","xyz@xyz.com");
		assertFalse(value);
	}
	
//	Street Address (digits and alphabets only), City (only alphabetical characters), Postalcode (only digits and ‘-‘), Country – alphabetical characters only. The alphabets should come from the set of standard English alphabets.
	@Test
	public void verifWithValidSetStreetName()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setStreetName("Street 1");
		assertTrue(reply);
	}
	@Test
	public void verifWithInvalidSetStreetName()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setStreetName("Street-1");
		assertFalse(reply);
	}
	

	@Test
	public void verifWithValidCitytName()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setCityName("City One");
		assertTrue(reply);
	}
	@Test
	public void verifWithInvalidCitytName()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setCityName("City-One");
		assertFalse(reply);
	}

	@Test
	public void verifyWithValidPostalCode()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setPostalCode("111-111");
		assertTrue(reply);
	}

	@Test
	public void verifyWithInvalidPostalCode()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setPostalCode("111-  111");
		assertFalse(reply);
	}
	@Test
	public void verifyWithValidCountryPostalCode()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setCountry("Finland");
		assertTrue(reply);
	}
	@Test
	public void verifyWithInvalidCountryPostalCode()
	{
		AddressList anAddress = new AddressList();
		boolean reply = anAddress.setCountry("Finland123");
		assertFalse(reply);
	}	
	@Test
	public void verifyAdressOfMufasaAccount()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		AddressList anAddress = new AddressList();
		boolean reply = account.setAddress(anAddress);
		assertTrue(reply);
	}
		
//	Password – it should be 8 characters minimum and case-sensitive.
	@Test
	public void verifyWithValidBankingPassword()
	{
		PersonsList user1 = new PersonsList();
		user1.setPassword("myBankinPW","myBankinPW");
		Mufasa account = new Mufasa(user1);
		boolean reply = account.setPassword("myBankinPW11", "myBankinPW11");
		assertTrue(reply);
	}
	@Test
	public void verifyWithInvalidBankingPassword()
	{
		PersonsList user1 = new PersonsList();
		user1.setPassword("myBankinPW","myBankinPW");
		Mufasa account = new Mufasa(user1);
		boolean reply = account.setPassword("abcdefghijklmnop", "myBankinPW11");
		assertFalse(reply);
	}
	@Test
	public void verifyWithCaseSensitivityBankingPassword()
	{
		PersonsList user1 = new PersonsList();
		user1.setPassword("myBankinPW","myBankinPW");
		Mufasa account = new Mufasa(user1);
		boolean reply = account.setPassword("myBankingPW11", "myBankingpw11");
		assertFalse(reply);
	}
	@Test
	public void verifyingLenthOfBankingPasswordIsGreterThanOrEqualTo8()
	{
		PersonsList user1 = new PersonsList();
		user1.setPassword("myBankinPW","myBankinPW");
		Mufasa account = new Mufasa(user1);
		boolean reply = account.setPassword("abcdef", "abcdef");
		assertFalse(reply);
	}
	
//	We also require them to re-enter their password as a mean to crosscheck their previously chosen password
	@Test
	public void verifyingReenteredBankingPWMatchingOrNot()
	{
		PersonsList user1 = new PersonsList();
		user1.setPassword("myBankinPW","myBankinPW");
		Mufasa account = new Mufasa(user1);
		boolean reply = account.setPassword("myBankinPW", "myBankinpw");
		assertFalse(reply);
	}
	
//	In order to attach the bank-account, the user has to provide card holder name, type of the card(Mastercard,VISA, Discover), credit/debit card number and expiry date of the card.
	@Test
	public void verifyWithValidAccountHolder()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String strTemp = "Clement John";
		boolean reply = account.setAccountHolderName(strTemp);
		assertTrue(reply);
	}
	@Test
	public void verifyWithInvalidAccountHolder()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String strTemp = "Clement 123";
		boolean reply = account.setAccountHolderName(strTemp);
		assertFalse(reply);
	}
	@Test
	public void verifyWithValidCardType()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String strTemp = "Mastercard";
		boolean reply = account.setCardType(strTemp);
		assertTrue(reply);
	}
	@Test
	public void verifyWithInvalidCardType()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String strTemp = "VISAMastercard";
		boolean reply = account.setCardType(strTemp);
		assertFalse(reply);
	}
	@Test
	public void verifyBankAttachmentConfirmationWithValidCVC()
	{
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String cvc = "123";
		BankingFunctionalities bankUser1 = EasyMock.createMock(BankingFunctionalities.class);
		EasyMock.expect(bankUser1.deduct(0.01,cvc)).andReturn(true);
		EasyMock.replay(bankUser1);
		boolean reply = account.bankAttachment(cvc, bankUser1);
		assertTrue(reply);
	} 
	@Test
	public void verifyBankAttachmentConfirmationWithInalidCVC()
	{
		//Failed attempt to deduct money from users account
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String cvc = "222";
		BankingFunctionalities bankUser1 = EasyMock.createMock(BankingFunctionalities.class);
		EasyMock.expect(bankUser1.deduct(0.01,cvc)).andReturn(false);
		EasyMock.replay(bankUser1);
		boolean reply = account.bankAttachment(cvc, bankUser1);
		assertFalse(reply);
	}
	@Test
	public void verifyBankAttachmentConfirmationWithLongDigitCVC()
	{
		//long cvc.  deduction from users account failed
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		String cvc = "4456";
		BankingFunctionalities bankUser1 = EasyMock.createMock(BankingFunctionalities.class);
		EasyMock.expect(bankUser1.deduct(0.01,cvc)).andReturn(false);
		EasyMock.replay(bankUser1);
		boolean reply = account.bankAttachment(cvc, bankUser1);
		assertFalse(reply);
	}
	@Test
	public void verifySuccessRefundOfAmount()
	{
		//Refund from users account success
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		BankingFunctionalities bankUser1 = EasyMock.createMock(BankingFunctionalities.class);
		EasyMock.expect(bankUser1.refund()).andReturn(true);
		EasyMock.replay(bankUser1);
		boolean reply = account.refund(bankUser1);
		assertTrue(reply);
	}

	@Test
	public void verifyFailedRefundOfAmount()
	{//Refund from users account failed
		PersonsList user1 = new PersonsList();
		Mufasa account = new Mufasa(user1);
		BankingFunctionalities bankUser1 = EasyMock.createMock(BankingFunctionalities.class);
		EasyMock.expect(bankUser1.refund()).andReturn(false);
		EasyMock.replay(bankUser1);
		boolean reply = account.refund(bankUser1);
		assertFalse(reply);
	}

}
