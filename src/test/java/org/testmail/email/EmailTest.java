package org.testmail.email;

import javax.mail.Message;

import java.util.List;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Kalana on 9/5/2017.
 */
public class EmailTest extends TestCase {

	private Email mail;
	@Override
	public void setUp() throws Exception {
		super.setUp();
		mail = new Email();


	}

	@Test
	public void testAddToRecipients() throws Exception {
		mail.addToRecipients("kalana@gmail.com;suraweera@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(1).getAddress(),"suraweera@gmail.com");

	}

	@Test
	public void testAddCcRecipients() throws Exception {
		mail.addCcRecipients("kalana@gmail.com;suraweera@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(1).getAddress(),"suraweera@gmail.com");
	}

	@Test
	public void testAddBccRecipients() throws Exception {
		mail.addBccRecipients("kalana@gmail.com;suraweera@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(1).getAddress(),"suraweera@gmail.com");
	}

	@Test
	public void testAddNamedToRecipients() throws Exception {
		mail.addNamedToRecipients("kalana","kalana@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(0).getName(), "kalana");

	}

	@Test
	public void testAddNamedCcRecipients() throws Exception {
		mail.addNamedCcRecipients("kalana","kalana@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(0).getName(), "kalana");
	}

	@Test
	public void testAddNamedBccRecipients() throws Exception {
		mail.addNamedBccRecipients("kalana","kalana@gmail.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(0).getName(), "kalana");
	}

	@Test
	public void testAddRecipients() throws Exception {
		mail.addRecipients("Kalana", Message.RecipientType.TO,"kalanasuraweera@gmail.com;jaga@yahoo.com");
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(recipients.get(0).getName(),"Kalana");
		assertEquals(recipients.get(0).getAddress(),"kalanasuraweera@gmail.com");
		assertEquals(recipients.get(1).getName(),"Kalana");
		assertEquals(recipients.get(1).getAddress(),"jaga@yahoo.com");

	}

}
