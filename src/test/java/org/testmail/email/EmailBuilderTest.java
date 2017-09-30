package org.testmail.email;

import javax.mail.Message;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Test;


public class EmailBuilderTest extends TestCase {

	EmailBuilder builder;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.builder = new EmailBuilder();
		this.builder.from("thejawanshsa","thejawanshsa@gmail.com");
		this.builder.to("gayan","gayan@gmail.com");
		this.builder.cc("shanaka","shanaka@yahoo.com;shanaka@gmail.com");
		this.builder.bcc("dog","dog@yahoo.com");
		this.builder.bcc("cat","cat@msn.com");
		this.builder.subject("testing");
		this.builder.text("This is just a test");

	}

	@Test
	public void testBuild() throws Exception {
		Email mail = this.builder.build();
		//testing from
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(mail.getFromRecipient().getName(),"thejawanshsa");
		assertEquals(mail.getFromRecipient().getAddress(),"thejawanshsa@gmail.com");
		//testing to
		assertEquals(recipients.get(0).getName(),"gayan");
		assertEquals(recipients.get(0).getAddress(),"gayan@gmail.com");
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		//testing cc
		assertEquals(recipients.get(1).getName(),"shanaka");
		assertEquals(recipients.get(1).getAddress(),"shanaka@yahoo.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(2).getName(),"shanaka");
		assertEquals(recipients.get(2).getAddress(),"shanaka@gmail.com");
		assertEquals(recipients.get(2).getType(), Message.RecipientType.CC);
		//testing bcc
		assertEquals(recipients.get(3).getName(),"dog");
		assertEquals(recipients.get(3).getAddress(),"dog@yahoo.com");
		assertEquals(recipients.get(3).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(4).getName(),"cat");
		assertEquals(recipients.get(4).getAddress(),"cat@msn.com");
		assertEquals(recipients.get(4).getType(), Message.RecipientType.BCC);
		//testing subject
		assertEquals(mail.getSubject(),"testing");
		//testing text
		assertEquals(mail.getText(),"This is just a test");

	}



}
