package com.example.worldcup;

import localhost._8080.worldcup.GetPlayerByCountryRequest;
import localhost._8080.worldcup.GetPlayerByCountryResponse;
import localhost._8080.worldcup.GetPlayerByNameRequest;
import localhost._8080.worldcup.GetPlayerByNameResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WorldcupConnector extends WebServiceGatewaySupport {

    public GetPlayerByNameResponse getPlayerByNameResponse(String playerName){
        GetPlayerByNameRequest nameRequest = new GetPlayerByNameRequest();
        nameRequest.setName(playerName);

        GetPlayerByNameResponse nameResponse = (GetPlayerByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/worldcup/players",
                        nameRequest,
                        new SoapActionCallback("http://localhost:8080/worldcup/players")
                );

        return nameResponse;
    }

    public GetPlayerByCountryResponse getPlayerByCountryResponse(String countryName){
        GetPlayerByCountryRequest countryRequest = new GetPlayerByCountryRequest();
        countryRequest.setName(countryName);

        GetPlayerByCountryResponse countryResponse = (GetPlayerByCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/worldcup/players",
                        countryRequest,
                        new SoapActionCallback("http://localhost:8080/worldcup/players")
                );

        return countryResponse;
    }
}
