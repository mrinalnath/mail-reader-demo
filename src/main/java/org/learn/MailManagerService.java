package org.learn;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailManagerService extends RouteBuilder{
	
	@Autowired
	private ApplicationConfiguration applicationConfiguration;
	
	@Autowired
	private MailReceiver mailReceiver;

	@Override
	public void configure() throws Exception {
		//this.ctx = this.getContext();
		
		from(fromEmailReceiverEndpoint()).process(mailReceiver).routeId("123").autoStartup(true);
		
	}
	
	private String fromEmailReceiverEndpoint() {
		String host = applicationConfiguration.getMailReceiverHost();
		String username = applicationConfiguration.getMailReceiverUserName();
		String password = applicationConfiguration.getMailReceiverPassword();
		String folder = applicationConfiguration.getMailReceiverFolder();
		
		return "imap://" + host + ":993?"	+ "username=" + username + "&" + "password=" + password 
				+ "&debugMode=true&unseen=true&" + "folderName=" 
				+ folder + "&session=#emailSession";
		//+ "&connectionTimeout=100000";//+ setSSLPropertiesIfRequired(instance);
	}

}
