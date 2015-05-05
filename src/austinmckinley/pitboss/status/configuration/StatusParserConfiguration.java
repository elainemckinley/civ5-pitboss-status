package austinmckinley.pitboss.status.configuration;

import austinmckinley.pitboss.status.StatusParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Configuration
public class StatusParserConfiguration {

    @Autowired JndiTemplate jndiTemplate;

    @Bean
    StatusParser statusParser() {
        StatusParser parser = null;
        String logFileLocation = null;

        try {
            logFileLocation = jndiTemplate.lookup("logFileLocation", String.class);
            parser = new StatusParser(new BufferedReader(new FileReader(logFileLocation)));
        } catch (FileNotFoundException ex) {
            System.err.println("Could not find a file at location " + logFileLocation);
        } catch (NamingException ex) {
            System.err.println("Could not find a logFileLocation element in the JNDI configuration.");
        }
        return parser;
    }
}
