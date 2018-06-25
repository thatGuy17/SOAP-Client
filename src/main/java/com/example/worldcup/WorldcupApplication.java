package com.example.worldcup;


import localhost._8080.worldcup.GetPlayerByCountryResponse;
import localhost._8080.worldcup.GetPlayerByNameResponse;
import localhost._8080.worldcup.Player;
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
            String[] searchString = {"Lionel Messi", "Belgium"};
            if (args.length > 0){
                searchString[0] = args[0];
            }

            GetPlayerByNameResponse nameResponse = worldcupConnector.getPlayerByNameResponse(searchString[0]);
            Player player = nameResponse.getPlayer();
            System.err.println("Response received for " + searchString[0] + " request is...");
            System.err.println("---->>>> " + player.getPlayerName());
            System.err.println("---->>>> " + player.getDateOfBirth());
            System.err.println("---->>>> " + player.getClubName());
            System.err.println("---->>>> " + player.getCountry());
            System.err.println("---->>>> " + player.getPosition());
            System.err.println("---->>>> " + player.getHeight());
            System.err.println("---->>>> " + player.getWeight());


            GetPlayerByCountryResponse countryResponse = worldcupConnector.getPlayerByCountryResponse(searchString[1]);
            Player player1 = countryResponse.getPlayer();
            System.err.println("Response received for " + searchString[1] + " request is...");
            System.err.println("---->>>> " + player1.getPlayerName());
            System.err.println("---->>>> " + player1.getDateOfBirth());
            System.err.println("---->>>> " + player1.getClubName());
            System.err.println("---->>>> " + player1.getCountry());
            System.err.println("---->>>> " + player1.getPosition());
            System.err.println("---->>>> " + player1.getHeight());
            System.err.println("---->>>> " + player1.getWeight());
        };
    }
}
