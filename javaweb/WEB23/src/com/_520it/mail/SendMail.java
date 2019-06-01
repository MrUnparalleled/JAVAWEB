package com._520it.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("lucy@it.com", "测试邮件", "这是一封测试邮件");
	}
}
