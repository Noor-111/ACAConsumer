package ceridian.agencyfiling.consumer;

import java.io.IOException;

import ceridian.agencyfiling.service.LiquidTransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@Service
public class LiqConsumerService {

	@Autowired
	private LiquidTransformationService liquidTransformationService;

	private final Logger logger = LoggerFactory.getLogger(LiqConsumerService.class);

	@KafkaListener(id = "aca-liq-consumer", topics = "purchases", groupId = "spring-boot", autoStartup = "false")
	public void listen(String value, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_KEY) String key) throws IOException {
		logger.info(String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));

		process(value);

	}

	private void process(String input){
		liquidTransformationService.process(input);
	}
}
