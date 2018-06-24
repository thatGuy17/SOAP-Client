package com.example.worldcup;

import localhost._8000.worldcup.GetPlayerByNameResponse;
import localhost._8000.worldcup.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorldcupApplication {

    public static void main(String[] args){
        SpringApplication.run(WorldcupApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(WorldcupConnector worldcupConnector){
        return args -> {
            String playerName = "Eden Hazard";
            if (args.length > 0){
                playerName = args[0];
            }
//            GetPlayerByNameRequest nameRequest = new GetPlayerByNameRequest();
//            nameRequest.setName(playerName);

            GetPlayerByNameResponse nameResponse = worldcupConnector.getPlayerByNameResponse(playerName);
            Player player = nameResponse.getPlayer();
            System.out.println("Response received is...");
            System.out.println("---->>>> " + player.toString());
        };
    }
}
