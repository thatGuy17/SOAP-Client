package com.example.worldcup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WorldcupConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("localhost._8080.worldcup");
        return jaxb2Marshaller;
    }

    @Bean
    public WorldcupConnector connector(Jaxb2Marshaller marshaller) {
        WorldcupConnector worldcupConnector = new WorldcupConnector();
        worldcupConnector.setDefaultUri("http://localhost:8080/worldcup");
        worldcupConnector.setMarshaller(marshaller);
        worldcupConnector.setUnmarshaller(marshaller);
        return worldcupConnector;
    }
}
