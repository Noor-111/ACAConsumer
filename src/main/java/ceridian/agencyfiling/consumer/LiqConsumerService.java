package ceridian.agencyfiling.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ceridian.agencyfiling.service.LiquidTransformation;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@Service
public class LiqConsumerService {

	private final Logger logger = LoggerFactory.getLogger(LiqConsumerService.class);

	@KafkaListener(id = "myConsumer", topics = "purchases", groupId = "spring-boot", autoStartup = "false")
	public void listen(String value, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_KEY) String key) throws IOException {
		logger.info(String.format("Consumed event from topic %s: key = %-10s value = %s", topic, key, value));

		LiquidTransformation.liqTransform(value);

	}
}
