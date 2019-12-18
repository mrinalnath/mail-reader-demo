package org.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Value("${mail.receiver.host}")
	private String mailReceiverHost;

	@Value("${mail.receiver.username}")
	private String mailReceiverUserName;

	@Value("${mail.receiver.password}")
	private String mailReceiverPassword;

	@Value("${mail.receiver.folder}")
	private String mailReceiverFolder;

	public String getMailReceiverHost() {
		return mailReceiverHost;
	}

	public String getMailReceiverUserName() {
		return mailReceiverUserName;
	}

	public String getMailReceiverPassword() {
		return mailReceiverPassword;
	}

	public String getMailReceiverFolder() {
		return mailReceiverFolder;
	}

}
