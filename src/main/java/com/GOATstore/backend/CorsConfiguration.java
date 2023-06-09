package com.GOATstore.backend;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") //mapeamento global
                .allowedOrigins("http://localhost:3000") //  permite solicitações apenas do domínio http://localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE, OPTIONS")
                .allowedHeaders("*") //  permite todos os cabeçalhos da solicitação
                .allowCredentials(true) // permite o compartilhamento de cookies de autenticação
                .maxAge(3600); // define o tempo de cache máximo para a resposta de preflight em segundos
			}
		};
	}
}




// @Configuration
// public class CorsConfiguration implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//             .allowedOrigins("http://localhost:3000")
//             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//     }
// }