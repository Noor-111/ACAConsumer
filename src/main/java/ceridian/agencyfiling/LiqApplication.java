package ceridian.agencyfiling;

import ceridian.agencyfiling.dao.AgencyRepository;
import ceridian.agencyfiling.entity.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.List;


@SpringBootApplication
public class LiqApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LiqApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
	}

	@Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
//        	MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("myConsumer");
//            listenerContainer.start();
            System.out.println("Started Database call...");
            List<Agency> agencies = getAllAgencies();
            for (Agency agency: agencies) {

                System.out.println("Agency = " + agency.getAgencyId() + " : " + agency.getAgencyDescription());
            }

            };
        }

    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }
    @Autowired
    private AgencyRepository agencyRepository;
	 @Autowired
	    private  KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

}
