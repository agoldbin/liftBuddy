package com.aarongoldbin.persistence;


import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import org.geonames.Response;
import org.junit.Test;
import static org.junit.Assert.*;



public class PostalCodeTest {

    @Test
    public void testGeonamesJsonApi() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://api.geonames.org/findNearbyPostalCodesJSON" +
                        "?postalcode=53713&country=US&radius=16.1&maxRows=50&username=agoldbin");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response zipResponse = mapper.readValue(response, Response.class);

        // test how many zips are returned
        assertEquals(38, zipResponse.getPostalCodes().size());
        // test first/closest zip returned that isn't passed in zip
        assertEquals("53774", zipResponse.getPostalCodes().get(1).getPostalCode());
    }
}


