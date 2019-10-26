package com.crmall.crmall;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages={"com.crmall"})
public class CrmallApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrmallApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        MediaType mediaType = new MediaType("application","x-www-form-urlencoded", Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(mediaType));
        converters.add(converter);
        super.configureMessageConverters(converters);
    }

}
