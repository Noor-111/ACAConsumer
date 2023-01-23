package ceridian.agencyfiling.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;

import liqp.Template;
import org.springframework.stereotype.Component;

@Component
public class LiquidTransformationServiceImpl implements LiquidTransformationService {

	@Autowired
	private LiquidTemplateService liquidTemplateService;

	@Override
	public void process(String inputJson){
		//1. TODO: Get the agencyId from the inputMessage
		int agencyId = 1;
		//2. Get the LiquidTemplate for the agency
		String liquidTemplateString = liquidTemplateService.getLiquidTemplate(agencyId);
		//3. Do Liquid Transform
		String output = liquidTransform(inputJson,liquidTemplateString);
		//4. Write to file
		writeToFile(output,"C:\\Users\\P129CDD\\Projects\\ACA\\ACAConsumer2\\temp\\output.xml");

	}

	private static void writeToFile(String data, String filepath) {
		Path file = Paths.get(filepath);
		try {
			Files.write(file, data.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String liquidTransform(String jsonString, String templateString){
		Template template = Template.parse(templateString);
		return template.render(jsonString);
	}
}
