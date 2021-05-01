package com.qbo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration
public class SwaggerConfig {

	//Docket: que es lo que debe de tomar en cuanta al momento de crear la documentación
	//@Bean: Un bean es un objeto que es instanciado, ensamblado y administrado por un contenedor Spring
	//securityContexts: Configura qué operaciones de API (a través de patrones de expresiones regulares) y métodos HTTP para aplicar contextos de seguridad a las API
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())) 
				.securitySchemes(Arrays.asList(apiKey()))
				//.securityContexts(Arrays.asList(securityContext())) //Se agrega después de la prueba
				//.securitySchemes(Arrays.asList(apiKey())) //Se agrega después de la prueba
				.select()
				.apis(RequestHandlerSelectors.any())
				.build();

	}
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	//SecurityReference:  define los requisitos de seguridad para las apis
	private List<SecurityReference> defaultAuth(){
		//Se utiliza para definir un alcance de autorización que utiliza una operación para un esquema de autorización definido
		AuthorizationScope authorizationScope = 
				new AuthorizationScope("global", "accesEverything"); // El alcance del esquema de autorización OAuth2
		AuthorizationScope[] authorizationScopes = 
				new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	
	
	private ApiInfo apiInfo() {
		return new ApiInfo("API Rest QBO Institute", 
				"API Rest para el curso de Spring Boot", 
				"1.0",
				"Términos y condiciones del autor",
				new Contact("Luis Salvatierra", 
						"www.qboinstitute.com", 
						"info@qboinstitute.com"), 
				"Licencia",
				"API Licencia QBO", 
				Collections.emptyList());
	}

}
