package org.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailReceiver implements Processor {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailReceiver.class);

	@Override
	public void process(Exchange exchange) throws Exception {

		LOGGER.debug("************Inside MailReceiver: Exchange***********{}", exchange);
		if (exchange != null) {


			if (exchange.getIn().getBody() != null) {
				// get mail body text
				//MailBodyPart textContentBodyPart = getMailTextContent(exchange);
				LOGGER.info("Got mail {}", exchange.getIn().getBody());
				
			}


		}
	}
	
}
