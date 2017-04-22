package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.test.dataBuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {
	NotifyPersonService notifyPersonService;
	EmailService emailService;
	
	@Before
	public void setup(){
		emailService = Mockito.mock(EmailService.class);
		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest() {
		//Arrange
		Person person = new PersonTestDataBuilder().build();
		Mockito.when(emailService.sendEmail(Mockito.anyString())).thenReturn("Hola mundo");
		
		//Act 
		String message = notifyPersonService.notify(person);
		
		//Assert
		System.out.println(message);
		Assert.assertNull(message);

	}
}
