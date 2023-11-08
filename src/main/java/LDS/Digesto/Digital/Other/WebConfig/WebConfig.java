package LDS.Digesto.Digital.Other.WebConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración que habilita el soporte para CORS (Cross-Origin Resource Sharing) en una aplicación Spring Boot.
 * Permite que la aplicación responda a solicitudes HTTP desde un origen diferente, como una aplicación Angular ejecutándose
 * en http://localhost:4200/. Esta configuración específica permite solicitudes HTTP desde dicho origen y define los métodos HTTP
 * permitidos, encabezados aceptados y el tiempo máximo de almacenamiento en caché.
 *
 * 
 * @author GONZALEZ ESPADA, José Ismael
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Value("${frontend.url}")
    private String frontendUrl;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontendUrl)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .maxAge(3600);
    }
}

