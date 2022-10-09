package com.swapi.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.Planet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SwapiDao {

    Planet getPlanet() {
        Client client = ClientBuilder.newClient();
        // TODO read in uri from properties file.
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Pojo mapped response.  Now jackson map pojo to this class.
        //Instantiate Jackson Object Mapper.
        ObjectMapper mapper = new ObjectMapper();
        // Create a planet and map it to the pojo json response.
        Planet planet = null;
        try {
            planet = mapper.readValue(response, Planet.class);
        } catch (JsonProcessingException e) {
            // TODO Set up logging and write to log.
            e.printStackTrace();
        }
        return planet;
    }
}
