package com.samples.wsconsume;

import com.samples.wsconsume.classes.CountryClient;
import countries.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunWsConsumeApp {
    public static void main(String... args){
        SpringApplication.run(RunWsConsumeApp.class);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = quoteClient.getCountry(country);
            System.err.println(response.getCountry().getCurrency());
        };
    }
}
