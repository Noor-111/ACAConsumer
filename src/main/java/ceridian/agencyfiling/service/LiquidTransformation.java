package ceridian.agencyfiling.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import liqp.Template;


public class LiquidTransformation {

	public static void liqTransform(String value) throws IOException {
		String jsonString = new String(value);
		File templateFile = new File("C:/Users/P128BC3/Downloads/IRS_ACA_TEST.liquid");
		// Parse the template
		Template templateEx = Template.parse(templateFile);
		// Render the template with the data
		String renderedTemplate = templateEx.render(jsonString);

		System.out.println(renderedTemplate);
	}
}
