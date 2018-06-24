package com.example.worldcup;

import localhost._8000.worldcup.GetPlayerByNameRequest;
import localhost._8000.worldcup.GetPlayerByNameResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WorldcupConnector extends WebServiceGatewaySupport {

    public GetPlayerByNameResponse getPlayerByNameResponse(String playerName){
        GetPlayerByNameRequest nameRequest = new GetPlayerByNameRequest();
        nameRequest.setName(playerName);

        GetPlayerByNameResponse nameResponse = (GetPlayerByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/worldcup",
                        nameRequest,
                        new SoapActionCallback("http://localhost:8080/worldcup")
                );

        return nameResponse;
    }
}
