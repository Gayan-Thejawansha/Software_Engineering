package org.testmail.email;

import javax.mail.Message;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;


public class EmailTest extends TestCase {

	private Email mail;
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mail = new Email();


	}

	@Test
	public void testAddToRecipients() throws Exception {
		mail.addToRecipients("gayan@gmail.com;shanaka@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(1).getAddress(),"shanaka@gmail.com");

	}

	@Test
	public void testAddCcRecipients() throws Exception {
		mail.addCcRecipients("gayan@gmail.com;shanaka@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(1).getAddress(),"shanaka@gmail.com");
	}

	@Test
	public void testAddBccRecipients() throws Exception {
		mail.addBccRecipients("gayan@gmail.com;shanaka@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(1).getAddress(),"shanaka@gmail.com");
	}

	@Test
	public void testAddNamedToRecipients() throws Exception {
		mail.addNamedToRecipients("gayan","gayan@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(0).getName(), "gayan");

	}

	@Test
	public void testAddNamedCcRecipients() throws Exception {
		mail.addNamedCcRecipients("gayan","gayan@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(0).getName(), "gayan");
	}

	@Test
	public void testAddNamedBccRecipients() throws Exception {
		mail.addNamedBccRecipients("gayan","gayan@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(0).getName(), "gayan");
	}

	@Test
	public void testAddRecipients() throws Exception {
		mail.addRecipients("gayan", Message.RecipientType.TO,"gayanshanaka@gmail.com;tj@yahoo.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getName(),"gayan");
		assertEquals(recipients.get(0).getAddress(),"gayanshanaka@gmail.com");
		assertEquals(recipients.get(1).getName(),"gayan");
		assertEquals(recipients.get(1).getAddress(),"tj@yahoo.com");

	}

}
