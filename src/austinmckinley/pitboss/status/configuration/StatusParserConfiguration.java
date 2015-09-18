package austinmckinley.pitboss.status.configuration;

import austinmckinley.pitboss.status.StatusParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Configuration
public class StatusParserConfiguration {

    @Resource(mappedName = "logFileLocation")
    private String logFileLocation;

    @Bean
    StatusParser statusParser() {
        StatusParser parser = null;

        try {
            parser = new StatusParser(new BufferedReader(new FileReader(logFileLocation)));
        } catch (FileNotFoundException ex) {
            System.out.println("*********************************************************");
            System.out.println("Could not find a file at location " + logFileLocation);
            System.out.println("*********************************************************");
        } catch (Exception ex) {
            System.out.println("*********************************************************");
            System.out.println("Other exception for " + logFileLocation);
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
            System.out.println("*********************************************************");
        }

        return parser;
    }
}
