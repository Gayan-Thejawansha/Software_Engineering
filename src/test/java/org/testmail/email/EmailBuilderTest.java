package org.testmail.email;

import javax.mail.Message;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kalana on 9/4/2017.
 */
public class EmailBuilderTest extends TestCase {

	EmailBuilder builder;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.builder = new EmailBuilder();
		this.builder.from("jaga","jaga@gmail.com");
		this.builder.to("kalana","kalana@gmail.com");
		this.builder.cc("james","james@yahoo.com;james@gmail.com");
		this.builder.bcc("nalin","nalin@yahoo.com");
		this.builder.bcc("saman","saman@msn.com");
		this.builder.subject("testing");
		this.builder.text("This is just a test");

	}

	@Test
	public void testBuild() throws Exception {
		Email mail = this.builder.build();
		//testing from
		List<Recipient> recipients = mail.getRecipients();
		assertEquals(mail.getFromRecipient().getName(),"jaga");
		assertEquals(mail.getFromRecipient().getAddress(),"jaga@gmail.com");
		//testing to
		assertEquals(recipients.get(0).getName(),"kalana");
		assertEquals(recipients.get(0).getAddress(),"kalana@gmail.com");
		assertEquals(recipients.get(0).getType(), Message.RecipientType.TO);
		//testing cc
		assertEquals(recipients.get(1).getName(),"james");
		assertEquals(recipients.get(1).getAddress(),"james@yahoo.com");
		assertEquals(recipients.get(1).getType(), Message.RecipientType.CC);
		assertEquals(recipients.get(2).getName(),"james");
		assertEquals(recipients.get(2).getAddress(),"james@gmail.com");
		assertEquals(recipients.get(2).getType(), Message.RecipientType.CC);
		//testing bcc
		assertEquals(recipients.get(3).getName(),"nalin");
		assertEquals(recipients.get(3).getAddress(),"nalin@yahoo.com");
		assertEquals(recipients.get(3).getType(), Message.RecipientType.BCC);
		assertEquals(recipients.get(4).getName(),"saman");
		assertEquals(recipients.get(4).getAddress(),"saman@msn.com");
		assertEquals(recipients.get(4).getType(), Message.RecipientType.BCC);
		//testing subject
		assertEquals(mail.getSubject(),"testing");
		//testing text
		assertEquals(mail.getText(),"This is just a test");

	}



}
