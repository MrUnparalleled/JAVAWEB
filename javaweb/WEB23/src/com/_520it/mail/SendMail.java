package com._520it.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("lucy@it.com", "�����ʼ�", "����һ������ʼ�");
	}
}
