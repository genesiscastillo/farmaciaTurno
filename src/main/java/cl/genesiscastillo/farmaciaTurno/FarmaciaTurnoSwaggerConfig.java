package cl.genesiscastillo.farmaciaTurno;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class FarmaciaTurnoSwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("cl.genesiscastillo.farmaciaTurno.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Farmacia En Turno API",
				"Farmacia En Turno API Description",
				"1.0",
				"http://genesiscastillo.cl/terms",
				new Contact("genesiscastillo.cl", "http://genesiscastillo.cl", "genesiscastillo@hotmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
	
}
