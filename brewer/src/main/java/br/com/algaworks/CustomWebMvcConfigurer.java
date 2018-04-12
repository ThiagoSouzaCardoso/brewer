package br.com.algaworks;

import java.math.BigDecimal;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.algaworks.brewer.converter.EstiloConverter;

@Component
public class CustomWebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new EstiloConverter());
		
		NumberStyleFormatter bigDecimalFormatter = new NumberStyleFormatter("#,##0.00");
		registry.addFormatterForFieldType(BigDecimal.class, bigDecimalFormatter);
		
		NumberStyleFormatter integerFormatter = new NumberStyleFormatter("#,##0");
		registry.addFormatterForFieldType(Integer.class, integerFormatter);
	}
	
	
}
