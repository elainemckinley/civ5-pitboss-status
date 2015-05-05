package austinmckinley.pitboss.status.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

@Configuration
public class JndiConfiguration {
    @Bean
    JndiTemplate jndiTemplate() {
        return new JndiTemplate();
    }
}
